package lesson3.task1;

public abstract class BaseHuman {
    protected String name;
    protected int age;

    protected BaseHuman(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public abstract void printDisplayInfo();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        if (age < 10) {
            throw new RuntimeException("Некороектное возраст человека");
        }
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
