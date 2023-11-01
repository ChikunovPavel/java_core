package lesson4.task.task3;

public class Cat  extends  Animal{
    private Cat(String name) {
        super(name);
    }

    public Cat Create() throws AnimalNameException{

            if(name == null || name.length() < 3){
                throw new AnimalNameException("Некоректное имя животного", name);
            }
            return new Cat(name);
    }

    @Override
    void swim() {

    }

    @Override
    void run() {

    }
}
