package com.bassintag.raymarcher.scene.impl;

import com.bassintag.raymarcher.Vector3d;
import com.bassintag.raymarcher.rendering.impl.RenderableGroup;
import com.bassintag.raymarcher.rendering.lighting.ILight;
import com.bassintag.raymarcher.scene.IRayRenderOutput;
import com.bassintag.raymarcher.scene.IScene;

import java.util.ArrayList;
import java.util.List;

/**
 * Scene.java created for Raymarcher
 *
 * @author Antoine
 * @version 1.0
 * @since 06/04/2019
 */
public class Scene extends RenderableGroup implements IScene {

    private final List<ILight> lights = new ArrayList<>();


    @Override
    public IRayRenderOutput castRay(Vector3d start, Vector3d direction, double threshold, double culling) {
        var rayOutput = new RayRenderOutput();
        var position = start;
        do {
            if (position.substract(start).length() > culling) return rayOutput;
            var output = render(position);
            position = position.add(direction.multiply(output.getDistance()));
            rayOutput.sddStep(output);
        } while (rayOutput.getDistance() > threshold);
        var hit = rayOutput.getClosest();
        rayOutput.setHit(hit);
        rayOutput.setHitPosition(position);
        var eps = new Vector3d(0, threshold, 0);
        var normal = new Vector3d(
                hit.render(position.add(eps.yxx())).getDistance() - hit.render(position.substract(eps.yxx())).getDistance(),
                hit.render(position.add(eps.xyx())).getDistance() - hit.render(position.substract(eps.xyx())).getDistance(),
                hit.render(position.add(eps.xxy())).getDistance() - hit.render(position.substract(eps.xxy())).getDistance()
        ).normalize();
        rayOutput.setNormal(normal);
        return rayOutput;
    }

    @Override
    public void addLight(ILight light) {
        this.lights.add(light);
    }

    @Override
    public Iterable<ILight> getLights() {
        return lights;
    }
}
