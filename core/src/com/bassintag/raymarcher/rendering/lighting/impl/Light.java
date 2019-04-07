package com.bassintag.raymarcher.rendering.lighting.impl;

import com.bassintag.raymarcher.Color;
import com.bassintag.raymarcher.rendering.impl.Transformable;
import com.bassintag.raymarcher.rendering.lighting.ILight;

/**
 * Light.java created for Raymarcher
 *
 * @author Antoine
 * @version 1.0
 * @since 07/04/2019
 */
public class Light extends Transformable implements ILight {

    private double intensity;

    private Color color;

    public Light(double intensity, Color color) {
        this.intensity = intensity;
        this.color = color;
    }

    public Light(double intensity) {
        this.intensity = intensity;
        this.color = Color.WHITE;
    }

    public Light(Color color) {
        this.intensity = 1;
        this.color = color;
    }

    public Light() {
        this.intensity = 1;
        this.color = Color.WHITE;
    }

    @Override
    public double getIntensity() {
        return intensity;
    }

    @Override
    public Color getColor() {
        return color;
    }
}
