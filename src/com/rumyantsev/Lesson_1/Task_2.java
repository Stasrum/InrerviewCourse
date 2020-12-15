package com.rumyantsev.Lesson_1;

//Описать ошибки в коде и предложить варианты оптимизации:

//Метод start вынести в интерфейс.
//Метод open вынести в интерфейс и implements в Car
//Объединить интерфейсы, отвечающие за движения(start,stop,move) в один и implements в Car
//После этого у LightWeightCar и Lorry оставить только extends Car
//Не соблюдается принцип открытости/закрытости. Нужно создать интерфейс IEngine и создать класс Engine implements IEngine
//Создать factory для реализации принципа инверсии зависимости:
//class CarFactory {
//    public static Car makeCar(String color, String name, Engine engine) {
//        return new Car(color, name, engine);
//    }


    interface Moveable {
        void move();
    }

    interface Stopable {
        void stop();
    }

    abstract class Car {
        public Engine engine;
        private String color;
        private String name;


        protected void start() {
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

    class LightWeightCar extends Car implements Moveable{

        @Override
        void open() {
            System.out.println("Car is open");
        }

        @Override
        public void move() {
            System.out.println("Car is moving");
        }

    }

    class Lorry extends Car, Moveable, Stopable{

        public void move(){
            System.out.println("Car is moving");
        }

        public void stop(){
            System.out.println("Car is stop");
        }
    }
