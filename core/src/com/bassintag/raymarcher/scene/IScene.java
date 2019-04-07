package com.bassintag.raymarcher.scene;

import com.bassintag.raymarcher.Color;
import com.bassintag.raymarcher.Vector3d;
import com.bassintag.raymarcher.rendering.lighting.ILight;

/**
 * IScene.java created for Raymarcher
 *
 * @author Antoine
 * @version 1.0
 * @since 06/04/2019
 */
public interface IScene {

    IRayRenderOutput castRay(Vector3d position, Vector3d direction, double threshold, double culling);

    void addLight(ILight light);

    Iterable<ILight> getLights();
}
