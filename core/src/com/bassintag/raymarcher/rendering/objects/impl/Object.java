package com.bassintag.raymarcher.rendering.objects.impl;

import com.bassintag.raymarcher.Color;
import com.bassintag.raymarcher.Vector3d;
import com.bassintag.raymarcher.rendering.IRenderOutput;
import com.bassintag.raymarcher.rendering.impl.RenderOutput;
import com.bassintag.raymarcher.rendering.impl.Transformable;
import com.bassintag.raymarcher.rendering.objects.IObject;

/**
 * Object.java created for Raymarcher
 *
 * @author Antoine
 * @version 1.0
 * @since 06/04/2019
 */
public abstract class Object extends Transformable implements IObject {

    private Color color;

    public Object(Color color) {
        this.color = color;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public IRenderOutput render(Vector3d position) {
        return new RenderOutput(distance(position.apply(getTransform().getInverseMatrix())), this, color);
    }

    public abstract double distance(Vector3d position);

    public void setColor(Color color) {
        this.color = color;
    }
}
