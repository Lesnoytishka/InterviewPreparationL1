/*
 * Dmitry Ozhigin
 *  Lesnoytishka@gmail.com
 *  2020 - 6 - 17
 */

package CodeErrors;


public abstract class Car {
    public Engine engine;
    private String color;
    private String name;


    protected void start(){
        System.out.println("Car starting");
    }

    abstract void open();

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

}
