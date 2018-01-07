package com.mybank.logic;

/**
 * Created by Stanisław Leja on 07.01.18.
 */
public class AccountOwnerData{
    private String name;
    private String surname;

    public AccountOwnerData(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "AccountOwnerData{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
