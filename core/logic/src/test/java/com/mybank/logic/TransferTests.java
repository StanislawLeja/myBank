package com.mybank.logic;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Stanisław Leja on 07.01.18.
 */
public class TransferTests {
    @Test
    public void transferMoneyTest(){
        AccountManager accountManager = new AccountManager();
        TransferPool transferPool = new TransferPool();

        long accountId = accountManager.createAccount("Adam","Małysz");
        assertEquals(accountId,accountManager.getAccount(accountId).get().getAccountID());
        accountManager.getAccount(accountId).get().setSaldo(1000000);
        long accountId2 = accountManager.createAccount("Kamil","Stoch");
        assertEquals(accountId,accountManager.getAccount(accountId).get().getAccountID());
        accountManager.getAccount(accountId2).get().setSaldo(200000);

        try {
            TransactionExecutor.performTransfer(new Transfer(accountId,accountId2,50000),accountManager);
            TransactionExecutor.performTransfer(new Transfer(accountId,accountId2,50000),accountManager);
            TransactionExecutor.performTransfer(new Transfer(accountId,accountId2,50000),accountManager);
            TransactionExecutor.performTransfer(new Transfer(accountId,accountId2,40000),accountManager);
        } catch (TransferException e) {
            e.printStackTrace();
        }

        assertEquals(1190000,accountManager.getAccount(accountId).get().getSaldo());
        assertEquals(10000,accountManager.getAccount(accountId2).get().getSaldo());

        /*for(String item: accountManager.getAccount(accountId).get().getStatementHistory().printAll().split(";"))
            System.out.println(item);

        for(String item: accountManager.getAccount(accountId2).get().getStatementHistory().printAll().split(";"))
            System.out.println(item);
*/
    }
}
