package com.nimasi.game.core.entities;

/**
 * Implements a 2-dimensional object
 */
public class BoundingRectImpl implements BoundingRect {
    private float X;
    private float Y;
    private float width;
    private float height;

    /**
     * Constructor gets values for BoundingRect
     *
     * @param x:      X axis
     * @param y:      Y axis
     * @param width:  Width of the bounding rect
     * @param height: Height of the bounding rect
     */
    public BoundingRectImpl(float x, float y, float width, float height) {
        this.X = x;
        this.Y = y;
        this.width = width;
        this.height = height;
    }

    /**
     * Gets x axis
     *
     * @return float: x axis
     */
    @Override
    public float getX() {
        return X;
    }

    /**
     * Gets y axis
     *
     * @return float: y axis
     */
    @Override
    public float getY() {
        return Y;
    }

    /**
     * Gets height
     *
     * @return float: height
     */
    @Override
    public float getHeight() {
        return height;
    }

    /**
     * Gets width
     *
     * @return float: width
     */
    @Override
    public float getWidth() {
        return width;
    }

    /**
     * Gets boolean if given bounding rect is colliding with a bounding rect.
     *
     * @return boolean: collides with bounding rect
     */
    @Override
    public boolean isCollidingWithBoundingRect(BoundingRect r) {
        return doBoundingRectsCollide(this, r);
    }

    /**
     * Compares two bounding rects and returns true if they collide.
     *
     * @param r1: bounding rect 1
     * @param r2: bounding rect 2
     * @return boolean: rects collide with each other
     */
    static boolean doBoundingRectsCollide(BoundingRect r1, BoundingRect r2) {
        return doesXAxisCollide(r1, r2) && doesYAxisCollide(r1, r2);
    }

    /**
     * Compares x axis of 2 bounding rects with each other, returns true if they collide.
     *
     * @return boolean: x axis collide with each other
     */
    private static boolean doesXAxisCollide(BoundingRect r1, BoundingRect r2) {
        float ourX1 = r1.getX();
        float ourX2 = r1.getX() + r1.getWidth();
        float rX1 = r2.getX();
        float rX2 = r2.getX() + r2.getWidth();
        return (rX1 >= ourX1 && rX1 <= ourX2) || (rX2 >= ourX1 && rX2 <= ourX2);
    }

    /**
     * Compares y axis of 2 bounding rects with each other, returns true if they collide.
     *
     * @return boolean: y axis collide with each other
     */
    private static boolean doesYAxisCollide(BoundingRect r1, BoundingRect r2) {
        float ourY1 = r1.getY();
        float ourY2 = r1.getY() + r1.getHeight();
        float rY1 = r2.getY();
        float rY2 = r2.getY() + r2.getHeight();
        return (rY1 >= ourY1 && rY1 <= ourY2) || (rY2 >= ourY1 && rY2 <= ourY2);
    }
}
