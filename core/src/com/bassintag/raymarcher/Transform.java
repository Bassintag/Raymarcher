package com.bassintag.raymarcher;

/**
 * Transform.java created for Raymarcher
 *
 * @author Antoine
 * @version 1.0
 * @since 06/04/2019
 */
public class Transform {

    private Vector3d position = Vector3d.ZERO;
    private Vector3d rotation = Vector3d.ZERO;
    private Vector3d scale    = Vector3d.ONE;

    private Matrix4d matrix;
    private Matrix4d inverseMatrix;

    private void invalidateMatrix() {
        matrix = null;
        inverseMatrix = null;
    }

    public Vector3d getPosition() {
        return position;
    }

    public void setPosition(Vector3d position) {
        invalidateMatrix();
        this.position = position;
    }

    public Vector3d getRotation() {
        return rotation;
    }

    public void setRotation(Vector3d rotation) {
        invalidateMatrix();
        this.rotation = rotation;
    }

    public Vector3d getScale() {
        return scale;
    }

    public void setScale(Vector3d scale) {
        invalidateMatrix();
        this.scale = scale;
    }

    private void calculateMatrix() {
        var positionMatrix = new Matrix4d(
                1, 0, 0, position.getX(),
                0, 1, 0, position.getY(),
                0, 0, 1, position.getZ(),
                0, 0, 0, 1
        );
        var sinX = Math.sin(rotation.getX());
        var cosX = Math.cos(rotation.getX());
        var rotationMatrixX = new Matrix4d(
                1, 0, 0,
                0, cosX, -sinX,
                0, sinX, cosX
        );
        var sinY = Math.sin(rotation.getY());
        var cosY = Math.cos(rotation.getY());
        var rotationMatrixY = new Matrix4d(
                cosY, 0, sinY,
                0, 1, 0,
                -sinY, 0, cosY
        );
        var sinZ = Math.sin(rotation.getZ());
        var cosZ = Math.cos(rotation.getZ());
        var rotationMatrixZ = new Matrix4d(
                cosZ, -sinZ, 0,
                sinZ, cosZ, 0,
                0, 0, 1
        );
        var rotationMatrix = rotationMatrixX.multiply(rotationMatrixY).multiply(rotationMatrixZ);
        var scaleMatrix = new Matrix4d(
                scale.getX(), 0, 0,
                0, scale.getY(), 0,
                0, 0, scale.getZ()
        );
        matrix = positionMatrix.multiply(rotationMatrix).multiply(scaleMatrix);
    }

    public Matrix4d getMatrix() {
        if (matrix == null) {
            calculateMatrix();
        }
        return matrix;
    }

    private void calculateInverseMatrix() {
        inverseMatrix = getMatrix().invert();
    }

    public Matrix4d getInverseMatrix() {
        if (inverseMatrix == null) {
            calculateInverseMatrix();
        }
        return inverseMatrix;
    }
}
