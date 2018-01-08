package com.mybank.logic;

import java.util.Optional;

/**
 * Created by Stanisław Leja on 08.01.18.
 */
public class BakAPI implements BankAPIInterface{
    private AccountManager accountManager;
    private TransferPool transferPool;

    public BakAPI() {
        this.accountManager = new AccountManager();
        this.transferPool = new TransferPool();
    }

    public void transferMoney(long accountIdDst, long accountIdSrc, long transferAmount) throws TransferException {
        Transfer transfer = new Transfer(accountIdDst,accountIdSrc,transferAmount);
        transferPool.performTransfer(transfer,accountManager);
    }

    public long createBankAccount(String name, String surname, long amount){
        long accountId = this.accountManager.createAccount(name,surname);
        this.accountManager.getAccount(accountId).get().setSaldo(amount);
        return accountId;
    }

    public Optional<Account> getAccount(long accountId){
        return accountManager.getAccount(accountId);
    }

}
