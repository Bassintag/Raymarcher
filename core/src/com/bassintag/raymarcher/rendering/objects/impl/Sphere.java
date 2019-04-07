package com.bassintag.raymarcher.rendering.objects.impl;

import com.bassintag.raymarcher.Color;
import com.bassintag.raymarcher.Vector3d;

/**
 * Sphere.java created for Raymarcher
 *
 * @author Antoine
 * @version 1.0
 * @since 06/04/2019
 */
public class Sphere extends Object {

    private double radius;

    public Sphere(Color color, double radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    public double distance(Vector3d position) {
        return position.length() - radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
