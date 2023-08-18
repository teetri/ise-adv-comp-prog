public class Account {
  private int accountID;
  private String accountName;
  private double balance;

  public Account(int accountID, String accountName, double balance) {
    this.accountID = accountID;
    this.accountName = accountName;
    this.balance = balance;
  }

  public String toString() {
    return String.format("Account ID: %d\nAccount Name: %s\nBalance: %.2f", accountID, accountName, balance);
  }

  public void deposit(double amount) {
    if (amount > 0) {
      this.balance += amount;
    } else {
      System.out.println("Invalid amount");
    }
  }

  public void withdraw(double amount) {
    if (amount > 0) {
      if (amount <= this.balance) {
        this.balance -= amount;
      } else {
        System.out.println("Insufficient balance");
      }
    } else {
      System.out.println("Invalid amount");
    }
  }
}
