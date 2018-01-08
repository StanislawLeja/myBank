package com.mybank.logic;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Stanisław Leja on 08.01.18.
 */
public class bankAPITests {
    @Test
    public void moneyTransferTest(){
        BakAPI bankAPI = new BakAPI();
        long accountId = bankAPI.createBankAccount("Adam","Małysz",1000000);
        long accountId2 = bankAPI.createBankAccount("Kamil","Stoch",200000);
        TransferPool transferPool1 = new TransferPool();

        try {
            bankAPI.transferMoney(accountId,accountId2,50000);
            bankAPI.transferMoney(accountId,accountId2,50000);
            bankAPI.transferMoney(accountId,accountId2,50000);
            bankAPI.transferMoney(accountId,accountId2,40000);
        } catch (TransferException e) {
            e.printStackTrace();
        }

        assertEquals(1190000,bankAPI.getAccount(accountId).get().getSaldo());
        assertEquals(10000,bankAPI.getAccount(accountId2).get().getSaldo());
    }
}
