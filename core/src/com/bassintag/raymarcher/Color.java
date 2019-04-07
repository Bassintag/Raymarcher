package com.bassintag.raymarcher;

/**
 * Color.java created for Raymarcher
 *
 * @author Antoine
 * @version 1.0
 * @since 06/04/2019
 */
public class Color {

    private double red, green, blue, alpha;

    public Color(double red, double green, double blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.alpha = 1;
    }

    public Color(double red, double green, double blue, double alpha) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.alpha = alpha;
    }

    public double getRed() {
        return red;
    }

    public double getGreen() {
        return green;
    }

    public double getBlue() {
        return blue;
    }

    public double getAlpha() {
        return alpha;
    }

    public Color multiply(double amount) {
        return new Color(red * amount, green * amount, blue * amount, alpha);
    }

    public Color additiveBlend(Color color) {
        return new Color(
                Math.min(1, red + color.red),
                Math.min(1, green + color.green),
                Math.min(1, blue + color.blue)
        );
    }

    public Color multiplyBlend(Color color) {
        return new Color(
                red * color.red,
                green * color.green,
                blue * color.blue
        );
    }

    public Color lerp(Color color, double amount) {
        return new Color(
                red + (color.red - red) * amount,
                green + (color.green - green) * amount,
                blue + (color.blue - blue) * amount
        );
    }

    public java.awt.Color toAwt() {
        return new java.awt.Color((float) red, (float) green, (float) blue, (float) alpha);
    }

    @Override
    public String toString() {
        return String.format("Color <r: %.2f, g: %.2f, b: %.2f, a: %.2f>", red, green, blue, alpha);
    }

    public static final Color BLACK = new Color(0, 0, 0);
    public static final Color WHITE = new Color(1, 1, 1);
    public static final Color RED   = new Color(1, 0, 0);
    public static final Color GREEN = new Color(0, 1, 0);
    public static final Color BLUE  = new Color(0, 0, 1);
}
