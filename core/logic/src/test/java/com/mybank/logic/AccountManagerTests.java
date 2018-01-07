package com.mybank.logic;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Created by Stanisław Leja on 07.01.18.
 */
public class AccountManagerTests {


    @Test
    public void createAccount(){
        AccountManager accountManager = new AccountManager();
        long accountId = accountManager.createAccount("Jan","Kowalski");
        assertEquals(accountId,accountManager.getAccount(accountId).get().getAccountID());
    }

    @Test
    public void removeAccount(){
        AccountManager accountManager = new AccountManager();
        long accountId = accountManager.createAccount("Jan","Kowalski");
        assertEquals(accountId,accountManager.getAccount(accountId).get().getAccountID());
        accountManager.removeAccount(accountId);
        assertFalse(accountManager.getAccount(accountId).isPresent());
    }

    @Test
    public void findAccount(){
        AccountManager accountManager = new AccountManager();
        long accountId = accountManager.createAccount("Jan","Kowalski");
        accountManager.createAccount("Jan","Kowalski");
        accountManager.createAccount("Adam","Małysz");
        accountManager.createAccount("Kamil","Stoch");
        assertEquals("Kowalski",accountManager.getAccount(accountId).get().getSurname());
    }

}
