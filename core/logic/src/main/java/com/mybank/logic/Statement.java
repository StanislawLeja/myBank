package com.mybank.logic;

import com.mybank.logic.Parameters.StatementType;

import java.time.LocalDateTime;

/**
 * Created by Stanisław Leja on 07.01.18.
 */
public class Statement {
    private LocalDateTime dateOfOpertion;
    private long amountOfOperation;
    private long balance;
    private StatementType statementType;

    public Statement(LocalDateTime dateOfOpertion, long amountOfOperation, long balance, StatementType statementType) {
        this.dateOfOpertion = dateOfOpertion;
        this.amountOfOperation = amountOfOperation;
        this.balance = balance;
        this.statementType = statementType;
    }

    public LocalDateTime getDateOfOpertion() {
        return dateOfOpertion;
    }

    public long getAmountOfOperation() {
        return amountOfOperation;
    }

    public long getBalance() {
        return balance;
    }

    public StatementType getStatementType() {
        return statementType;
    }

    @Override
    public String toString() {
        return "Statement{" +
                "dateOfOpertion=" + dateOfOpertion +
                ", amountOfOperation=" + amountOfOperation +
                ", balance=" + balance +
                '}';
    }
}
