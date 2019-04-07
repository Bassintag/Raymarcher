package com.bassintag.raymarcher.rendering.objects.impl;

import com.bassintag.raymarcher.Color;
import com.bassintag.raymarcher.Vector3d;

/**
 * Torus.java created for Raymarcher
 *
 * @author Antoine
 * @version 1.0
 * @since 07/04/2019
 */
public class Torus extends Object {

    private double majorRadius;
    private double minorRadius;

    public Torus(Color color, double majorRadius, double minorRadius) {
        super(color);
        this.majorRadius = majorRadius;
        this.minorRadius = minorRadius;
    }

    @Override
    public double distance(Vector3d position) {
        return new Vector3d(position.xz().length() - majorRadius, position.getY(), 0).length() - minorRadius * 2;
    }

    public double getMajorRadius() {
        return majorRadius;
    }

    public void setMajorRadius(double majorRadius) {
        this.majorRadius = majorRadius;
    }

    public double getMinorRadius() {
        return minorRadius;
    }

    public void setMinorRadius(double minorRadius) {
        this.minorRadius = minorRadius;
    }
}
