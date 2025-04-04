package com.wolffsmod.client.model;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.VertexBuffer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class Tessellator
{
    private final BufferBuilder buffer;
    private final VertexBuffer vertexBuffer = new VertexBuffer(VertexBuffer.Usage.STATIC);
    /** The static instance of the Tessellator. */
    private static final Tessellator INSTANCE = new Tessellator(2097152);

    public static Tessellator getInstance()
    {
        return INSTANCE;
    }

    public Tessellator(int bufferSize)
    {
        this.buffer = new BufferBuilder(bufferSize);
    }

    /**
     * Draws the data set up in this tessellator and resets the state to prepare for new drawing.
     */
    public void draw()
    {
        // Finish adding vertices to the buffer
        BufferBuilder.RenderedBuffer renderedBuffer =  buffer.end();

        // Upload the vertex data to the GPU
        vertexBuffer.upload(renderedBuffer);

        // Set OpenGL states and render the buffer
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
    }

    public BufferBuilder getBuffer()
    {
        return buffer;
    }
}