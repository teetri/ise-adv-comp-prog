import java.util.Arrays;

public class SimpleTransactionManager implements TransactionManager {
  private String[] wallets;
  private String[] transactions;
  private int walletCount;
  private int transactionCount;

  public SimpleTransactionManager(String[] wallets) {
    this.wallets = new String[1000];
    this.transactions = new String[10000];
    this.walletCount = 0;
    this.transactionCount = 0;

    for (String wallet : wallets) {
      this.wallets[walletCount] = wallet;
      this.walletCount++;
    }
  }

  public boolean transferFunds(String senderWalletId, String receiverWalletId, double amount) throws Exception {
    if (!isValidWallet(senderWalletId)) {
      throw new IllegalArgumentException("Sender wallet does not exist.");
    }

    if (getBalance(senderWalletId) < amount && senderWalletId != "Wallet0") {
      throw new InvalidTransactionException("Not enough balance in the source wallet.");
    }

    if (!isValidWallet(receiverWalletId)) {
      this.wallets[walletCount] = receiverWalletId;
      this.walletCount++;
    }

    transactions[transactionCount] = String.format("%s|%s|%f", senderWalletId, receiverWalletId, amount);
    this.transactionCount++;
    return true;

  }

  public double getBalance(String walletId) throws Exception {
    if (!isValidWallet(walletId)) {
      throw new IllegalArgumentException("Invalid wallet ID.");
    }

    double balance = 0.0;
    for (int i = 0; i < transactionCount; i++) {
      String[] t = transactions[i].split("\\|");
      if (t[0].equals(walletId)) {
        balance -= Double.parseDouble(t[2]);
      }
      if (t[1].equals(walletId)) {
        balance += Double.parseDouble(t[2]);
      }
    }

    return balance;
  }

  public boolean isValidWallet(String walletId) {
    return Arrays.asList(this.wallets).contains(walletId);
  }

}
