package com.bassintag.raymarcher.rendering.combinator.impl;

import com.bassintag.raymarcher.Color;
import com.bassintag.raymarcher.rendering.IRenderOutput;
import com.bassintag.raymarcher.rendering.combinator.ICombiner;
import com.bassintag.raymarcher.rendering.impl.RenderOutput;

import java.util.Comparator;
import java.util.HashMap;
import java.util.stream.Stream;

/**
 * SmoothUnionCombiner.java created for Raymarcher
 *
 * @author Antoine
 * @version 1.0
 * @since 07/04/2019
 */
public class SmoothUnionCombiner implements ICombiner {

    private final double amount;

    public SmoothUnionCombiner(double amount) {
        this.amount = amount;
    }

    public SmoothUnionCombiner() {
        this.amount = 5;
    }

    @Override
    public IRenderOutput combine(IRenderOutput[] outputs) {
        if (outputs.length == 1) return outputs[0];
        var min = Stream.of(outputs).min(Comparator.comparingDouble(IRenderOutput::getDistance)).orElseThrow();
        var d1 = min.getDistance();
        var other = Stream.of(outputs).filter(o -> o != min).toArray(IRenderOutput[]::new);
        var d2 = 0.0;
        var color = Color.BLACK;
        for (var o : other) {
            d2 += o.getDistance();
            color = color.additiveBlend(o.getColor());
        }
        d2 /= other.length;
        var h = Math.min(Math.max(0.5 + 0.5 * (d2 - d1) / amount, 0), 1);
        return new RenderOutput(d2 + (d1 - d2) * h - amount * h * (1 - h), null, min.getColor().lerp(color, 1 - h));
    }
}
