package com.bassintag.raymarcher.rendering.impl;

import com.bassintag.raymarcher.Vector3d;
import com.bassintag.raymarcher.rendering.IRenderOutput;
import com.bassintag.raymarcher.rendering.IRenderable;
import com.bassintag.raymarcher.rendering.IRenderableGroup;
import com.bassintag.raymarcher.rendering.combinator.ICombiner;
import com.bassintag.raymarcher.rendering.combinator.impl.SmoothUnionCombiner;

import java.util.ArrayList;
import java.util.List;

/**
 * RenderableGroup.java created for Raymarcher
 *
 * @author Antoine
 * @version 1.0
 * @since 06/04/2019
 */
public class RenderableGroup extends Transformable implements IRenderableGroup {

    private final List<IRenderable> renderables = new ArrayList<>();
    private final ICombiner         combiner;

    public RenderableGroup(ICombiner combinator) {
        this.combiner = combinator;
    }

    public RenderableGroup() {
        combiner = new SmoothUnionCombiner();
    }

    @Override
    public void addRenderable(IRenderable renderable) {
        renderables.add(renderable);
    }

    @Override
    public IRenderOutput render(Vector3d position) {
        var out =  combiner.combine(renderables.stream()
                .map(r -> r.render(position.apply(getTransform().getInverseMatrix())))
                .toArray(IRenderOutput[]::new));
        return new RenderOutput(out.getDistance(), this, out.getColor());
    }
}
