package com.example.problemset1a;

public class MyRectangle2D {

    public static void main(String [] args){
        MyRectangle2D rec1 = new MyRectangle2D(0, 0, 10, 10);
//        System.out.printf("%f, %f, %f, %f, %f, %f\n", rec1.getX(), rec1.getY(), rec1.getWidth(), rec1.getHeight(), rec1.getArea(), rec1.getPerimeter());
        boolean contained = rec1.contains(4, 7);
        System.out.println(contained);

        MyRectangle2D rec2 = new MyRectangle2D(4, 2, 4, 4);
//        System.out.printf("%f, %f, %f, %f, %f, %f\n", rec2.getX(), rec2.getY(), rec2.getWidth(), rec2.getHeight(), rec2.getArea(), rec2.getPerimeter());
        boolean contain_rec = rec1.contains(rec2);
        System.out.println(contain_rec);
        boolean overlap_rec = rec1.overlaps(rec2);
        System.out.println(overlap_rec);
    }

    private double x;
    private double y;
    private double width;
    private double height;

    public MyRectangle2D(){
        x = 0;
        y = 0;
        width = 1;
        height = 1;
    }

    public MyRectangle2D(double x, double y, double width, double height){
        setX(x);
        setY(y);
        setWidth(width);
        setHeight(height);
    }

    public double getX(){return this.x;}

    public double getY(){return this.y;}

    public void setX(double x){this.x = x;}

    public void setY(double y){this.y = y;}

    public double getWidth(){return this.width;}

    public double getHeight(){return this.height;}

    public void setWidth(double width){this.width = width;}

    public void setHeight(double height){this.height = height;}

    public double getArea(){return this.width * this.height;}

    public double getPerimeter(){return 2*(this.width + this.height);}

    public boolean contains(double x, double y){
        if ( x > (this.x - this.width/2) && x < (this.x + this.width/2) && y > (this.y - this.height/2) && y < (this.y + this.height/2)){ return true;}
        else {return false;}
    }

    public boolean contains(MyRectangle2D r){
        double check_right_width = r.getX() + r.getWidth()/2;
        double check_left_width = r.getX() - r.getWidth()/2;


        double right_bound = this.getX() + this.getWidth()/2;
        double left_bound = this.getX() - this.getWidth()/2;

        double check_top_height = r.getY() + r.getHeight()/2;
        double check_bottom_height = r.getY() - r.getHeight()/2;

        double top_bound = this.getY() + this.getHeight()/2;
        double bottom_bound = this.getY() - this.getHeight()/2;

        if (check_right_width < right_bound && check_left_width > left_bound && check_top_height < top_bound && check_bottom_height > bottom_bound){return true;}
        else {return false;}
    }

    public boolean overlaps(MyRectangle2D r){
        double check_right_width = r.getX() + r.getWidth()/2;
        double check_left_width = r.getX() - r.getWidth()/2;


        double right_bound = this.getX() + this.getWidth()/2;
        double left_bound = this.getX() - this.getWidth()/2;

        double check_top_height = r.getY() + r.getHeight()/2;
        double check_bottom_height = r.getY() - r.getHeight()/2;

        double top_bound = this.getY() + this.getHeight()/2;
        double bottom_bound = this.getY() - this.getHeight()/2;

        boolean outside = false;

        if ((check_left_width > right_bound) || (check_top_height < bottom_bound)|| (check_right_width < left_bound) || (check_bottom_height > top_bound)){
            outside = true;
        }

        if (this.contains(r) == false && outside == false){return true;}
        else {return false;}
    }
}
