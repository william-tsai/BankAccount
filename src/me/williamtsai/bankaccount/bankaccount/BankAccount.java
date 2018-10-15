package me.williamtsai.bankaccount.bankaccount;

import java.util.concurrent.ThreadLocalRandom;

public class BankAccount {
	private static int numberOfAccounts = 0;
	private static double totalAmount;
	
	private String accountNumber;
	private double checkingBalance;
	private double savingsBalance;
	
	public BankAccount() {
		this.accountNumber = Long.toString(this.generateTenDigits());
		BankAccount.numberOfAccounts += 1;
		System.out.println("New account number: " + this.accountNumber);
	}
	
	
	private long generateTenDigits() {
		ThreadLocalRandom random = ThreadLocalRandom.current();
		return random.nextLong(1_000_000_000L, 10_000_000_000L);
	}
	
	public double getCheckingBalance() {
		return checkingBalance;
	}
	public void setCheckingBalance(double checkingBalance) {
		this.checkingBalance = checkingBalance;
	}
	public double getSavingsBalance() {
		return savingsBalance;
	}
	public void setSavingsBalance(double savingsBalance) {
		this.savingsBalance = savingsBalance;
	}
	
	public void deposit(double amount, String accountType) {
		BankAccount.totalAmount += amount;
		if (accountType == "Checking") {
			this.checkingBalance += amount;
		} 
		if (accountType == "Saving") {
			this.savingsBalance += amount;
		}
	}
	
	public void withdraw(double amount, String accountType) {
		if (accountType == "Checking") {
			if (amount > this.checkingBalance) {
				System.out.println("Insufficient funds");
			} else {
				this.checkingBalance -= amount;
				BankAccount.totalAmount -= amount;
			}
		} 
		if (accountType == "Saving") {
			if (amount > this.savingsBalance) {
				System.out.println("Insufficient funds");
			} else {
				this.savingsBalance -= amount;
				BankAccount.totalAmount -= amount;
			}
		}
	}


	public static double getTotalAmount() {
		return totalAmount;
	}


	public static void setTotalAmount(double totalAmount) {
		BankAccount.totalAmount = totalAmount;
	}


	public String getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public int getNumberOfAccounts() {
		return numberOfAccounts;
	}
	
}
