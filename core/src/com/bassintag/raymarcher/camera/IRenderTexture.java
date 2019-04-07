package com.bassintag.raymarcher.camera;

import com.bassintag.raymarcher.Color;

/**
 * IRenderTexture.java created for Raymarcher
 *
 * @author Antoine
 * @version 1.0
 * @since 06/04/2019
 */
public interface IRenderTexture {

    int getWidth();

    int getHeight();

    Color getAt(int x, int y);

    Color[] getData();
}
