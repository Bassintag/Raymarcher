package com.bassintag.raymarcher.rendering.objects;

import com.bassintag.raymarcher.Color;
import com.bassintag.raymarcher.Vector3d;
import com.bassintag.raymarcher.rendering.IRenderable;
import com.bassintag.raymarcher.rendering.ITransformable;

/**
 * IObject.java created for Raymarcher
 *
 * @author Antoine
 * @version 1.0
 * @since 06/04/2019
 */
public interface IObject extends ITransformable, IRenderable {

    Color getColor();

    double distance(Vector3d position);
}
