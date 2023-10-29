package lesson3.task1;

public class Human extends BaseHuman{
    private Human(String name,int age) {
        super(name, age);
    }

    @Override
    public void printDisplayInfo(){
        System.out.printf("%s - %d", name, age);
    }

    public static BaseHuman create(String name, int age){
        if(name == null || name.length() < 3){
            throw new RuntimeException("Некороектное имя челека");
        }
        if(age < 10 ){
            throw new RuntimeException("Некороектное возраст человека");
        }
        return new Human(name,age);
    }


    @Override
    public String toString() {
        return String.format("%s - %d", name, age);
    }
}
