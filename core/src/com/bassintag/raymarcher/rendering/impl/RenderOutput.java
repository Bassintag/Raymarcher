package com.bassintag.raymarcher.rendering.impl;

import com.bassintag.raymarcher.Color;
import com.bassintag.raymarcher.rendering.IRenderOutput;
import com.bassintag.raymarcher.rendering.IRenderable;

/**
 * RenderOutput.java created for Raymarcher
 *
 * @author Antoine
 * @version 1.0
 * @since 06/04/2019
 */
public class RenderOutput implements IRenderOutput {

    private final double      distance;
    private final IRenderable closest;
    private final Color       color;

    public RenderOutput(double distance, IRenderable closest, Color color) {
        this.distance = distance;
        this.closest = closest;
        this.color = color;
    }

    @Override
    public double getDistance() {
        return distance;
    }

    @Override
    public IRenderable getClosest() {
        return closest;
    }

    @Override
    public Color getColor() {
        return color;
    }
}
