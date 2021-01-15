package com.example.problemset1a;

// ATTENTION
// just edit this file
// TestAccount.java contains the test cases provided in the problem set
// Put in any import statements that you need

import java.util.Date;

public class Account{
    /*
    public static void main (String[] args) {
        Account account = new Account(1122, 20000);
        System.out.println(account.getID());
        System.out.println(account.getBalance());
        System.out.println(account.getAnnualInterestRate());
        System.out.println(account.getDate());

        Account.setAnnualInterestRate(4.5);

        System.out.println(account.getAnnualInterestRate());

        account.withdraw(2500);

        System.out.println(account.getBalance());

        account.deposit(3000);

        System.out.println(account.getBalance());

        System.out.println("Balance is " + account.getBalance());

        System.out.println("Monthly interest is " + account.getMonthlyInterest());
    }
    */

    //complete the requirements of this question here
    private int id;
    private double balance;
    private static double annualInterestRate;
    private Date dateCreated = new Date();

    public Account(){
        id = 0;
        balance = 0;
        annualInterestRate = 0;
    }

    public Account(int id, double balance){
        setID(id);
        setBalance(balance);
        dateCreated.toString();
    }

    public int getID(){
        return this.id;
    }

    public double getBalance(){
        return this.balance;
    }

    public static double getAnnualInterestRate(){
        return Account.annualInterestRate;
    }

    public Date getDate(){
        return dateCreated;
    }
    public void setID(int id){
        this.id = id;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }

    public static void setAnnualInterestRate(double rate){
       Account.annualInterestRate = rate;
    }

    public static double getMonthlyInterestRate(){
        return Account.annualInterestRate/12;
    }

    public double getMonthlyInterest(){
        return getMonthlyInterestRate() * this.balance /100;
    }

    public void withdraw(double withdrawn_amount){
        double w_balance = this.balance - withdrawn_amount;
        this.setBalance(w_balance);
    }

    public void deposit(double deposited_amount){
        double d_balance = this.balance + deposited_amount;
        this.setBalance(d_balance);
    }



}

// **HINT**
// The problem set says "assume all accounts have the same interest rate".
// What does that tell you about the variable(s) and/or method(s) relating to the interest rate?