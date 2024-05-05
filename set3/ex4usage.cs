using System;
using System.Diagnostics;
class Program {
    static void Main(string[] args) {
        Wektor a = new Wektor(2, new float[] { 1.5f, 2.77f });
        Wektor b = new Wektor(2, new float[] { 5.2f, 7.6f });
        Wektor c = a + b;
        Console.WriteLine("Sum dimension: " + c.dim);
        Console.Write("Sum coordinates: ");
        foreach (float coord in c.coordinates) {
            Console.Write(coord + " ");
        }

        Wektor d = 10*a;
        Console.Write("Multiplied vector: ");
        foreach (float coord in d.coordinates) {
            Console.Write(coord + " ");
        }


        
        float dotProduct = a*b;
        Console.WriteLine("\nA, B dotproduct: " + dotProduct);
        
        float normaA = a.Norma();
        Console.WriteLine("Norma a: " + normaA);
        
        float normaB = b.Norma();
        Console.WriteLine("Norma b: " + normaB);
    }
}