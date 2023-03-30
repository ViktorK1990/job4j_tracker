package ru.job4j.bank;

import ru.job4j.bank.Account;
import ru.job4j.bank.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс осуществляет операции со счетами клиентов
 */
public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет клиента в базу
     *
     * @param user - новый колиент
     */
    public void addUser(User user) {
        if (!users.containsKey(user)) {
            users.put(user, new ArrayList<Account>());
        }
    }

    /**
     * Метод ищет пользователя по паспорту и удаляет его из базы
     *
     * @param passport - паспорт клиента
     * @return - возвращает true, если клиент был успешно удален из базы
     */
    public boolean deleteUser(String passport) {
        boolean result = false;
        for (User delete : users.keySet()) {
            if (delete.getPassport().equals(passport)) {
                users.remove(delete);
                result = true;
            }
        }
        return result;
    }

    /**
     * Метод добавляет счет клиенту, если этого счета еще нет в базе
     *
     * @param passport - принимает паспорт
     * @param account  - принимает новый счет
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (!users.get(user).contains(account)) {
            users.get(user).add(account);
        }
    }

    /**
     * Метод осуществляет поиск клиента по номеру паспорта
     *
     * @param passport - принимает паспорт
     * @return - возвращает найденного пользователя
     */


    public User findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(user -> user.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод осуществляет поиск счета по реквизитам и номеру паспорта
     *
     * @param passport  - паспорт клиента
     * @param requisite - реквизиты счета
     * @return - возаращает счет клиента
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
          return   users.get(user)
                    .stream()
                    .filter(e -> e.getRequisite().equals(requisite))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    /**
     * Метод осуществляет перевод с одгого счета на другой
     *
     * @param srcPassport   -  паспорт клиента который осуществляет перевод
     * @param srcRequisite  - реквизиты счета, с которого будет выполняться перевод
     * @param destPassport  - паспорт клиента, которому будет доставлен перевод
     * @param destRequisite - реквизиты счета, на который будет осуществляться перевод
     * @param amount        - сумма перевода
     * @return - возвращает true, если перевод был успешным
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account accountSrc = findByRequisite(srcPassport, srcRequisite);
        Account accountDent = findByRequisite(destPassport, destRequisite);
        if (accountSrc != null && accountDent != null && accountSrc.getBalance() >= amount) {
            accountSrc.setBalance(accountSrc.getBalance() - amount);
            accountDent.setBalance(accountDent.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }

    /**
     * Возвращает клиента из базы
     *
     * @param user - клиент
     * @return
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}