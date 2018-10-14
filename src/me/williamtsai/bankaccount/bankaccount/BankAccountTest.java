package me.williamtsai.bankaccount.bankaccount;

public class BankAccountTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankAccount checking = new BankAccount();
		BankAccount saving = new BankAccount();
		checking.deposit(100.00, "Checking");
		System.out.println(BankAccount.getTotalAmount());
		saving.deposit(200.00, "Saving");
		System.out.println(BankAccount.getTotalAmount());
		checking.withdraw(101.00, "Checking");
		checking.withdraw(40.50, "Checking");
		saving.withdraw(100.50, "Saving");
		System.out.println("Checking balance: " + checking.getCheckingBalance());
		System.out.println("Saving balance: " + saving.getSavingsBalance());
		
	}

}
