package com.naren.practice.hr.DP;

import java.math.BigInteger;
import java.util.Scanner;

public class FibDynamic {
	
    static BigInteger fib(int first, int second, int n)
    {
    BigInteger f[] = new BigInteger[n];
    int i;
      
    f[0] = BigInteger.valueOf(first);
    f[1] = BigInteger.valueOf(second);
     
    for (i = 2; i < n; i++)
    {
        f[i] = f[i-2].add((f[i-1].multiply(f[i-1])));
    }
      
    return f[n-1];
    }
      
    public static void main (String args[])
    {
        Scanner in = new Scanner(System.in);
       
        System.out.println(fib(in.nextInt(), in.nextInt(), in.nextInt()).toString());
    }
}