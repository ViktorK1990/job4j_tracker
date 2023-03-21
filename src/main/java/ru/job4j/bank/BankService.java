package ru.job4j.bank;

import ru.job4j.bank.Account;
import ru.job4j.bank.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        if (!users.containsKey(user)) {
            users.put(user, new ArrayList<Account>());
        }
    }


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

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (!users.get(user).contains(account)) {
            users.get(user).add(account);
        }
    }

    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            for (Account accounts : users.get(user)) {
                if (accounts.getRequisite().equals(requisite)) {
                    return accounts;
                }
            }
        }
        return null;
    }

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

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}