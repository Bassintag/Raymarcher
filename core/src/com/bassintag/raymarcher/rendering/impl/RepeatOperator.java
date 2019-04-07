package com.bassintag.raymarcher.rendering.impl;

import com.bassintag.raymarcher.Vector3d;
import com.bassintag.raymarcher.rendering.IOperator;
import com.bassintag.raymarcher.rendering.IRenderOutput;
import com.bassintag.raymarcher.rendering.IRenderable;

/**
 * RepeatOperator.java created for Raymarcher
 *
 * @author Antoine
 * @version 1.0
 * @since 07/04/2019
 */
public class RepeatOperator implements IOperator {

    private final IRenderable child;
    private final Vector3d    spacing;

    public RepeatOperator(IRenderable child, Vector3d spacing) {
        this.child = child;
        this.spacing = spacing;
    }

    @Override
    public IRenderOutput render(Vector3d position) {
        var out = child.render(position.abs().mod(spacing).substract(spacing.multiply(0.5)));
        return new RenderOutput(out.getDistance(), this, out.getColor());
    }
}
