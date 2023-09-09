public interface TransactionManager {
  boolean transferFunds(String senderWalletId, String receiverWalletId, double amount) throws Exception;

  double getBalance(String walletId) throws Exception;

  boolean isValidWallet(String walletId);

}
