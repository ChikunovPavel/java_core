package lesson3.hw3;

import java.util.Comparator;


public class SortedByHuman implements Comparator<Human> {
    @Override
    public int compare(Human human1, Human human2) {
        if (human1.salary == human2.salary) {
            return 0;
        }
        if (human1.salary < human2.salary) {
            return -1;
        }
        return 1;

    }

}
