package lesson3.hw3;

import java.util.ArrayList;
import java.util.List;

public abstract class Human implements Comparable<Human> {


    protected String name;
    protected int age;

    protected int salary;

    static List<Human> workerList = new ArrayList<>();

    public Human(int salary, String name, int age) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }


    public abstract double salaryСalculation();

    @Override
    public int compareTo(Human human) {
        if (salary == human.salary) {
            return 0;
        }
        if (salary < human.salary) {
            return -1;
        }
        return 1;
    }
}
