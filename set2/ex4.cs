using System;

public class LazyIntList{
    protected List<int> list;

    public LazyIntList(){
        list = new List<int>();
    }
    public virtual int element(int i){
        for(int j=list.Count; j<i; j++)
            list.Add(j+1);
        
        return list[i-1];
    }
    public int size(){
        return list.Count;
    }
}

public class LazyPrimeList : LazyIntList{
    private int lastNumber = 1;
    private bool isPrime(int n){
        if(n < 2)
            return false;
        for(int i = 2; i*i <= n; i++)
            if(n % i == 0)
                return false;
        return true;
    }

    public override int element(int i){
        while(size()<i){
            if (isPrime(lastNumber))
                list.Add(lastNumber);
            lastNumber++;
        }
        return list[i-1];
    }
}

class Program{
    static void Main(string[] args){
        LazyIntList list = new LazyIntList();
        Console.WriteLine(list.element(55));
        Console.WriteLine(list.size());
        Console.WriteLine(list.element(52));
        Console.WriteLine(list.size()); 
    
        LazyPrimeList primeList = new LazyPrimeList();
        Console.WriteLine(primeList.element(10));
        Console.WriteLine(primeList.size());
        Console.WriteLine(primeList.element(17));
        Console.WriteLine(primeList.size());

    }
}