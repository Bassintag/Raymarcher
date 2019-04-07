package com.bassintag.raymarcher.rendering.objects.impl;

import com.bassintag.raymarcher.Color;
import com.bassintag.raymarcher.Vector3d;

/**
 * Cube.java created for Raymarcher
 *
 * @author Antoine
 * @version 1.0
 * @since 07/04/2019
 */
public class Cube extends Object {

    private Vector3d size = Vector3d.ONE;

    public Cube(Color color) {
        super(color);
    }

    public Cube(Color color, Vector3d size) {
        super(color);
        this.size = size;
    }

    public Cube(Color color, double size) {
        super(color);
        this.size = new Vector3d(size);
    }

    @Override
    public double distance(Vector3d p) {
        var d = p.abs().substract(size);
        return d.max(Vector3d.ZERO).length() + Math.min(Math.max(d.getX(), Math.max(d.getY(), d.getZ())), 0);
    }
}
