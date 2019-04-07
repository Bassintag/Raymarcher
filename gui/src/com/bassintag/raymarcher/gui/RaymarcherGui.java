package com.bassintag.raymarcher.gui;

import com.bassintag.raymarcher.camera.IRenderTexture;

import javax.swing.*;
import java.awt.*;

/**
 * RaymarcherGui.java created for Raymarcher
 *
 * @author Antoine
 * @version 1.0
 * @since 06/04/2019
 */
public class RaymarcherGui extends JPanel {

    private IRenderTexture renderTexture;

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.black);
        if (renderTexture == null) {
            g.fillRect(0, 0, getWidth(), getHeight());
        } else {
            for (var y = 0; y < renderTexture.getHeight(); y += 1) {
                for (var x = 0; x < renderTexture.getWidth(); x += 1) {
                    g.setColor(renderTexture.getAt(x, y).toAwt());
                    g.fillRect(x, y, 1, 1);
                }
            }
        }
    }

    public IRenderTexture getRenderTexture() {
        return renderTexture;
    }

    public void setRenderTexture(IRenderTexture renderTexture) {
        this.renderTexture = renderTexture;
        var d = new Dimension(renderTexture.getWidth(), renderTexture.getHeight());
        setSize(d);
        setPreferredSize(d);
        invalidate();
    }
}
