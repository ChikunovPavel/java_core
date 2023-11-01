package lesson4.task.task1;

import java.util.Random;

/**
 * Напишите метод на вход которого подается двумерный строковый массив размеров м 4 На 4
 * При подаче массива другого размера нужно выбросить исключение MyArraySizeException.
 */

public class Program {
    private static Random random = new Random();

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            System.out.printf("\n******* Итерации №%d ******\n", i + 1);
            processArray();
        }
    }

    public static void processArray() {
        try {
            processArrayInternal(generateArray());
        } catch (MyArrayDataException exception) {
            System.out.printf("%s по индексу [%d][%d]\n", exception.getMessage(), exception.getX(), exception.getY());

        } catch (MyArraySizeException exception) {
            System.out.printf("%s требовалось 4х4, получили %dх%d\n", exception.getMessage(), exception.getX(), exception.getY());

        } catch (NullPointerException exception) {
            exception.printStackTrace();

        }

    }


    /**
     * Получить сумму элементов массива
     *
     * @param array массив
     * @return сумму элементов
     * @throws MyArraySizeException Некорректный размер массива
     * @throws MyArrayDataException Некорректный формат данных
     * @throws NullPointerException массив должен су шествовать
     */


    public static int processArrayInternal(String[][] array) throws MyArraySizeException, MyArrayDataException, NullPointerException {
        if (array == null) {
            throw new NullPointerException("Массив должен существовать");
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                throw new NullPointerException("Массив должен существовать");
            }

        }
        if (array.length != 4 && array[0].length != 4) {
            throw new MyArraySizeException("Некорректный размер массива", array.length, array[0].length);
        }

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                sum += parseElement(array[i][j], i, j);
            }
        }
        return sum;


    }

    /**
     * Вспомогательный метод, преобразует значение элемента к числу
     *
     * @param s значение элемента
     * @param x индекс элемента
     * @param y индекс элемента в массиве
     * @return число
     * @throws MyArrayDataException Некорректный формат данных
     */
    private static int parseElement(String s, int x, int y) throws MyArrayDataException {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new MyArrayDataException("Некорректный формат данных", x, y);
        }

    }


    public static String[][] generateArray() {
        int add = random.nextInt(2);
        String[][] array = new String[4 + add][4 + add];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = Integer.toString(random.nextInt(10, 100));
            }
        }
        if (random.nextInt(3) == 0) {
            array[random.nextInt(array.length)][random.nextInt(array.length)] = "abc";

        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.printf("%s\t", array[i][j]);
            }
            System.out.println();
        }


        return array;


    }
}
