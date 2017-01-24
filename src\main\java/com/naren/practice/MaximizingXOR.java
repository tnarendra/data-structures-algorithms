package com.naren.practice;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MaximizingXOR {


    static int maxXor(int l, int r) {
    	 int maxNum = 0;
    	 
    	 while(l<=r){
    		 int l1=l;
    		 while(l1<=r){
    			 int tmp = l^l1;
    			 if(tmp>maxNum)
    				 maxNum = tmp;
    			 l1++;
    		 }
    		 l++;
    	 }
    	
    	return maxNum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;
        int _l;
        _l = Integer.parseInt(in.nextLine());
        
        int _r;
        _r = Integer.parseInt(in.nextLine());
        
        res = maxXor(_l, _r);
        System.out.println(res);
        
    }
}

