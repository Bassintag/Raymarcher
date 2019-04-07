package com.bassintag.raymarcher;

/**
 * Matrix4d.java created for Raymarcher
 *
 * @author Antoine
 * @version 1.0
 * @since 06/04/2019
 */
public class Matrix4d {

    private final double[][] m;

    public Matrix4d() {
        m = new double[4][4];
    }

    public Matrix4d(double d00, double d01, double d02, double d03,
                    double d10, double d11, double d12, double d13,
                    double d20, double d21, double d22, double d23,
                    double d30, double d31, double d32, double d33) {
        m = new double[][]{
                {d00, d01, d02, d03},
                {d10, d11, d12, d13},
                {d20, d21, d22, d23},
                {d30, d31, d32, d33}
        };
    }

    public Matrix4d(double d00, double d01, double d02,
                    double d10, double d11, double d12,
                    double d20, double d21, double d22) {
        m = new double[][]{
                {d00, d01, d02, 0},
                {d10, d11, d12, 0},
                {d20, d21, d22, 0},
                {0, 0, 0, 1}
        };
    }

    public Matrix4d multiply(Matrix4d other) {
        var m00 = m[0][0] * other.m(0, 0) + m[0][1] * other.m(1, 0) + m[0][2] * other.m(2, 0) + m[0][3] * other.m(3, 0);
        var m01 = m[0][0] * other.m(0, 1) + m[0][1] * other.m(1, 1) + m[0][2] * other.m(2, 1) + m[0][3] * other.m(3, 1);
        var m02 = m[0][0] * other.m(0, 2) + m[0][1] * other.m(1, 2) + m[0][2] * other.m(2, 2) + m[0][3] * other.m(3, 2);
        var m03 = m[0][0] * other.m(0, 3) + m[0][1] * other.m(1, 3) + m[0][2] * other.m(2, 3) + m[0][3] * other.m(3, 3);
        var m10 = m[1][0] * other.m(0, 0) + m[1][1] * other.m(1, 0) + m[1][2] * other.m(2, 0) + m[1][3] * other.m(3, 0);
        var m11 = m[1][0] * other.m(0, 1) + m[1][1] * other.m(1, 1) + m[1][2] * other.m(2, 1) + m[1][3] * other.m(3, 1);
        var m12 = m[1][0] * other.m(0, 2) + m[1][1] * other.m(1, 2) + m[1][2] * other.m(2, 2) + m[1][3] * other.m(3, 2);
        var m13 = m[1][0] * other.m(0, 3) + m[1][1] * other.m(1, 3) + m[1][2] * other.m(2, 3) + m[1][3] * other.m(3, 3);
        var m20 = m[2][0] * other.m(0, 0) + m[2][1] * other.m(1, 0) + m[2][2] * other.m(2, 0) + m[2][3] * other.m(3, 0);
        var m21 = m[2][0] * other.m(0, 1) + m[2][1] * other.m(1, 1) + m[2][2] * other.m(2, 1) + m[2][3] * other.m(3, 1);
        var m22 = m[2][0] * other.m(0, 2) + m[2][1] * other.m(1, 2) + m[2][2] * other.m(2, 2) + m[2][3] * other.m(3, 2);
        var m23 = m[2][0] * other.m(0, 3) + m[2][1] * other.m(1, 3) + m[2][2] * other.m(2, 3) + m[2][3] * other.m(3, 3);
        var m30 = m[3][0] * other.m(0, 0) + m[3][1] * other.m(1, 0) + m[3][2] * other.m(2, 0) + m[3][3] * other.m(3, 0);
        var m31 = m[3][0] * other.m(0, 1) + m[3][1] * other.m(1, 1) + m[3][2] * other.m(2, 1) + m[3][3] * other.m(3, 1);
        var m32 = m[3][0] * other.m(0, 2) + m[3][1] * other.m(1, 2) + m[3][2] * other.m(2, 2) + m[3][3] * other.m(3, 2);
        var m33 = m[3][0] * other.m(0, 3) + m[3][1] * other.m(1, 3) + m[3][2] * other.m(2, 3) + m[3][3] * other.m(3, 3);
        return new Matrix4d(
                m00, m01, m02, m03,
                m10, m11, m12, m13,
                m20, m21, m22, m23,
                m30, m31, m32, m33
        );
    }

