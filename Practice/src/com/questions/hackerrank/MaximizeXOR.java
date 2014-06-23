package com.questions.hackerrank;

import java.util.Scanner;

public class MaximizeXOR {


    static int maxXor(int l, int r) {
		
    	
    	return r;
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
