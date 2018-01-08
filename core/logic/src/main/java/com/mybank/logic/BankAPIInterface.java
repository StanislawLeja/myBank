package com.mybank.logic;

/**
 * Created by Stanisław Leja on 08.01.18.
 */
public interface BankAPIInterface {
    public void transferMoney(long accountIdDst, long accountIdSrc, long transferAmount) throws TransferException ;

    public long createBankAccount(String name, String surname, long amount);

}
