package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Services{
    Scanner scanner = new Scanner(System.in);

    public void getAccountInfo(BankAccount accountName) {
        System.out.println("Account Holder's Name: " + accountName.getCustomerName() +"\nAccount Number: "
                + accountName.getAccountNumber() + "\nAccount Balance: " + accountName.getBalance()+"\nE-mail: "
        + accountName.getEmail()+"\nPhone Number: "+accountName.getPhoneNumber()+"\nRecent Transactions: ");
        accountName.displayTransactions(accountName);
    }

    public void deposit (BankAccount accountName) {
        double depositAmount = 0;
        System.out.print("Enter the deposit amount: ");
        while(true) {

            try {

                depositAmount = scanner.nextDouble();

            }catch(InputMismatchException e){
                System.out.print("Invalid Input. ");
                scanner.nextLine();

                continue;
            }

            break;
        }

        double currentBalance = accountName.getBalance();

        accountName.setBalance(currentBalance + depositAmount);
        accountName.logTransaction("Deposit", depositAmount);

}

    public void withdraw(BankAccount accountName) {
        double withdrawAmount = 0;
        System.out.print("Enter the withdrawal amount: ");

        while(true) {

            try {

                withdrawAmount = scanner.nextDouble();

            }catch(InputMismatchException e){

                System.out.print("Invalid Input. ");
            }

            break;
        }

        double currentBalance = accountName.getBalance();
        if(accountName.getBalance() >= withdrawAmount) {
            accountName.setBalance(currentBalance - withdrawAmount);
            accountName.logTransaction("Withdrawal", withdrawAmount);
        } else {

            System.out.println("Sorry, " + accountName.getCustomerName() +"." + "You have insufficient funds for your " +
                    "withdrawal request. Your current available balance is " + accountName.getBalance() +".");
        }

    }

    public void changeNumber (BankAccount accountName, long newNumber) {

        System.out.println("Please type in your new number (no dashes, spaces, or non-numeric characters, starting " +
                "with 1 and " +
                "area code): ");
        if(newNumber > 999999999L) {

            accountName.setPhoneNumber(newNumber);

        } else {

            System.out.println("What is this? A European phone number?");
        }
    }

    public void changeEmail (BankAccount accountName, String newEmail) {

        System.out.println("Please enter your new email address: ");
        accountName.setEmail(newEmail);

    }

    public void serviceSelector(String service, BankAccount accountName) {

        switch (service) {

            case "deposit" -> deposit(accountName);
            case "withdraw" -> withdraw(accountName);
            case "account information" -> getAccountInfo(accountName);

        }

    }

}

