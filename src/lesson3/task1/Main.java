package lesson3.task1;

public class Main {
    public static void main(String[] args) {
        BaseHuman human = Human.create("Pavel",20);
//        human.setAge(20);
        human.printDisplayInfo();
    }
}
