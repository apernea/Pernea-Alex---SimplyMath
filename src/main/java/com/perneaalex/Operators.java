package com.perneaalex;

public class Operators {
    // a + b
    public static double add(double a, double b) {
        return a + b;
    }

    //a - b
    public static double subtract(double a, double b){
        return a - b;
    }

    // a * b
    public static double multiply(double a, double b){
        return a * b;
    }

    // a / b
    public static double divide(double a, double b){
        return a / b;
    }

    //a^2 & a^3 & a^n
    public static double pow2(double a){
        return Math.pow(a, 2);
    }
    public static double pow3(double a){
        return Math.pow(a, 3);
    }
    public static double powN(double a, double n){
        return Math.pow(a, n);
    }


    //√x & ∛x & n√x
    public static double sqrt(double a){
        if(a >= 0)
            return Math.sqrt(a);
        else
            throw new ArithmeticException();
    }
    public static double cbrt(double a){
        return Math.cbrt(a);
    }

    //e^x
    public static double exp(double a){
        return Math.exp(a);
    }

    //log(x) & ln(x)
    public static double log(double a){
        return Math.log(a);
    }
    public static double ln(double a){
        return a;
    }

    //sin(x) & arcsin(x)
    public static double sin(double a){
        return Math.sin(a);
    }
    public static double asin(double a){
        return Math.asin(a);
    }

    //cos(x) & arccos(x)
    public static double cos(double a){
        return Math.cos(a);
    }
    public static double acos(double a){
        return Math.acos(a);
    }

    //tg(x) & arctg(x) & arctg(x/y)
    public static double tan(double a){
        return Math.tan(a);
    }
    public static double atan(double a){
        return Math.atan(a);
    }

    //factorial
    public static double fact(double a){
        if(a < 1){
            return 1;
        }
        return a * fact(a - 1);
    }

}
