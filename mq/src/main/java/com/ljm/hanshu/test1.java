package com.ljm.hanshu;

import java.util.function.IntBinaryOperator;

public class test1 {

    public static void main(String[] args) {

        int num = num(new IntBinaryOperator() {
            @Override
            public int applyAsInt(int left, int right) {
                return 0;
            }
        });
    }
    public static int  num (IntBinaryOperator operator){
        int a =0;
        int b=10;
        return a+b;
    }


}
