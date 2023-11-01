package lesson4.task.task3;

public abstract class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }

    abstract void swim();
    abstract void run();
}
