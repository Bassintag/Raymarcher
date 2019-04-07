package com.bassintag.raymarcher.rendering;

import com.bassintag.raymarcher.Color;

/**
 * IRenderOutput.java created for Raymarcher
 *
 * @author Antoine
 * @version 1.0
 * @since 06/04/2019
 */
public interface IRenderOutput {

    double getDistance();

    IRenderable getClosest();

    Color getColor();
}
