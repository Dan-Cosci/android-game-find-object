package com.example.mobilegame.Utils;

public class VectorF {
    private float x, y;

    // Constructor
    public VectorF(float x, float y) {
        this.x = x;
        this.y = y;
    }

    // Default constructor (0,0)
    public VectorF() {
        this(0, 0);
    }

    // Getters
    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    // Setters
    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void set(float x, float y) {
        this.x = x;
        this.y = y;
    }

    // Add another vector
    public VectorF add(VectorF other) {
        return new VectorF(this.x + other.x, this.y + other.y);
    }

    // Subtract another vector
    public VectorF subtract(VectorF other) {
        return new VectorF(this.x - other.x, this.y - other.y);
    }

    // Multiply by scalar
    public VectorF multiply(float scalar) {
        return new VectorF(this.x * scalar, this.y * scalar);
    }

    // Length (magnitude)
    public float length() {
        return (float) Math.sqrt(x * x + y * y);
    }

    // Normalize (unit vector)
    public VectorF normalize() {
        float len = length();
        if (len == 0) return new VectorF(0, 0);
        return new VectorF(x / len, y / len);
    }

    // Dot product
    public float dot(VectorF other) {
        return this.x * other.x + this.y * other.y;
    }

    // Distance to another vector
    public float distance(VectorF other) {
        float dx = this.x - other.x;
        float dy = this.y - other.y;
        return (float) Math.sqrt(dx * dx + dy * dy);
    }

    // Override toString for debugging
    @Override
    public String toString() {
        return "VectorF(" + x + ", " + y + ")";
    }
}