using System;
using System.Collections;
using System.Collections.Generic;

public class SlowaFibonacciego : IEnumerable<string>
{
    private int numWords;

    public SlowaFibonacciego(int n)
    {
        numWords = n;
    }

    public IEnumerator<string> GetEnumerator()
    {
        return new FibonacciEnumerator(numWords);
    }

    IEnumerator IEnumerable.GetEnumerator()
    {
        return GetEnumerator();
    }

    private class FibonacciEnumerator : IEnumerator<string>
    {
        private int currentIndex;
        private List<string> fibonacciWords;

        public FibonacciEnumerator(int length)
        {
            currentIndex = -1;
            fibonacciWords = new List<string>();

            if (length >= 1)
                fibonacciWords.Add("b");
            if (length >= 2)
                fibonacciWords.Add("a");

            for (int i = 2; i < length; i++)
                fibonacciWords.Add(fibonacciWords[i - 1] + fibonacciWords[i - 2]);
        }

        public string Current
        {
            get { return fibonacciWords[currentIndex]; }
        }

        object IEnumerator.Current
        {
            get { return Current; }
        }

        public bool MoveNext()
        {
            currentIndex++;
            return currentIndex < fibonacciWords.Count;
        }

        public void Reset()
        {
            currentIndex = -1;
        }

        public void Dispose()
        {
        }
    }
}

public class Program{
    static void Main(string[] args)
    {
        SlowaFibonacciego sf = new SlowaFibonacciego(10);
        foreach(string s in sf)
            Console.WriteLine(s);
    }
}
