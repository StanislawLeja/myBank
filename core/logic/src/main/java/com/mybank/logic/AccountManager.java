package com.mybank.logic;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Created by Stanisław Leja on 07.01.18.
 */
public class AccountManager {

    private Map<Long,Account> accounts;

    private static long lastCreatedAccountNumber;

    public AccountManager() {
        this.accounts = new HashMap<Long,Account>();
        lastCreatedAccountNumber = 0;
    }

    public static long getLastCreatedAccountNumber() {
        return lastCreatedAccountNumber;
    }

    public long createAccount(String name, String surname){
        Account newAccount = new Account(++lastCreatedAccountNumber,new AccountOwnerData(name,surname));
        this.accounts.put(lastCreatedAccountNumber,newAccount);
        return lastCreatedAccountNumber;
    }

    public void removeAccount(long accountId){
        this.accounts.remove(accountId);
    }

    public Optional<Account> getAccount(long accountId){
        return Optional.ofNullable(this.accounts.get(accountId));
    }

}
