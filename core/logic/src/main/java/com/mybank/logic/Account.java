package com.mybank.logic;

import java.time.LocalDateTime;

/**
 * Created by Stanisław Leja on 07.01.18.
 */
public class Account {
    private long accountID;
    private AccountOwnerData accountOwnerData;
    private long saldo;
    private StatementHistory statementHistory;

    public Account(long accountID, AccountOwnerData accountOwnerData) {
        this.accountID = accountID;
        this.accountOwnerData = accountOwnerData;
        this.saldo = 0;
        this.statementHistory = new StatementHistory();
    }

    public String getName() {
        return accountOwnerData.getName();
    }

    public String getSurname() {
        return accountOwnerData.getSurname();
    }

    public long getSaldo() {
        return saldo;
    }

    public long getAccountID() {
        return accountID;
    }

    public void setSaldo(long saldo) {// to make tests simle
        this.saldo = saldo;
    }

    public StatementHistory getStatementHistory() {
        return statementHistory;
    }

    public void subtractMoney(long amount) throws TransferException{
        if(amount > 0){
            if(saldo - amount >= 0){
                this.saldo -=  amount;
                statementHistory.addStatement(new Statement(LocalDateTime.now(),amount,saldo, Parameters.StatementType.WITHDRAWAL));
            }else throw new TransferException("Insufficient amount of money to process this operation");
        }else throw new TransferException("Amonut of money to subtract have to be bigger than zero");
    }

    public void addMoney(long amount) throws TransferException{
        if(amount > 0){
            this.saldo += amount;
            statementHistory.addStatement(new Statement(LocalDateTime.now(),amount,saldo, Parameters.StatementType.DEPOSIT));
        }else throw new TransferException("Amount of money to add have to be bigger than zero");
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountID=" + accountID +
                ", accountOwnerData=" + accountOwnerData +
                ", saldo=" + saldo +
                '}';
    }
}
