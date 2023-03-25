package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает счет клиета, который содержит реквизиты и баланс.
 */
public class Account {
    private String requisite;
    private double balance;

    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }
    public String getRequisite() {
        return requisite;
    }

    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Переопределенный метод, реализует сравнение счетов по их реквизитам
     * @param o - счет клиента
     * @return boolean - сравнивает счета по реквизитам
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }
    /**
    Переопределенный метод, возвращает Hashcode
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}