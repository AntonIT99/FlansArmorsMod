package com.flansmod.client.tmt;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmodultimate.client.model.ModelBase;
import com.flansmodultimate.client.render.EnumRenderPass;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.wolffsmod.api.client.model.IModelRenderer;
import org.joml.Matrix3f;
import org.joml.Matrix4f;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

class ModelRendererTurboRenderingTest
{
    @Test
    void customArmourRegistersPartsThroughModelContract()
    {
        ModelCustomArmour model = new ModelCustomArmour();
        new ModelRendererTurbo(model, 0, 0);

        AtomicInteger modelBoxCount = new AtomicInteger();
        model.forEachModelBox(modelRenderer -> modelBoxCount.incrementAndGet());

        assertEquals(1, modelBoxCount.get());
    }

    @Test
    void interfaceTypedChildIsRetainedAndRendered()
    {
        ModelBase model = new ModelBase() {};
        IModelRenderer parent = new ModelRendererTurbo(model, 0, 0);
        IModelRenderer child = new ModelRendererTurbo(model, 0, 0);
        child.addBox(0, 0, 0, 1, 1, 1);

        parent.addChild(child);
        RecordingVertexConsumer vertices = new RecordingVertexConsumer();
        parent.render(new PoseStack(), vertices, 17, 23, 1, 1, 1, 1, 1);

        assertFalse(vertices.vertices.isEmpty());
    }

    @Test
    void leafCacheMatchesStackPathAcrossAnimationScaleAndRotationOrderChanges()
    {
        ModelRendererTurbo leaf = box();
        ModelRendererTurbo reference = box();
        ModelRendererTurbo invisibleChild = box();
        invisibleChild.isHidden = true;
        reference.addChild(invisibleChild); // Retains the original parent/child stack path.

        CountingPoseStack parent = new CountingPoseStack();
        for (boolean oldOrder : new boolean[]{false, true, false})
        {
            for (float scale : new float[]{1F, 0.0625F, 2F, -0.5F, 0F, 1F})
            {
                for (int state = 0; state < 12; state++)
                {
                    // Change each cache input separately, then render the unchanged pose twice.
                    mutate(leaf, state);
                    copyTransform(leaf, reference);
                    for (int instance = 0; instance < 2; instance++)
                    {
                        parent.setIdentity();
                        parent.translate(7 + state, -3, 9 + instance);
                        parent.mulPose(Axis.YP.rotation(0.7F + instance));
                        parent.scale(1.2F, 0.8F, 0.4F);
                        Matrix4f originalPosition = new Matrix4f(parent.last().pose());
                        Matrix3f originalNormal = new Matrix3f(parent.last().normal());

                        RecordingVertexConsumer actual = new RecordingVertexConsumer();
                        int pushes = parent.pushes;
                        leaf.render(parent, actual, 17, 23, 0.2F, 0.3F, 0.4F, 0.5F,
                            scale, EnumRenderPass.DEFAULT, oldOrder);
                        if (scale > 0F)
                            assertEquals(pushes, parent.pushes, "Cached leaf draws must not push the caller's stack");
                        assertEquals(originalPosition, parent.last().pose());
                        assertEquals(originalNormal, parent.last().normal());

                        RecordingVertexConsumer expected = new RecordingVertexConsumer();
                        reference.render(parent, expected, 17, 23, 0.2F, 0.3F, 0.4F, 0.5F,
                            scale, EnumRenderPass.DEFAULT, oldOrder);
                        assertEquals(expected.vertices.size(), actual.vertices.size());
                        for (int i = 0; i < actual.vertices.size(); i++)
                            assertArrayEquals(expected.vertices.get(i), actual.vertices.get(i), 2E-5F);
                        assertTrue(parent.clear());
                    }
                }
            }
        }
    }

    @Test
    void eightSidedWheelExtrusionUses56VerticesAndCacheSurvivesUvRescaling()
    {
        ModelRendererTurbo wheel = new ModelRendererTurbo(new ModelBase() {}, 0, 0, 64, 32);
        Coord2D[] points = {new Coord2D(4, 0, 4, 0), new Coord2D(11, 0, 11, 0),
            new Coord2D(15, 4, 15, 4), new Coord2D(15, 11, 15, 11), new Coord2D(11, 15, 11, 15),
            new Coord2D(4, 15, 4, 15), new Coord2D(0, 11, 0, 11), new Coord2D(0, 4, 0, 4)};
        wheel.addShape3D(0, 0, 0, new Shape2D(points), 2, 15, 15, 52, 2, 0);
        wheel.rotationPointX = 32;
        RecordingVertexConsumer before = new RecordingVertexConsumer();
        wheel.render(new PoseStack(), before, 17, 23, 1, 1, 1, 1, 1);
        assertEquals(56, before.vertices.size()); // Formerly 80, with the same 28 triangles.
        assertTrue(wheel.applyActualTextureSize(128, 32));
        RecordingVertexConsumer after = new RecordingVertexConsumer();
        wheel.render(new PoseStack(), after, 17, 23, 1, 1, 1, 1, 1);
        assertEquals(before.vertices.size(), after.vertices.size());
        for (int i = 0; i < before.vertices.size(); i++)
        {
            float[] expected = before.vertices.get(i).clone();
            expected[7] *= 0.5F;
            assertArrayEquals(expected, after.vertices.get(i));
        }
    }

    private static ModelRendererTurbo box()
    {
        ModelRendererTurbo part = new ModelRendererTurbo(new ModelBase() {}, 0, 0);
        part.addBox(1, 2, 3, 4, 5, 6);
        return part;
    }

    private static void mutate(ModelRendererTurbo part, int state)
    {
        switch (state)
        {
            case 0 -> part.offsetX += 0.2F;
            case 1 -> part.offsetY -= 0.3F;
            case 2 -> part.offsetZ += 0.4F;
            case 3 -> part.rotationPointX += 2F;
            case 4 -> part.rotationPointY -= 3F;
            case 5 -> part.rotationPointZ += 4F;
            case 6 -> part.rotateAngleX += 0.1F;
            case 7 -> part.rotateAngleY -= 0.2F;
            case 8 -> part.rotateAngleZ += 0.3F;
            case 9 -> { part.rotateAngleX = 0; part.rotateAngleY = 0; part.rotateAngleZ = 0; }
            case 10 -> { part.offsetX = 0; part.offsetY = 0; part.offsetZ = 0; }
            case 11 -> { part.rotationPointX = 0; part.rotationPointY = 0; part.rotationPointZ = 0; }
            default -> throw new AssertionError();
        }
    }

    private static void copyTransform(ModelRendererTurbo from, ModelRendererTurbo to)
    {
        to.offsetX = from.offsetX; to.offsetY = from.offsetY; to.offsetZ = from.offsetZ;
        to.rotationPointX = from.rotationPointX; to.rotationPointY = from.rotationPointY;
        to.rotationPointZ = from.rotationPointZ;
        to.rotateAngleX = from.rotateAngleX; to.rotateAngleY = from.rotateAngleY; to.rotateAngleZ = from.rotateAngleZ;
    }

    private static final class CountingPoseStack extends PoseStack
    {
        private int pushes;

        @Override
        public void pushPose()
        {
            pushes++;
            super.pushPose();
        }
    }
}
