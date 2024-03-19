import java.util.Scanner;
class Account {
    int balance;
    Account(int initialBalance)
    {
        if (initialBalance >= 0)
            balance = initialBalance;
    }

    public void credit(int amount)
    {
        balance = balance +  amount;
    }

    public void debit(int amount)
    {
        if (amount > balance)
        {
            System.out.println("Debit amount exceeded account balance.");
        }
        else
        {
            balance = balance - amount;
            System.out.println("Successfully debited "+amount+" from account...\n Updated balance: "+ balance);
        }
    }

    public int getBalance()
    {
        return balance;
    }
}

public class AccountTest
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter initial balance for account: ");
        int initialBalance = sc.nextInt();

        Account account = new Account(initialBalance);

        System.out.println("Initial balance: "+ account.getBalance());

        System.out.print("Enter amount to credit: ");
        int creditAmount = sc.nextInt();
        account.credit(creditAmount);
        System.out.println("Balance after crediting: "+ account.getBalance());

        System.out.print("Enter amount to debit: ");
        int debitAmount = sc.nextInt();
        account.debit(debitAmount);
        System.out.println("Final balance after debiting: "+ account.getBalance());

        sc.close();
    }
}
