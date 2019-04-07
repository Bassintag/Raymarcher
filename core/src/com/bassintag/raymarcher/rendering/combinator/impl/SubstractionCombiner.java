package com.bassintag.raymarcher.rendering.combinator.impl;

import com.bassintag.raymarcher.rendering.IRenderOutput;
import com.bassintag.raymarcher.rendering.combinator.ICombiner;
import com.bassintag.raymarcher.rendering.impl.RenderOutput;

/**
 * SubstractionCombiner.java created for Raymarcher
 *
 * @author Antoine
 * @version 1.0
 * @since 07/04/2019
 */
public class SubstractionCombiner implements ICombiner {

    @Override
    public IRenderOutput combine(IRenderOutput[] outputs) {
        if (outputs.length == 1) {
            return outputs[0];
        } else if (-outputs[0].getDistance() > outputs[1].getDistance()) {
            return new RenderOutput(-outputs[0].getDistance(), null, outputs[1].getColor());
        } else {
            return outputs[1];
        }
    }
}
