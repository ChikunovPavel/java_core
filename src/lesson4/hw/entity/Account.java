package lesson4.hw.entity;

import lesson4.hw.exception.InsufficientFundsException;
import lesson4.hw.logics.Operations;

public class Account implements Operations {
    private int balance;
    private int debet;
    private Human account;

    public Account(Human account) {

        this.account = account;
    }

    @Override
    public void withdraw(int after) throws InsufficientFundsException {
        if (balance < after) {
            throw new InsufficientFundsException("Недостаточно средств на счету. остаток : " + balance);
        }
        this.balance -= after;


    }


    @Override
    public void putOnDebetCart(int transfer) throws IllegalArgumentException {

        if (transfer <= 0 || transfer > this.balance) {
            throw new IllegalArgumentException("Сумма вклада на депозит должна быть больше 0 и не больше чем есть на основном счету");
        }

        this.debet += transfer;
        this.balance -= transfer;
    }

    @Override
    public void create(int startedMoney) throws IllegalArgumentException {
        if (startedMoney <= 0) {
            throw new IllegalArgumentException("Сумма открытия счета должна быть больше 0");
        }

        this.balance += startedMoney;
    }

    @Override
    public void showBalance(Human account) {
        System.out.println(getBalance());
    }


    @Override
    public void showDebet(Human account) {
        System.out.println(getDebet());
    }

    public int getDebet() {
        return debet;
    }

    public int getBalance() {
        return balance;
    }


    public Human getAccount() {
        return account;
    }

    @Override
    public String toString() {
        return "на счету " + "доступно: " + balance;
    }
}
