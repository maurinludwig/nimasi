package com.nimasi.game.entities;

public class BoundingRectImpl implements BoundingRect {
    private float X;
    private float Y;
    private float width;
    private float height;

    public BoundingRectImpl(float x, float y, float width, float height) {
        this.X = x;
        this.Y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public float getX() {
        return X;
    }

    @Override
    public float getY() {
        return Y;
    }

    @Override
    public float getHeight() {
        return height;
    }

    @Override
    public float getWidth() {
        return width;
    }

    @Override
    public boolean isCollidingWithBoundingRect(BoundingRect r) {
        return doBoundingRectsCollide(this, r);
    }

    public static boolean doBoundingRectsCollide(BoundingRect r1, BoundingRect r2) {
        return doesXAxisCollide(r1, r2) && doesYAxisCollide(r1, r2);
    }

    public static boolean doesXAxisCollide(BoundingRect r1, BoundingRect r2) {
        float ourX1 = r1.getX();
        float ourX2 = r1.getX() + r1.getWidth();
        float rX1 = r2.getX();
        float rX2 = r2.getX() + r2.getWidth();
        return (rX1 >= ourX1 && rX1 <= ourX2) || (rX2 >= ourX1 && rX2 <= ourX2);
    }

    public static boolean doesYAxisCollide(BoundingRect r1, BoundingRect r2) {
        float ourY1 = r1.getY();
        float ourY2 = r1.getY() + r1.getHeight();
        float rY1 = r2.getY();
        float rY2 = r2.getY() + r2.getHeight();
        return (rY1 >= ourY1 && rY1 <= ourY2) || (rY2 >= ourY1 && rY2 <= ourY2);
    }
}
