package lesson3.hw3;

public class Worker extends Human {

    public Worker(String name, int age, int salary) {
        super(salary,name, age );
    }

    @Override
    public double salaryСalculation() {
        return super.salary;
    }

    @Override
    public String toString() {
        return "Worker: " + "Имя: " + name + ". Возраст: " + age + ". зарплата:" + salaryСalculation();
    }
}
