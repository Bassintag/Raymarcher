package com.bassintag.raymarcher.rendering.impl;

import com.bassintag.raymarcher.Transform;
import com.bassintag.raymarcher.rendering.ITransformable;

/**
 * Transformable.java created for Raymarcher
 *
 * @author Antoine
 * @version 1.0
 * @since 07/04/2019
 */
public abstract class Transformable implements ITransformable {

    private Transform transform;

    public Transformable(Transform transform) {
        this.transform = transform;
    }

    public Transformable() {
        this.transform = new Transform();
    }

    @Override
    public Transform getTransform() {
        return transform;
    }
}
