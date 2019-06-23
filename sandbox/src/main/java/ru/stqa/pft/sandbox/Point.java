package ru.stqa.pft.sandbox;

import java.sql.SQLOutput;

public class Point {

    public double x;
    public double y;

    public Point (double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static double distance(Point p1, Point p2) {
        return Math.sqrt((p2.y-p1.y) *  (p2.y-p1.y) + (p2.x - p1.x) * (p2.x - p1.x));

    }

    public static void main(String[] args) {
        Point p1 = new Point (1,1);
        Point p2 = new Point (1, 4);
        double distance = distance(p1, p2);
        System.out.println("Расстояние между точками равно " + distance);
    }
}
