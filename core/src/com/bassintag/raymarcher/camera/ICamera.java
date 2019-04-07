package com.bassintag.raymarcher.camera;

import com.bassintag.raymarcher.scene.IScene;

/**
 * ICamera.java created for Raymarcher
 *
 * @author Antoine
 * @version 1.0
 * @since 06/04/2019
 */
public interface ICamera {

    IRenderTexture renderScene(IScene scene);
}
