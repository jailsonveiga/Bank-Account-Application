package com.jay.bank_account_application.model;

import javax.persistence.*;

@Entity
@Table(name = "UserAccount")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private int age;
    private int accountNumber;
    private double balance;
    private double deposit;
    private double withdraw;

    // get the max balance of the user
    public double getMaxBalance() {
        return balance;
    }

    public Account() {
    }

    public Account(String name, int age, int accountNumber, double balance, int id, double deposit, double withdraw) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.deposit = deposit;
        this.withdraw = withdraw;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getWithdraw() {
        return withdraw;
    }

    public void setWithdraw(double withdraw) {
        this.withdraw = withdraw;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
