package com.nimasi.game.entities;

public interface BoundingRect {
    float getX();
    float getY();
    float getHeight();
    float getWidth();

    boolean isCollidingWithBoundingRect(BoundingRect r);
}
