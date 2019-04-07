package com.bassintag.raymarcher.rendering.combinator;

import com.bassintag.raymarcher.rendering.IRenderOutput;

/**
 * ICombiner.java created for Raymarcher
 *
 * @author Antoine
 * @version 1.0
 * @since 07/04/2019
 */
public interface ICombiner {

    IRenderOutput combine(IRenderOutput[] outputs);
}
