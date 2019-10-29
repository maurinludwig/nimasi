package com.nimasi.game.core.entities;

/**
 * Expression of the maximum extents of a 2-dimensional object
 */
public interface BoundingRect {
    float getX();

    float getY();

    float getHeight();

    float getWidth();

    boolean isCollidingWithBoundingRect(BoundingRect r);
}
