package lesson2;

import java.util.Random;
import java.util.Scanner;

public class Program {

    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = '0';
    private static final char DOT_EMPTY = '*';
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();
    private static char[][] field;// Двумерный массив хранит состояние игрового поля

    private static int fieldSizeX;//размерность игрового поля
    private static int fieldSizeY;//размерность игрового поля
    private static final int WIN_COUNT = 3;//Кол-во фишек для победы
    public static void main(String[] args) {
        while (true) {
        initialize();
        printField();
            while (true) {
            humanTurn();
            printField();
            //TODO: Проверка на ничью и на победу
                if(gameCheck(DOT_HUMAN,"Вы победили"))
                    break;
                aiTurn();
                printField();
                if(gameCheck(DOT_AI,"PS победили"))
                    break;
                //TODO: Проверка на ничью и на победу
            }
            System.out.print("Желаете еще раз играть? (Y - да)");
            if(!scanner.next().equalsIgnoreCase("Y"))
                break;;
        }


    }

    /**
     * Инициализация начального состояния игры
     */
    private static void initialize(){
        fieldSizeX = 5;
        fieldSizeY = 5;
        field = new char[fieldSizeY][fieldSizeX];
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                field[y][x] = DOT_EMPTY;
            }
        }
    }




    /**
     * отрисовать текушее состояния игрового поля
     */
    private static void printField(){

        System.out.print("+");

        for (int i = 0; i < fieldSizeX * 2 + 1; i++) {
            System.out.print((i % 2 == 0) ? "-" : i / 2 + 1 );
            }
        System.out.println();
        for (int i = 0; i < fieldSizeY; i++) {
            System.out.print(i+ 1 + "|");
            for (int j = 0; j < fieldSizeX; j++) {
                System.out.print( field[i][j] + "|");
            }
            System.out.println();
        }

        for (int i = 0;i  < fieldSizeX * 2 + 2; i++) {
            System.out.print("-");
        }
    }

    private static void humanTurn(){
        int x,y;
        do{
            System.out.print("Укажите координаты хода x и y (от 1 до 3) \n через пробел ");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;

        }
        while (!isCellValid(x,y) || !isCellEmpty(x,y)  );
        field[x][y] = DOT_HUMAN;
    }

    /**
     * Обработка хода компьютера
     */
    static void aiTurn(){
        int x,y;
        do{
            System.out.print("Укажите координаты хода x и y (от 1 до 3) \n через пробел ");
            x = random.nextInt(fieldSizeX);
            y = random.nextInt(fieldSizeY);

        }
        while (!isCellEmpty(x,y));
        field[x][y] = DOT_AI;

    }

    /**
     * Проверка ячейка являеться пустой
     */
    static boolean isCellEmpty(int x , int y){
        return field[x][y] == DOT_EMPTY;
    }

    /**
     * Проверка состояния игры
     * @param dot фишка игрока
     * @param winStr победный слоган
     * @return признак продожения игры(true - завершение игры)
     */
    static boolean gameCheck(char dot, String winStr){
        if (checkWin(dot)){
            System.out.println(winStr);
            return true;
        }
        if(checkDraw()){
            System.out.println("Ничья!");
            return true;
        }
        return false;


    }

    /**
     * Проверка корректности ввода
     */
    static boolean isCellValid(int x, int y){
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    /**
     *  Проверка победы
     */
    static boolean checkWin(char c){
        // проверка по горизонталям
        if (field[0][0] == c && field[0][1] == c && field[0][2] == c) return  true;
        if (field[1][0] == c && field[1][1] == c && field[1][2] == c) return  true;
        if (field[2][0] == c && field[2][1] == c && field[2][2] == c) return  true;
        // проверка по вертикали

        if (field[0][0] == c && field[1][0] == c && field[2][0] == c) return  true;
        if (field[0][1] == c && field[1][1] == c && field[2][1] == c) return  true;
        if (field[0][2] == c && field[1][2] == c && field[2][2] == c) return  true;

        // проверка по диагонали
        if (field[0][0] == c && field[1][1] == c && field[2][2] == c) return  true;
        if (field[0][2] == c && field[1][1] == c && field[2][0] == c) return  true;


        return false;


    }

    /**
     * Проверка на ни чью
     */
    static boolean checkDraw(){
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if(isCellValid(i,j)) return false;
            }
        }
        return true;
    }
}








