package main;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.BusinessExceptions;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		try {
			System.out.println("Enter account data");
			System.out.print("Number: ");
			int number = sc.nextInt();
			System.out.print("Holder: ");
			sc.nextLine();
			String holder = sc.nextLine();
			System.out.print("Initial balance: ");
			Double initialBalance = sc.nextDouble();
			System.out.print("Withdraw limit: ");
			Double withdrawLimit = sc.nextDouble();
			
			Account account = new Account(number, holder, initialBalance, withdrawLimit);
			
			System.out.println("");
			System.out.print("Enter amount for withdraw: ");
			Double amount = sc.nextDouble();
			
			try {	
				account.withdraw(amount);
				System.out.println(account);
			}
			catch(BusinessExceptions e) {
				System.out.println("Withdraw error: " + e.getMessage());
			}
		}
		catch(InputMismatchException e) {
			System.out.println("Invalid format");
		}
		
		
		sc.close();
	}

}
