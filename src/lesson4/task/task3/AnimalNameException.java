package lesson4.task.task3;

public class AnimalNameException extends AnimalException {
    private final String name;

    public String getName() {
        return name;
    }

    public AnimalNameException(String massege,String name) {
        super(massege);
        this.name = name;
    }
}
