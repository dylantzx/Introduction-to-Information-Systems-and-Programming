package com.example.problemset1a;

public class Triangle extends GeometricObject {
    public static void main(String[] args) {
        Triangle myTri = new Triangle();
        myTri.setColor("red");
        myTri.setFilled(true);
        System.out.println(myTri);
        System.out.println(myTri.isFilled());

        Triangle myTri2 = new Triangle(2.0, 4.0, 5.5);
        System.out.println(myTri2);
        System.out.println("area : " + myTri2.getArea() + " perimeter: " + myTri2.getPerimeter());
    }

    private double side1, side2, side3;
    public Triangle(){
        this(1,1,1);
    }
    public Triangle(double side1, double side2, double side3){
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }
    public double getArea(){
        double s = (this.side1 + this.side2 + this.side3)/2;
        return Math.sqrt(s*(s-this.side1)*(s-this.side2)*(s-this.side3));
    }

    public double getPerimeter(){
        return this.side1 + this.side2 + this.side3;
    }
    public String toString(){
        return "Triangle: side1 = " + this.side1 + " side2 = " + this.side2 + " side3 = " + this.side3;
    }
}

class GeometricObject{
    String color;
    boolean filled;
    void setColor(String color){ this.color = color;}
    void setFilled(boolean filled){ this.filled = filled;}
    boolean isFilled(){return this.filled;}

}