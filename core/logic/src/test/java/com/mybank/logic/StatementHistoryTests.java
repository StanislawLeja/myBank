package com.mybank.logic;

import org.junit.Test;

import java.time.LocalDateTime;
import static com.mybank.logic.Parameters.StatementType;
import static org.junit.Assert.assertEquals;

/**
 * Created by Stanisław Leja on 07.01.18.
 */
public class StatementHistoryTests {

    @Test
    public void set_of_status(){
        Statement statement = new Statement(LocalDateTime.now(),1,2, StatementType.DEPOSIT);
    }

    @Test
    public void printAllTest(){
        StatementHistory statementHistory = new StatementHistory();
        statementHistory.addStatement(new Statement(LocalDateTime.of(2018,1,7,18,15,34),7900,27900, StatementType.DEPOSIT));
        statementHistory.addStatement(new Statement(LocalDateTime.of(2018,1,7,18,15,59),900,27000, StatementType.WITHDRAWAL));
        assertEquals("2018-01-07T18:15:34 DEPOSIT 7900 27900;2018-01-07T18:15:59 WITHDRAWAL 900 27000;",statementHistory.printAll());
    }

    @Test
    public void printDepositsTest(){

    }

    @Test
    public void printWithdrawalsTest(){

    }

    @Test
    public void printBetweenDatesTest(){

    }

}
