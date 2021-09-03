package com.company;

import java.util.Locale;

public class Main {


    public static void main(String[] args) {
        Services services = new Services();

        BankTeller bankTeller = new BankTeller();

        BankAccount myBankAccount = new BankAccount();

            myBankAccount.setPhoneNumber(5456628745L);
            myBankAccount.setAccountNumber(560002192);
            myBankAccount.setEmail("MyNaMe@email.com");
            myBankAccount.setCustomerName("My Name");
            myBankAccount.setBalance(100.00);

        do {

            services.serviceSelector(bankTeller.greeting().toLowerCase(), myBankAccount);

        } while (bankTeller.anythingElseICanHelpYouWith());
    }
}
