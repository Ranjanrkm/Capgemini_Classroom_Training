package com.tns.banking.app;

import com.tns.banking.entities.Account;
import com.tns.banking.entities.Beneficiary;
import com.tns.banking.entities.Customer;
import com.tns.banking.entities.Transaction;
import com.tns.banking.services.BankingService;
import com.tns.banking.services.BankingServiceImpl;

import java.util.Scanner;

public class BankingSystemApp {
    public static void main(String[] args) {
        BankingService service = new BankingServiceImpl();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nBanking System");
            System.out.println("1. Add Customers");
            System.out.println("2. Add Accounts");
            System.out.println("3. Add Beneficiary");
            System.out.println("4. Add Transaction");
            System.out.println("5. Find Customer by Id");
            System.out.println("6. List all Accounts of specific Customer");
            System.out.println("7. List all transactions of specific Account");
            System.out.println("8. List all beneficiaries of specific customer");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;
            int choice = Integer.parseInt(line);

            switch (choice) {
                case 1 -> {
                    System.out.println("Enter Customer Details");
                    System.out.print("Customer Id: "); int id = Integer.parseInt(sc.nextLine());
                    System.out.print("Name: "); String name = sc.nextLine();
                    System.out.print("Address: "); String addr = sc.nextLine();
                    System.out.print("Contact No.: "); String contact = sc.nextLine();
                    service.addCustomer(new Customer(id, name, addr, contact));
                }
                case 2 -> {
                    System.out.println("Enter Account Details");
                    System.out.print("Account Id: "); int aid = Integer.parseInt(sc.nextLine());
                    System.out.print("Customer Id: "); int cid = Integer.parseInt(sc.nextLine());
                    System.out.print("Account Type Saving/Current: "); String type = sc.nextLine();
                    System.out.print("Balance: "); double bal = Double.parseDouble(sc.nextLine());
                    service.addAccount(new Account(aid, cid, type, bal));
                }
                case 3 -> {
                    System.out.println("Enter Beneficiary Details");
                    System.out.print("Customer Id: "); int cid = Integer.parseInt(sc.nextLine());
                    System.out.print("Benefiary Id: "); int bid = Integer.parseInt(sc.nextLine());
                    System.out.print("Beneficiary Name: "); String bname = sc.nextLine();
                    System.out.print("Beneficiary Account No.: "); String bacc = sc.nextLine();
                    System.out.print("Beneficiary Bank details: "); String bank = sc.nextLine();
                    service.addBeneficiary(new Beneficiary(bid, cid, bname, bacc, bank));
                }
                case 4 -> {
                    System.out.println("Enter Transaction Details");
                    System.out.print("Account Id: "); int aid = Integer.parseInt(sc.nextLine());
                    System.out.print("Type (Deposit/Withdrawal): "); String type = sc.nextLine();
                    System.out.print("Account Amount: "); double amt = Double.parseDouble(sc.nextLine());
                    service.addTransaction(new Transaction(aid, type, amt));
                }
                case 5 -> {
                    System.out.print("Customer Id: "); int cid = Integer.parseInt(sc.nextLine());
                    Customer c = service.findCustomerById(cid);
                    if (c != null) System.out.println("Customer Id: " + c.getCustomerID() + "\nCustomer: " + c.getName());
                    else System.out.println("Not found.");
                }
                case 6 -> {
                    System.out.print("Customer Id : "); int cid = Integer.parseInt(sc.nextLine());
                    System.out.println("Accounts for Customer ID :" + cid);
                    for (Account a : service.getAccountsByCustomerId(cid)) {
                        System.out.println("Account ID: " + a.getAccountID() + ", Balance: " + a.getBalance());
                    }
                }
                case 7 -> {
                    System.out.print("Account Id: "); int aid = Integer.parseInt(sc.nextLine());
                    System.out.println("Transactions for Account ID :" + aid);
                    for (Transaction t : service.getTransactionsByAccountId(aid)) {
                        System.out.println(t);
                    }
                }
                case 8 -> {
                    System.out.print("Customer Id: "); int cid = Integer.parseInt(sc.nextLine());
                    System.out.println("Beneficiaries for Customer ID :" + cid);
                    for (Beneficiary b : service.getBeneficiariesByCustomerId(cid)) {
                        System.out.println("Beneficiary ID: " + b.getBeneficiaryID() + ", Name: " + b.getName());
                    }
                }
                case 9 -> {
                    System.out.println("Thank you!");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }
}