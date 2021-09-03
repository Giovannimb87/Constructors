package com.company;
import org.w3c.dom.ls.LSOutput;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BankTeller {

    boolean isFirst = true;

    Scanner scanner = new Scanner(System.in);
    String name = "Dave";
    String[] validServices = {"deposit", "withdraw", "change email", "change phone number", "account information"};

    public String greeting() {

        if(isFirst) {
            System.out.print("Hello, my name is " + this.name + ". How can I help you today?\n1) Deposit\n2) Withdraw" +
                    "\n3) Change Email\n4) Change Phone Number\n5) Account Information\nService Required: ");
        } else{
            System.out.println("1) Deposit\n2) Withdraw\n3) Change Email\n4) Change Phone Number\n5) Account Information\nService Required: ");
        }
        isFirst = false;
        return serviceRequired();
    }

    public boolean anythingElseICanHelpYouWith(){
        String response;
        System.out.print("Anything else I can do for you today? ");
        response = scanner.nextLine();
        return (!response.equalsIgnoreCase("yes"));

    }

    private String serviceRequired() {
        String serviceRequested = "";

        while (true) {

            boolean isService = false;

            while (!isService) {

                serviceRequested = scanner.nextLine();
                isService = isServiceValid((serviceRequested));

                if (!isService) {

                    System.out.print("Invalid service request. Please try again: ");

                }

            }

            break;
        }

        return serviceRequested;
    }



    private boolean isServiceValid(String userRequest) {

        return Arrays.asList(validServices).contains(userRequest.toLowerCase());

    }
}
