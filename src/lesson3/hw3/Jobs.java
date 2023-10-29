package lesson3.hw3;


import java.util.Collections;
import java.util.List;

public class Jobs {
    public static void main(String[] args) {

        Human worker1 = new Worker("Elon", 18, 4000);
        Human worker2 = new Worker("Fill", 38, 5000);
        Human worker3 = new Worker("Jo", 19, 1500);
        Human freelancer1 = new Freelancer("Peter", 20, 25);
        Human freelancer2 = new Freelancer("Mark", 12, 20);
        Human freelancer3 = new Freelancer("Egor", 40, 15);


        adder(Human.workerList, worker1, worker2, worker3,freelancer1, freelancer2, freelancer3);

        Collections.sort(Human.workerList, new SortedByHuman());
        printList(Human.workerList);

    }

    public static void adder(List<Human> work, Human... object) {
        Collections.addAll(work, object);
    }

    public static void printList(List<Human> work) {
        for (Human human : work) {
            System.out.println(human);

        }
    }
}


