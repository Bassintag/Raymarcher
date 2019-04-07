package com.bassintag.raymarcher.rendering.objects.impl;

import com.bassintag.raymarcher.Color;
import com.bassintag.raymarcher.Vector3d;

/**
 * Cone.java created for Raymarcher
 *
 * @author Antoine
 * @version 1.0
 * @since 07/04/2019
 */
public class Cone extends Object {

    private double height;
    private double radius;
    private Vector3d c;

    public Cone(Color color, double height, double radius) {
        super(color);
        this.height = height;
        this.radius = radius;
        calculateC();
    }

    @SuppressWarnings("SuspiciousNameCombination")
    private void calculateC() {
        c = new Vector3d(height, radius, 0).normalize();
    }

    @Override
    public double distance(Vector3d position) {
        var q = position.xy().length();
        return c.dot(new Vector3d(q, position.getZ(), 0));
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
        calculateC();
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
        calculateC();
    }
}
