package com.nimasi.game.core.highscore;

/**
 * Defines Highscore Object
 */
public class Highscore implements Comparable<Highscore> {
    private int score;
    private String name;
    private long time;

    /**
     * Constructor
     *
     * @param score: Highscore
     * @param name: Username
     * @param time: Time it took for the run
     */
    public Highscore(int score, String name, long time) {
        this.score = score;
        this.name = name;
        this.time = time;
    }

    /**
     * Gets score
     *
     * @return int: Highscore
     */
    public int getScore() {
        return score;
    }

    /**
     * Sets score
     *
     * @param score int: Highscore
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Gets name
     *
     * @return String: Username
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name
     *
     * @param name String: Username
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets time
     *
     * @return long: Time it took for the run
     */
    public long getTime() {
        return time;
    }

    /**
     * Sets time
     *
     * @param time long: Time it took for the run
     */
    public void setTime(long time) {
        this.time = time;
    }

    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     */
    @Override
    public int compareTo(Highscore o) {
        if (this.getScore() > o.getScore()) {
            return -1;
        } else if (this.getScore() < o.getScore()) {
            return 1;
        }
        return 0;
    }
}
