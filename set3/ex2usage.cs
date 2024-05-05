/*
Amelia Jochna 
Lista 3 Zadanie 2

KOMENDY:
mcs -target:library -out:MyDictionary.dll ex2class.cs
mcs -out:plik ex2usage.cs -r:MyDictionary.dll
mono plik
*/

using System;
using System.Diagnostics;
class Program
{
    static void Main(string[] args)
    {
        MyDictionary<string, string> dict = new MyDictionary<string, string>();
        dict.Add("id0", "content0");
        dict.Add("id1", "content1");
        dict.Add("id2", "content2");
        dict.PrintDictionary();
        Console.WriteLine(dict.FindValue("id1"));
        dict.RemoveKey("id1");
        dict.PrintDictionary();
    }
}