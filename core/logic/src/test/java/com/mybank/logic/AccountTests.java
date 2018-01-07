package com.mybank.logic;

/**
 * Created by Stanisław Leja on 07.01.18.
 */

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;


/**
 * Created by Stanisław Leja on 07.01.18.
 */
public class AccountTests {


    @Test
    public void creation() {
        Account testAccount = new Account(1, new AccountOwnerData("Jan", "Kowalski"));
        assertEquals("Jan", testAccount.getName());
        assertEquals("Kowalski", testAccount.getSurname());
        assertEquals(0, testAccount.getSaldo());
    }

    @Test
    public void saldoOperations() {
        Account testAccount = new Account(1, new AccountOwnerData("Jan", "Kowalski"));
        try {
            testAccount.addMoney(20);
            assertEquals(20, testAccount.getSaldo());
            testAccount.subtractMoney(15);
            assertEquals(5, testAccount.getSaldo());
        } catch (TransferException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testExceptionMessage_add() {
        Account testAccount = new Account(1, new AccountOwnerData("Jan", "Kowalski"));
        try {
            testAccount.addMoney(-1);
            fail("Expected an TransferException to be thrown");
        } catch (TransferException e) {
            e.printStackTrace();
            assertThat(e.getMessage(), is("Amount of money to add have to be bigger than zero"));
        }
    }

    @Test
    public void testExceptionMessage_sub1() {
        Account testAccount = new Account(1, new AccountOwnerData("Jan", "Kowalski"));
        try {
            testAccount.subtractMoney(-1);
            fail("Expected an TransferException to be thrown");
        } catch (TransferException e) {
            e.printStackTrace();
            assertThat(e.getMessage(), is("Amonut of money to subtract have to be bigger than zero"));
        }
    }

    @Test
    public void testExceptionMessage_sub2() {
        Account testAccount = new Account(1, new AccountOwnerData("Jan", "Kowalski"));
        try {
            testAccount.addMoney(5);
            testAccount.subtractMoney(8);
            fail("Expected an TransferException to be thrown");
        } catch (TransferException e) {
            e.printStackTrace();
            assertThat(e.getMessage(), is("Insufficient amount of money to process this operation"));
        }
    }
}

