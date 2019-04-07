package com.bassintag.raymarcher.rendering;

import com.bassintag.raymarcher.Vector3d;

/**
 * IRenderable.java created for Raymarcher
 *
 * @author Antoine
 * @version 1.0
 * @since 06/04/2019
 */
public interface IRenderable {

    IRenderOutput render(Vector3d position);
}
