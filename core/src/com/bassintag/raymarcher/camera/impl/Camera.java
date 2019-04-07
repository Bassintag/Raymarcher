package com.bassintag.raymarcher.camera.impl;

import com.bassintag.raymarcher.Color;
import com.bassintag.raymarcher.Vector2i;
import com.bassintag.raymarcher.Vector3d;
import com.bassintag.raymarcher.camera.ICamera;
import com.bassintag.raymarcher.camera.IRenderTexture;
import com.bassintag.raymarcher.scene.IRayRenderOutput;
import com.bassintag.raymarcher.scene.IScene;

import java.util.stream.Stream;

/**
 * Camera.java created for Raymarcher
 *
 * @author Antoine
 * @version 1.0
 * @since 06/04/2019
 */
public class Camera implements ICamera {

    private Vector3d position  = Vector3d.ZERO;
    private Vector3d direction = Vector3d.FORWARD;

    private Vector2i resolution;
    private double   cullingDistance = 100;
    private double   hitThreshold    = .1;
    private Color    background      = Color.BLACK;

    private double shadowRadius = .1;

    public Camera(Vector2i resolution) {
        this.resolution = resolution;
    }

    public Camera(int w, int h) {
        this(new Vector2i(w, h));
    }

    @Override
    public IRenderTexture renderScene(IScene scene) {
        System.out.println("Start render");
        var renderTexture = new RenderTexture(resolution);
        for (var y = 0; y < resolution.getY(); y += 1) {
            for (var x = 0; x < resolution.getX(); x += 1) {
                renderTexture.setAt(x, y, renderPixel(x, y, scene));
            }
        }
        System.out.println("End render");
        return renderTexture;
    }

    private Color calculateIllumination(IScene scene, IRayRenderOutput data) {
        var out = Color.BLACK;
        var position = data.getHitPosition().add(data.getNormal().multiply(Math.max(shadowRadius, hitThreshold * 2)));
        for (var light : scene.getLights()) {
            var rel = light.getTransform().getPosition().substract(position);
            var output = scene.castRay(position, rel.normalize(), hitThreshold, Math.min(cullingDistance, rel.length()));
            if (!output.hit()) {
                var color = light.getColor().multiply(light.getIntensity());
                var fact = Math.min(1, rel.normalize().dot(data.getNormal()));// * (output.getDistance() / shadowRadius));
                color = color.multiply(Math.max(0, fact));
                out = out.additiveBlend(color);
            }
        }
        return out;
    }

    private Color renderPixel(int x, int y, IScene scene) {
        var max = (float) Math.max(resolution.getX(), resolution.getY());
        var dir = new Vector3d(x * 2 / max - resolution.getX() / max, -y * 2 / max + resolution.getY() / max, 0)
                .add(direction).normalize();
        var data = scene.castRay(position, dir, hitThreshold, cullingDistance);
        if (!data.hit()) return background;
        var light = calculateIllumination(scene, data);
        return data.getColor().multiplyBlend(light);
    }

    public Vector3d getPosition() {
        return position;
    }

    public void setPosition(Vector3d position) {
        this.position = position;
    }

    public Vector2i getResolution() {
        return resolution;
    }

    public Vector3d getDirection() {
        return direction;
    }

    public void setDirection(Vector3d direction) {
        this.direction = direction.normalize();
    }

    public void setTarget(Vector3d target) {
        setDirection(target.substract(position));
    }

    public void setResolution(Vector2i resolution) {
        this.resolution = resolution;
    }

    public double getCullingDistance() {
        return cullingDistance;
    }

    public void setCullingDistance(double cullingDistance) {
        this.cullingDistance = cullingDistance;
    }

    public double getHitThreshold() {
        return hitThreshold;
    }

    public void setHitThreshold(double hitThreshold) {
        this.hitThreshold = hitThreshold;
    }

    public Color getBackground() {
        return background;
    }

    public void setBackground(Color background) {
        this.background = background;
    }

    public double getShadowRadius() {
        return shadowRadius;
    }

    public void setShadowRadius(double shadowRadius) {
        this.shadowRadius = shadowRadius;
    }
}
