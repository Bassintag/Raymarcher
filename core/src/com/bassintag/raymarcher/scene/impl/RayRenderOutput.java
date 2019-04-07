package com.bassintag.raymarcher.scene.impl;

import com.bassintag.raymarcher.Color;
import com.bassintag.raymarcher.Vector3d;
import com.bassintag.raymarcher.rendering.IRenderOutput;
import com.bassintag.raymarcher.rendering.IRenderable;
import com.bassintag.raymarcher.rendering.objects.IObject;
import com.bassintag.raymarcher.scene.IRayRenderOutput;

import java.util.ArrayList;
import java.util.List;

/**
 * RayRenderOutput.java created for Raymarcher
 *
 * @author Antoine
 * @version 1.0
 * @since 06/04/2019
 */
public class RayRenderOutput implements IRayRenderOutput {

    private double      distance;
    private IRenderable closest;
    private IRenderable hit;
    private Vector3d    normal;
    private Vector3d    hitPosition;

    private List<IRenderOutput> steps;

    public RayRenderOutput() {
        steps = new ArrayList<>();
        distance = Double.MAX_VALUE;
    }

    @Override
    public double getDistance() {
        return distance;
    }

    @Override
    public IRenderable getClosest() {
        return closest;
    }

    @Override
    public Color getColor() {
        return steps.get(steps.size() - 1).getColor();
    }

    @Override
    public void sddStep(IRenderOutput renderOutput) {
        steps.add(renderOutput);
        if (renderOutput.getDistance() < distance) {
            closest = renderOutput.getClosest();
            distance = renderOutput.getDistance();
        }
    }

    @Override
    public IRenderOutput[] getSteps() {
        return steps.toArray(IRenderOutput[]::new);
    }

    @Override
    public int getStepsCount() {
        return steps.size();
    }

    @Override
    public Vector3d getHitPosition() {
        return hitPosition;
    }

    @Override
    public boolean hit() {
        return hit != null;
    }

    @Override
    public IRenderable getHit() {
        return hit;
    }

    public void setHit(IRenderable hit) {
        this.hit = hit;
    }

    @Override
    public Vector3d getNormal() {
        return normal;
    }

    public void setNormal(Vector3d normal) {
        this.normal = normal;
    }

    public void setHitPosition(Vector3d hitPosition) {
        this.hitPosition = hitPosition;
    }
}
