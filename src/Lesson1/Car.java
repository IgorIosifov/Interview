package Lesson1;

class Engine{
}

class Car{
    private Engine engine;
    private String color;
    private String name;


    void start(){
        System.out.println("Car started");
    }

    void open(){
        System.out.println("Car opened");
    };
    void move(){
        System.out.println("Car is moving");
    };
    void stop(){
        System.out.println("Car stopped");
    };

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

class LightWeightCar extends Car{
    //override some methods if it's needed
}

class Lorry extends Car{
    //override some methods if it's needed
}

