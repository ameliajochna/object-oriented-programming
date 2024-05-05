/*
Amelia Jochna 
Lista 3 Zadanie 2
*/

using System;
using System.Diagnostics;

public class MyDictionary<K, V>
{
    public MyDictionary<K, V> next;
    public K key;
    public V value;

    public MyDictionary()
    {
        key = default(K);
        value = default(V);
        next = null;
    }

    public void PrintDictionary()
    {
        MyDictionary<K, V> current = this;
        Console.WriteLine("DICTIONARY CONTENT:");
        while (current != null)
        {
            Console.WriteLine(current.key + " " + current.value);
            current = current.next;
        }
    }

    public bool IsKeyInDictionary(K findingKey)
    {
        MyDictionary<K, V> current = this;
        while (current != null)
        {
            if (current.key != null && current.key.Equals(findingKey))
                return true;
            current = current.next;
        }
        return false;
    }

    public void Add(K addingKey, V addingValue)
    {
        if (IsKeyInDictionary(addingKey))
            throw new ArgumentException("Key is already in the dictionary.");

        MyDictionary<K, V> current = this;
        while (current.next != null)
            current = current.next;

        current.next = new MyDictionary<K, V>();
        current.next.key = addingKey;
        current.next.value = addingValue;
    }

    public V FindValue(K findingKey)
    {
        MyDictionary<K, V> current = this;
        while (current != null)
        {
            if (current.key!=null && current.key.Equals(findingKey))
                return current.value;
            current = current.next;
        }

        throw new ArgumentException("Key is not in the dictionary.");
    }

    public void RemoveKey(K removingKey)
    {
        if (key!=null && key.Equals(removingKey))
        {
            this.key = next.key;
            this.value = next.value;
            this.next = next.next;
            return;
        }

        MyDictionary<K, V> current = this;
        MyDictionary<K, V> previous = null;
        while (current != null)
        {
            if (current.key != null && current.key.Equals(removingKey))
            {
                if (previous != null)
                    previous.next = current.next;
                return;
            }
            previous = current;
            current = current.next;
        }

        throw new ArgumentException("Key is not in the dictionary.");
    }

}