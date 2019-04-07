package com.bassintag.raymarcher.scene;

import com.bassintag.raymarcher.Vector3d;
import com.bassintag.raymarcher.rendering.IRenderOutput;
import com.bassintag.raymarcher.rendering.IRenderable;

/**
 * IRayRenderOutput.java created for Raymarcher
 *
 * @author Antoine
 * @version 1.0
 * @since 06/04/2019
 */
public interface IRayRenderOutput extends IRenderOutput {

    void sddStep(IRenderOutput renderOutput);

    IRenderOutput[] getSteps();

    int getStepsCount();

    boolean hit();

    Vector3d getHitPosition();

    IRenderable getHit();

    Vector3d getNormal();
}
