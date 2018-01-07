package com.mybank.logic;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Stanisław Leja on 07.01.18.
 */
public class StatementHistory {
    private List<Statement> history;

    public StatementHistory() {
        this.history = new LinkedList<Statement>();
    }

    public void addStatement(Statement statement){
        this.history.add(statement);
    }

    public String printAll(){
        StringBuilder sB = new StringBuilder("");
        for(Statement item : history){
            sB.append(item.getDateOfOpertion()+" "+item.getStatementType()+" "+item.getAmountOfOperation()+" "+item.getBalance());
            sB.append(";");
        }
        return sB.toString();
    }

    public String printDeposits(){
        return "";
    }

    public String printWithdrawals(){
        return "";
    }

    public String printBetweenDates(){
        return "";
    }
}

