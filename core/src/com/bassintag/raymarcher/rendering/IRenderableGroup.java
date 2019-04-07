package com.bassintag.raymarcher.rendering;

/**
 * IRenderableGroup.java created for Raymarcher
 *
 * @author Antoine
 * @version 1.0
 * @since 06/04/2019
 */
public interface IRenderableGroup extends ITransformable, IRenderable {

    void addRenderable(IRenderable renderable);
}
