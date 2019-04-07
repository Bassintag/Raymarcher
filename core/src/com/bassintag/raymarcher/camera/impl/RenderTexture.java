package com.bassintag.raymarcher.camera.impl;

import com.bassintag.raymarcher.Color;
import com.bassintag.raymarcher.Vector2i;
import com.bassintag.raymarcher.camera.IRenderTexture;

/**
 * RenderTexture.java created for Raymarcher
 *
 * @author Antoine
 * @version 1.0
 * @since 06/04/2019
 */
public class RenderTexture implements IRenderTexture {

    private final int     width;
    private final int     height;
    private final Color[] data;

    public RenderTexture(int width, int height) {
        this.width = width;
        this.height = height;
        this.data = new Color[width * height];
    }

    public RenderTexture(Vector2i size) {
        this(size.getX(), size.getY());
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public Color getAt(int x, int y) {
        return data[y * width + x];
    }

    public void setAt(int x, int y, Color color) {
        this.data[y * width + x] = color;
    }

    @Override
    public Color[] getData() {
        return data;
    }
}
