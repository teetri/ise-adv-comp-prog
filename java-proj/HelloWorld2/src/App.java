public class App {
    public static void main(String[] args) throws Exception {
        Account a = new Account(1, "John Doe", 1000.00);
        System.out.println(a);
        a.deposit(500.00);
        System.out.println(a);
        a.withdraw(2000.00);
        System.out.println(a);
    }

}
