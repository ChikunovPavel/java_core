package lesson4.task.task2;

import java.io.FileWriter;
import java.io.IOException;

public class Program {
    /**
     * задача 2
     * =========
     * запишите в файл следуюшие строки
     * Анна = 4
     * Елена = 5
     * Марина = 6
     *
     * @param args
     */
    public static void main(String[] args) {
        prepareFile();

    }

    static void prepareFile() {
        try (FileWriter fileWriter = new FileWriter("name.txt")) {
            fileWriter.write("Анна  = 4\n");
            fileWriter.write("Елена = 5\n");
            fileWriter.write("Марина= 6\n");
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



