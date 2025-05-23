package com.flansmod.client.tmt;

import net.minecraft.world.phys.Vec3;

import java.util.ArrayList;

public class PositionTransformVertex extends PositionTextureVertex
{
    public Vec3 neutralVector;
    public ArrayList<TransformGroup> transformGroups = new ArrayList<>();

    public PositionTransformVertex(float x, float y, float z, float u, float v)
    {
        this(new Vec3(x, y, z), u, v);
    }

    public PositionTransformVertex(PositionTextureVertex vertex, float u, float v)
    {
        super(vertex, u, v);
        if (vertex instanceof PositionTransformVertex positionTransformVertex)
            neutralVector = positionTransformVertex.neutralVector;
        else
            neutralVector = new Vec3(vertex.vector3D.x, vertex.vector3D.y, vertex.vector3D.z);
    }

    public PositionTransformVertex(PositionTextureVertex vertex)
    {
        this(vertex, vertex.texturePositionX, vertex.texturePositionY);
    }

    public PositionTransformVertex(Vec3 vector, float u, float v)
    {
        super(vector, u, v);
        neutralVector = new Vec3(vector.x, vector.y, vector.z);
    }

    public void setTransformation()
    {
        if(transformGroups.isEmpty())
        {
            vector3D = new Vec3(neutralVector.x, neutralVector.y, neutralVector.z);
            return;
        }
        double weight = 0D;
        for(TransformGroup transformGroup : transformGroups)
        {
            weight += transformGroup.getWeight();
        }
        vector3D = new Vec3(0, 0, 0);

        for(TransformGroup group : transformGroups)
        {
            double cWeight = group.getWeight() / weight;
            Vec3 vector = group.doTransformation(this);

            vector3D = new Vec3(vector3D.x + cWeight * vector.x, vector3D.y + cWeight * vector.y, vector3D.z + cWeight * vector.z);
        }
    }

    public void addGroup(TransformGroup group)
    {
        transformGroups.add(group);
    }

    public void removeGroup(TransformGroup group)
    {
        transformGroups.remove(group);
    }
}
