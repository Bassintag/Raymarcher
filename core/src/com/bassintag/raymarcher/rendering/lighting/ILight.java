package com.bassintag.raymarcher.rendering.lighting;

import com.bassintag.raymarcher.Color;
import com.bassintag.raymarcher.rendering.ITransformable;

/**
 * ILight.java created for Raymarcher
 *
 * @author Antoine
 * @version 1.0
 * @since 07/04/2019
 */
public interface ILight extends ITransformable {

    double getIntensity();

    Color getColor();
}
