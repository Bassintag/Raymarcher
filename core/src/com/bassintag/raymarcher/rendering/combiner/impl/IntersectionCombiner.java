package com.bassintag.raymarcher.rendering.combiner.impl;

import com.bassintag.raymarcher.rendering.IRenderOutput;
import com.bassintag.raymarcher.rendering.combiner.ICombiner;

import java.util.Comparator;
import java.util.stream.Stream;

/**
 * IntersectionCombiner.java created for Raymarcher
 *
 * @author Antoine
 * @version 1.0
 * @since 07/04/2019
 */
public class IntersectionCombiner implements ICombiner {

    @Override
    public IRenderOutput combine(IRenderOutput[] outputs) {
        return Stream.of(outputs).max(Comparator.comparingDouble(IRenderOutput::getDistance)).orElseThrow();
    }
}
