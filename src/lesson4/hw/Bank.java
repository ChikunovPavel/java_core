package lesson4.hw;

import lesson4.hw.entity.Account;
import lesson4.hw.entity.Human;
import lesson4.hw.exception.InsufficientFundsException;
import java.util.Scanner;



public class Bank {

    public static void main(String[] args)  {

        Account account1 = new Account(new Human(12, "Pavel"));

        Scanner scanner = new Scanner(System.in);
        int option;
        do {
            System.out.println();
            System.out.println("Добро пожаловать ");
            System.out.println("~~~~~~~~~~~~~~~~");
            System.out.println("Выберите действие");
            System.out.println("1. Cоздать счет");
            System.out.println("2. Посмотреть баланс");
            System.out.println("3. Перевести деньги на девозит");
            System.out.println("4. Снять наличные");
            System.out.println("5. Показать сумму на депозите");
            System.out.println("6. Выйти");
            System.out.println("~~~~~~~~~~~~~~~~");
            System.out.println();
            option = scanner.nextInt();
            switch (option) {

                case 1 -> {
                    try {
                        System.out.println("Введите сумму"+ "\n");
                        account1.create(scanner.nextInt());
                    } catch (IllegalArgumentException exception) {
                        System.out.printf(exception.getMessage());
                    }

                }

                case 2 -> {
                    System.out.println("На счету" + " \n");
                    account1.showBalance(account1.getAccount());
                }
                case 3 -> {
                    try {
                        System.out.println("Введите сумму"+ "\n");
                        account1.putOnDebetCart(scanner.nextInt());
                    } catch (IllegalArgumentException exception) {
                        System.out.printf(exception.getMessage());

                    }
                }

                case 4 -> {
                    try {
                        System.out.println("Введите сумму"+ "\n");
                        account1.withdraw(scanner.nextInt());
                    } catch ( InsufficientFundsException exception) {
                        System.out.printf(exception.getMessage());
                    }
                }

                case 5 -> {
                    System.out.println("На депозите" + " \n");
                    account1.showDebet(account1.getAccount());
                }
                case 6 -> System.out.println("~~~~~~~~~~~~~~~~");
                default -> System.err.println("Не правильная  операция поробуйте еще");
            }
        }
        while (option != 6);
        System.out.println("Всего доброго");

    }
}











