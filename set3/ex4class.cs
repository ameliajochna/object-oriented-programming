using System;
using System.Diagnostics;
public class Wektor {
    public float[] coordinates;
    public int dim;

    public Wektor(int dimension, float[] startingCoordinates) {
        coordinates = startingCoordinates;
        dim = dimension;
    }

    public static Wektor operator +(Wektor a, Wektor b) {
        if (a.dim != b.dim)
            throw new ArgumentException("Vectors must be of the same dimension.");

        float[] addedCoordinates = new float[a.dim];
        for (int i = 0; i < a.dim; i++)
            addedCoordinates[i] = a.coordinates[i] + b.coordinates[i];

        return new Wektor(a.dim, addedCoordinates);
    }

    public static float operator *(Wektor a, Wektor b) {
        if (a.dim != b.dim)
            throw new ArgumentException("Vectors must be of the same dimension.");

        float dotProductValue = 0;
        for (int i = 0; i < a.dim; i++)
            dotProductValue += a.coordinates[i] * b.coordinates[i];

        return dotProductValue;
    }

    public static Wektor operator *(float t, Wektor w) {
        float[] multipliedCoordinates = new float[w.dim];
        for (int i = 0; i < w.dim; i++)
            multipliedCoordinates[i] = t * w.coordinates[i];

        return new Wektor(w.dim, multipliedCoordinates);
    }
    
    public float Norma() {
        return (float)Math.Sqrt(this*this);
    }
}