    public Matrix4d invert() {
        var A2323 = m[2][2] * m[3][3] - m[2][3] * m[3][2];
        var A1323 = m[2][1] * m[3][3] - m[2][3] * m[3][1];
        var A1223 = m[2][1] * m[3][2] - m[2][2] * m[3][1];
        var A0323 = m[2][0] * m[3][3] - m[2][3] * m[3][0];
        var A0223 = m[2][0] * m[3][2] - m[2][2] * m[3][0];
        var A0123 = m[2][0] * m[3][1] - m[2][1] * m[3][0];
        var A2313 = m[1][2] * m[3][3] - m[1][3] * m[3][2];
        var A1313 = m[1][1] * m[3][3] - m[1][3] * m[3][1];
        var A1213 = m[1][1] * m[3][2] - m[1][2] * m[3][1];
        var A2312 = m[1][2] * m[2][3] - m[1][3] * m[2][2];
        var A1312 = m[1][1] * m[2][3] - m[1][3] * m[2][1];
        var A1212 = m[1][1] * m[2][2] - m[1][2] * m[2][1];
        var A0313 = m[1][0] * m[3][3] - m[1][3] * m[3][0];
        var A0213 = m[1][0] * m[3][2] - m[1][2] * m[3][0];
        var A0312 = m[1][0] * m[2][3] - m[1][3] * m[2][0];
        var A0212 = m[1][0] * m[2][2] - m[1][2] * m[2][0];
        var A0113 = m[1][0] * m[3][1] - m[1][1] * m[3][0];
        var A0112 = m[1][0] * m[2][1] - m[1][1] * m[2][0];
        var det = m[0][0] * (m[1][1] * A2323 - m[1][2] * A1323 + m[1][3] * A1223)
                - m[0][1] * (m[1][0] * A2323 - m[1][2] * A0323 + m[1][3] * A0223)
                + m[0][2] * (m[1][0] * A1323 - m[1][1] * A0323 + m[1][3] * A0123)
                - m[0][3] * (m[1][0] * A1223 - m[1][1] * A0223 + m[1][2] * A0123);
        det = 1 / det;
        return new Matrix4d(
                det * (m[1][1] * A2323 - m[1][2] * A1323 + m[1][3] * A1223),
                det * -(m[0][1] * A2323 - m[0][2] * A1323 + m[0][3] * A1223),
                det * (m[0][1] * A2313 - m[0][2] * A1313 + m[0][3] * A1213),
                det * -(m[0][1] * A2312 - m[0][2] * A1312 + m[0][3] * A1212),
                det * -(m[1][0] * A2323 - m[1][2] * A0323 + m[1][3] * A0223),
                det * (m[0][0] * A2323 - m[0][2] * A0323 + m[0][3] * A0223),
                det * -(m[0][0] * A2313 - m[0][2] * A0313 + m[0][3] * A0213),
                det * (m[0][0] * A2312 - m[0][2] * A0312 + m[0][3] * A0212),
                det * (m[1][0] * A1323 - m[1][1] * A0323 + m[1][3] * A0123),
                det * -(m[0][0] * A1323 - m[0][1] * A0323 + m[0][3] * A0123),
                det * (m[0][0] * A1313 - m[0][1] * A0313 + m[0][3] * A0113),
                det * -(m[0][0] * A1312 - m[0][1] * A0312 + m[0][3] * A0112),
                det * -(m[1][0] * A1223 - m[1][1] * A0223 + m[1][2] * A0123),
                det * (m[0][0] * A1223 - m[0][1] * A0223 + m[0][2] * A0123),
                det * -(m[0][0] * A1213 - m[0][1] * A0213 + m[0][2] * A0113),
                det * (m[0][0] * A1212 - m[0][1] * A0212 + m[0][2] * A0112)
        );
    }

    public double m(int row, int col) {
        return m[row][col];
    }

    public static final Matrix4d IDENTITY = new Matrix4d(
            1, 0, 0, 0,
            0, 1, 0, 0,
            0, 0, 1, 0,
            0, 0, 0, 1
    );
}
