/*
 * Dmitry Ozhigin
 *  Lesnoytishka@gmail.com
 *  2020 - 6 - 17
 */

package CodeErrors;

public class Lorry extends Car, Moveable, Stopable {
    public void move(){
        System.out.println("Car is moving");
    }

    public void stop(){
        System.out.println("Car is stop");
    }
}
