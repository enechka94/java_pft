package ru.stqa.pft.sandbox;

import java.sql.SQLOutput;

public class Point {

    public double x;
    public double y;

    public Point (double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distance(Point p2) {
        return Math.sqrt((p2.y-this.y) *  (p2.y-this.y) + (p2.x - this.x) * (p2.x - this.x));

    }

    public static void main(String[] args) {
        Point p1 = new Point (1,0);
        Point p2 = new Point (1, 8);
        System.out.println("Расстояние между точками равно " + p1.distance(p2));
    }
}
