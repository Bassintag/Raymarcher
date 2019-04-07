package com.bassintag.raymarcher.gui;

import com.bassintag.raymarcher.Color;
import com.bassintag.raymarcher.Vector3d;
import com.bassintag.raymarcher.camera.impl.Camera;
import com.bassintag.raymarcher.rendering.combinator.impl.SubstractionCombiner;
import com.bassintag.raymarcher.rendering.impl.RenderableGroup;
import com.bassintag.raymarcher.rendering.impl.RepeatOperator;
import com.bassintag.raymarcher.rendering.lighting.impl.Light;
import com.bassintag.raymarcher.rendering.objects.impl.*;
import com.bassintag.raymarcher.scene.impl.Scene;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * RaymarcherGuiApplication.java created for Raymarcher
 *
 * @author Antoine
 * @version 1.0
 * @since 06/04/2019
 */
public class RaymarcherGuiApplication {

    public static void main(String[] args) {
        var camera = new Camera(1920 / 2, 1080 / 2);
        camera.setPosition(new Vector3d(0, 0, -10));
        camera.setHitThreshold(.001);
        camera.setShadowRadius(.3);

        var l1 = new Light(1, Color.RED);
        l1.getTransform().setPosition(camera.getPosition().add(new Vector3d(-10, 0, 0)));
        var l2 = new Light(1, Color.GREEN);
        l2.getTransform().setPosition(camera.getPosition().add(new Vector3d(0, 0, 0)));
        var l3 = new Light(1, Color.BLUE);
        l3.getTransform().setPosition(camera.getPosition().add(new Vector3d(10, 0, 0)));

        var s1 = new Sphere(Color.WHITE, 3);
        s1.getTransform().setPosition(new Vector3d(-3, -2, 0));
        //s1.getTransform().setRotation(new Vector3d(Math.PI / 6, 0, 0));

        var s2 = new Sphere(Color.WHITE, 3);
        s2.getTransform().setPosition(new Vector3d(3, -2, 0));
//        s2.getTransform().setRotation(new Vector3d(Math.PI / 2, 0, 0));

        var s3 = new Sphere(Color.WHITE, 1);
        s3.getTransform().setPosition(new Vector3d(0, 3, 0));
        //var op = new RepeatOperator(s2, new Vector3d(5));

        var group1 = new RenderableGroup();
        group1.addRenderable(s1);
        group1.addRenderable(s2);

        var group2 = new RenderableGroup();
        group2.addRenderable(group1);
        group2.addRenderable(s3);

        var group3 = new RenderableGroup(new SubstractionCombiner());
        var mask = new Cube(Color.WHITE, 2);
        mask.getTransform().setPosition(new Vector3d(0, -1, -2));
        group3.addRenderable(mask);
        group3.addRenderable(group2);

        var scene = new Scene();
        scene.addRenderable(group3);
//        scene.addRenderable(s2);
        scene.addLight(l1);
        scene.addLight(l2);
        scene.addLight(l3);

        var gui = new RaymarcherGui();

        var frame = new JFrame();
        frame.getContentPane().add(gui);
        gui.setRenderTexture(camera.renderScene(scene));
        frame.pack();
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
