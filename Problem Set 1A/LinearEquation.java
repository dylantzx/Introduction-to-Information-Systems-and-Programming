package com.example.problemset1a;

import java.util.LinkedList;

import javax.swing.UIDefaults;

public class LinearEquation {

    public static void main(String[] args) {
        double a = 1.0; double b = 2.0; double c = 3.0;
        double d = 5.0; double e = 6.0; double f = 7.0;

        LinearEquation equation = new LinearEquation(a, b, c, d, e, f);
        if (equation.isSolvable()) {
            System.out.println("x is " +
                    equation.getX() + " and y is " + equation.getY());
        }
        else {
            System.out.println("The equation has no solution");
        }

        LinearEquation equation2 = new LinearEquation(1.25, 2.0, 2.0, 4.2, 3.0, 6.0);
        if (equation2.isSolvable()) {
            System.out.println("x is " + equation2.getX() + " y is " + equation2.getY());
        }

        LinearEquation equation3 = new LinearEquation(1.0, 2.0, 2.0, 4.0, 3.0, 6.0);
        System.out.println(equation3.isSolvable());
    }


    private double a,b,c,d,e,f,x,y,determinant;

    // Constructor
    public LinearEquation(double a, double b, double c, double d, double e, double f){
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.determinant = this.a * this.d - this.c*this.b;
    }

    // Getter
    public double getA(){ return this.a; }
    public double getB(){ return this.b; }
    public double getC(){ return this.c; }
    public double getD(){ return this.d; }
    public double getE(){ return this.e; }
    public double getF(){ return this.f; }

    // Inverse matrix is 1/determinant[[d,-b], [-c, a]]
    public double getX(){ return (1/(this.determinant))*(this.d*this.e +(-this.b)*this.f); }
    public double getY(){ return (1/(this.determinant))*((-this.c)*this.e + this.a*this.f); }

    // Other Methods
    public boolean isSolvable(){
        if (this.determinant != 0) return true;
        else return false;
    }

}

