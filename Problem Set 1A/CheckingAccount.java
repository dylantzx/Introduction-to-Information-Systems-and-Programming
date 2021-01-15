package com.example.problemset1a;

public class CheckingAccount extends Account {

    public static void main(String[] args) {

        CheckingAccount myCheckAcc = new CheckingAccount(1024, 8000.0);
        myCheckAcc.deposit(2000);
        myCheckAcc.withdraw(15000);

        System.out.println(myCheckAcc.getBalance());
        myCheckAcc.withdraw(200);
        System.out.println(myCheckAcc.getBalance());
        myCheckAcc.deposit(7000);
        myCheckAcc.withdraw(200);
        System.out.println(myCheckAcc.getBalance());
    }

    private double overdraft_limit = -5000;

    public CheckingAccount() { super(); }

    public CheckingAccount(int id, double balance) { super(id, balance); }

    @Override
    public void withdraw(double withdrawn_amount) {
        if (this.getBalance() - withdrawn_amount >= overdraft_limit){ super.withdraw(withdrawn_amount); }
        else System.out.println("over limit");
    }

}
