/*
 * Dmitry Ozhigin
 *  Lesnoytishka@gmail.com
 *  2020 - 6 - 17
 */

package CodeErrors;

public class LightWeightCar extends Car implements Moveable {

    @Override
    void open() {
        System.out.println("Car is open");
    }

    @Override
    public void move() {
        System.out.println("Car is moving");
    }

}
