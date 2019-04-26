package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс отвечает за хранение учётных записей клиентов банка.
 *
 * @author Шавва Максим.
 * @version 1.2
 * @since 21.04.2019г.
 */
public class Bank {

    /**
     * Список клиентов банка с их счетами.
     */
    private HashMap<User, ArrayList<Account>> users = new HashMap<>();

    /**
     * @param user Новый клиент банка.
     */
    public void addUser(User user) {
        this.users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * @param user Удаляем клиента из банка.
     */
    public void deleteUser(User user) {
        this.users.remove(user);
    }

    /**
     * @param user    Клиент, которому добавляем счёт.
     * @param account Новый счёт.
     */
    public void addAccountToUser(User user, Account account) {
        this.users.computeIfPresent(user, (client, accounts) -> {
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
            return accounts;
        });
    }

    /**
     * @param user    Клиент, у которого удаляем счёт.
     * @param account Счёт, который удаляется.
     */
    public void deleteAccountFromUser(User user, Account account) {
        this.users.computeIfPresent(user, (client, accounts) -> {
            accounts.remove(account);
            return accounts;
        });
    }

    /**
     * @param user Клиент.
     * @return Список счетов клиента.
     */
    public List<Account> getAccounts(User user) {
        return this.users.get(user);
    }

    /**
     * @param srcPassport  Паспорт первого клиента.
     * @param destPassport Паспорт второго клиента.
     * @param srcRequisite Номер счёта первого клиента.
     * @param dstRequisite Номер счёта второго клиента.
     * @param amount       количество денег.
     * @return Результат перевода. При удачном раскладе - true.
     */
    public boolean transferMoney(
            String srcPassport,
            String srcRequisite,
            String destPassport,
            String dstRequisite,
            double amount) {
        Account first = findAccount(srcPassport, srcRequisite);
        Account second = findAccount(destPassport, dstRequisite);
        return first != null && second != null && first.transfer(second, amount);
    }

    /**
     * @param passport  паспортные данные клиента.
     * @param requisite номер счёта клиента.
     * @return счёт клиента.
     */
    private Account findAccount(String passport, String requisite) {
        List<Account> result = users.keySet().stream()
                .filter(user -> user.getPassport().equals(passport))
                .flatMap(user -> users.get(user).stream())
                .filter(account -> account.getReqs().equals(requisite))
                .distinct()
                .collect(Collectors.toList());
        return result.get(0);
    }

    @Override
    public String toString() {
        return "Bank{" + "accounts=" + users + "}";
    }
}