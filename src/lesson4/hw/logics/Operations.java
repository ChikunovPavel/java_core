package lesson4.hw.logics;

import lesson4.hw.entity.Human;
import lesson4.hw.exception.InsufficientFundsException;

public interface Operations {
    void showBalance(Human account);
    void withdraw(int after) throws InsufficientFundsException;
    void putOnDebetCart(int transfer);
    void create(int startedMoney);

    void showDebet(Human account);
}



