/*
 * Dmitry Ozhigin
 *  Lesnoytishka@gmail.com
 *  2020 - 6 - 18
 */

package Polymorph;

public class MainPoly {
    public static void main(String[] args) {
        Shape shape1 = new Circle();
        Shape shape2 = new Square();
        Shape shape3 = new Triangle();

        shape1.draw();
        shape2.draw();
        shape3.draw();
    }
}
