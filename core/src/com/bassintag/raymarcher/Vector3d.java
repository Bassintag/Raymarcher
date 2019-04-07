package com.bassintag.raymarcher;

/**
 * Vector3d.java created for Raymarcher
 *
 * @author Antoine
 * @version 1.0
 * @since 06/04/2019
 */
@SuppressWarnings("SuspiciousNameCombination")
public class Vector3d {

    private final double x, y, z;

    public Vector3d(double d) {
        this.x = d;
        this.y = d;
        this.z = d;
    }

    public Vector3d(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3d x() {
        return new Vector3d(x, 0, 0);
    }

    public Vector3d y() {
        return new Vector3d(y, 0, 0);
    }

    public Vector3d z() {
        return new Vector3d(z, 0, 0);
    }

    public Vector3d xx() {
        return new Vector3d(x, x, 0);
    }

    public Vector3d xy() {
        return new Vector3d(x, y, 0);
    }

    public Vector3d xz() {
        return new Vector3d(x, z, 0);
    }

    public Vector3d yx() {
        return new Vector3d(y, x, 0);
    }

    public Vector3d yy() {
        return new Vector3d(y, y, 0);
    }

    public Vector3d yz() {
        return new Vector3d(y, z, 0);
    }

    public Vector3d zx() {
        return new Vector3d(z, x, 0);
    }

    public Vector3d zy() {
        return new Vector3d(z, y, 0);
    }

    public Vector3d zz() {
        return new Vector3d(z, z, 0);
    }

    public Vector3d xxx() {
        return new Vector3d(x, x, x);
    }

    public Vector3d xxy() {
        return new Vector3d(x, x, y);
    }

    public Vector3d xxz() {
        return new Vector3d(x, x, z);
    }

    public Vector3d xyx() {
        return new Vector3d(x, y, x);
    }

    public Vector3d xyy() {
        return new Vector3d(x, y, y);
    }

    public Vector3d xyz() {
        return new Vector3d(x, y, z);
    }

    public Vector3d xzx() {
        return new Vector3d(x, z, x);
    }

    public Vector3d xzy() {
        return new Vector3d(x, z, y);
    }

    public Vector3d xzz() {
        return new Vector3d(x, z, z);
    }

    public Vector3d yxx() {
        return new Vector3d(y, x, x);
    }

    public Vector3d yxy() {
        return new Vector3d(y, x, y);
    }

    public Vector3d yxz() {
        return new Vector3d(y, x, z);
    }

    public Vector3d yyx() {
        return new Vector3d(y, y, x);
    }

    public Vector3d yyy() {
        return new Vector3d(y, y, y);
    }

    public Vector3d yyz() {
        return new Vector3d(y, y, z);
    }

    public Vector3d yzx() {
        return new Vector3d(y, z, x);
    }

    public Vector3d yzy() {
        return new Vector3d(y, z, y);
    }

    public Vector3d yzz() {
        return new Vector3d(y, z, z);
    }

    public Vector3d zxx() {
        return new Vector3d(z, x, x);
    }

    public Vector3d zxy() {
        return new Vector3d(z, x, y);
    }

    public Vector3d zxz() {
        return new Vector3d(z, x, z);
    }

    public Vector3d zyx() {
        return new Vector3d(z, y, x);
    }

    public Vector3d zyy() {
        return new Vector3d(z, y, y);
    }

    public Vector3d zyz() {
        return new Vector3d(z, y, z);
    }

    public Vector3d zzx() {
        return new Vector3d(z, z, x);
    }

    public Vector3d zzy() {
        return new Vector3d(z, z, y);
    }

    public Vector3d zzz() {
        return new Vector3d(z, z, z);
    }

    public Vector3d add(Vector3d other) {
        return new Vector3d(
                x + other.x,
                y + other.y,
                z + other.z
        );
    }

    public Vector3d substract(Vector3d other) {
        return new Vector3d(
                x - other.x,
                y - other.y,
                z - other.z
        );
    }

    public Vector3d multiply(Vector3d other) {
        return new Vector3d(
                x * other.x,
                y * other.x,
                z * other.z
        );
    }

    public Vector3d mod(Vector3d other) {
        return new Vector3d(
                x % other.x,
                y % other.y,
                z % other.z
        );
    }

    public double dot(Vector3d other) {
        return x * other.x + y * other.y + z * other.z;
    }

    public Vector3d cross(Vector3d other) {
        return new Vector3d(
                -x * other.x,
                -y * other.y,
                -z * other.z
        );
    }

    public Vector3d multiply(double d) {
        return new Vector3d(
                x * d,
                y * d,
                z * d
        );
    }

    public Vector3d abs() {
        return new Vector3d(Math.abs(x), Math.abs(y), Math.abs(z));
    }

    public Vector3d min(Vector3d other) {
        return new Vector3d(
                Math.min(x, other.x),
                Math.min(y, other.y),
                Math.min(z, other.z)
        );
    }

    public Vector3d max(Vector3d other) {
        return new Vector3d(
                Math.max(x, other.x),
                Math.max(y, other.y),
                Math.max(z, other.z)
        );
    }

    public Vector3d invert() {
        return new Vector3d(-x, -y, -z);
    }

    public Vector3d apply(Matrix4d m) {
        return new Vector3d(
                x * m.m(0, 0) + y * m.m(0, 1) + z * m.m(0, 2) + m.m(0, 3),
                x * m.m(1, 0) + y * m.m(1, 1) + z * m.m(1, 2) + m.m(1, 3),
                x * m.m(2, 0) + y * m.m(2, 1) + z * m.m(2, 2) + m.m(2, 3)
        );
    }

    public double length() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public Vector3d normalize() {
        var length = length();
        return new Vector3d(
                x / length,
                y / length,
                z / length
        );
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    @Override
    public String toString() {
        return String.format("Vector3d <x: %.2f, y: %.2f, z: %.2f>", x, y, z);
    }

    public static final Vector3d ZERO     = new Vector3d(0, 0, 0);
    public static final Vector3d ONE      = new Vector3d(1, 1, 1);
    public static final Vector3d LEFT     = new Vector3d(-1, 0, 0);
    public static final Vector3d RIGHT    = new Vector3d(1, 0, 0);
    public static final Vector3d DOWN     = new Vector3d(0, -1, 0);
    public static final Vector3d UP       = new Vector3d(0, 1, 0);
    public static final Vector3d BACKWARD = new Vector3d(0, 0, -1);
    public static final Vector3d FORWARD  = new Vector3d(0, 0, 1);
}
