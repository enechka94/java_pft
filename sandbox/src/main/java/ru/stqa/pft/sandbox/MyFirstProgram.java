package ru.stqa.pft.sandbox;

public class MyFirstProgram {
    public static void main(String[] args) {

        hello("world");
        hello("user");
        hello("Evgeniya");

        Square s = new Square(8);
        System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());

        Rectangle c = new Rectangle(3,7);

        System.out.println("Площадь прямоугольника со сторонами " + c.a + " и " + c.b + " = " + c.area());
    }

    public static void hello(String somebody) {

        System.out.println("Hello, " + somebody + "!");
    }

}