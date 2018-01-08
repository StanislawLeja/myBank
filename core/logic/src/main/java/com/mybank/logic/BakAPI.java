package com.mybank.logic;

/**
 * Created by Stanisław Leja on 08.01.18.
 */
public class BakAPI {
    AccountManager accountManager;
    TransferPool transferPool;
    TransferPool transferPool1;

    public BakAPI() {
        AccountManager accountManager = new AccountManager();
        TransferPool transferPool = new TransferPool();
        TransferPool transferPool1 = new TransferPool();
    }

    public void transferMoney(long accountIdDst, long accountIdSrc, long transferAmount){

        Transfer transfer = new Transfer(accountIdDst,accountIdSrc,transferAmount);
        try {
            transferPool.performTransfer(transfer,accountManager);
        } catch (TransferException e) {
            e.printStackTrace();
        }
    }

    public void createBankAccount(String name, String surname, long amount){
        long accountId = accountManager.createAccount(name,surname);
        accountManager.getAccount(accountId).get().setSaldo(amount);
    }

}
