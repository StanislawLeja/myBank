package com.mybank.logic;

/**
 * Created by Stanisław Leja on 07.01.18.
 */
public abstract class TransactionExecutor {
    public static void performTransfer(Transfer transfer,AccountManager accountManager) throws TransferException {
        if(accountManager.getAccount(transfer.getAccountIdSrc()).get().getSaldo() > transfer.getTransferAmount()){
            accountManager.getAccount(transfer.getAccountIdSrc()).get().subtractMoney(transfer.getTransferAmount());
            accountManager.getAccount(transfer.getAccountIdDst()).get().addMoney(transfer.getTransferAmount());
        }else throw new TransferException("No enough money on src account");
    }
}
