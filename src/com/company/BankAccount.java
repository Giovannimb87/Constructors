package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class BankAccount {
    int transactionCount = 0;
    private int accountNumber;
    private double balance;
    private String customerName;
    private String email;
    private long phoneNumber;
    private final ArrayList<HashMap<String, Double>> transactions = new ArrayList<>();

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    // Getters

    public double getBalance() {
        return balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getEmail() {
        return email;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    // Logging and Displaying Transactions

    public void logTransaction(String type, double amount) {
        transactions.add(transactionCount, new HashMap<>());
        transactions.get(transactionCount).put(type, amount);
        transactionCount++;
    }

    public void displayTransactions(BankAccount accountName){
        for(HashMap val: transactions) {
            val.forEach((key, value) -> System.out.println(key + ":" + value));
        }
    }
}
