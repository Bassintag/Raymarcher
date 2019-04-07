package com.bassintag.raymarcher.rendering.objects.impl;

import com.bassintag.raymarcher.Color;
import com.bassintag.raymarcher.Vector3d;

/**
 * Plane.java created for Raymarcher
 *
 * @author Antoine
 * @version 1.0
 * @since 07/04/2019
 */
public class Plane extends Object{

    public Plane(Color color) {
        super(color);
    }

    @Override
    public double distance(Vector3d position) {
        return position.getZ();
    }
}
