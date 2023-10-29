package lesson3.hw3;

public class Freelancer extends Human {


    public Freelancer(String name, int age, int salary) {
        super(salary,name, age);
    }

    @Override
    public double salaryСalculation() {
        double average = 0;
        average = 20.8 * 8 * super.salary;

        return average;
    }

    @Override
    public String toString() {
        return "Freelancer: " + "Имя: " + name + ". Возраст: " + age + ". зарплата:" + salaryСalculation();
    }
}
