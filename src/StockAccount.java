
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class CompanyShares
{
    private String name;
    private int numberOfShares;
    private double sharePrice;
    private String dateTime;

    CompanyShares(String name, int numberOfShares, double sharePrice, String dateTime)
    {
        this.name = name;
        this.numberOfShares = numberOfShares;
        this.sharePrice = sharePrice;
        this.dateTime = dateTime;
    }

    public String getName()
    {
        return name;
    }

    public int getNumberOfShares()
    {
        return numberOfShares;
    }

    public double getSharePrice()
    {
        return sharePrice;
    }

    public String getDateTime()
    {
        return dateTime;
    }

    public void setNumberOfShares(int numberOfShares)
    {
        this.numberOfShares = numberOfShares;
    }
}

public class StockAccount
{
    private List<CompanyShares> shareList;

    public StockAccount()
    {
        shareList = new ArrayList<>();
    }

    public double valueOf()
    {
        double totalValue = 0.0;
        for (CompanyShares shares : shareList)
        {
            totalValue += shares.getNumberOfShares() * shares.getSharePrice();
        }
        return totalValue;
    }

    public void buy(int amount, String name, double sharePrice, String dateTime)
    {
        boolean shareFound = false;
        for (CompanyShares shares : shareList)
        {
            if (shares.getName().equals(name))
            {
                shares.setNumberOfShares(shares.getNumberOfShares() + amount);
                shareFound = true;
                break;
            }
        }
        if (!shareFound)
        {
            CompanyShares newShares = new CompanyShares(name, amount, sharePrice, dateTime);
            shareList.add(newShares);
        }
    }

    public void sell(int amount, String symbol, String dateTime)
    {
        for (CompanyShares shares : shareList)
        {
            if (shares.getName().equals(symbol))
            {
                if (shares.getNumberOfShares() >= amount)
                {
                    shares.setNumberOfShares(shares.getNumberOfShares() - amount);
                }
                else
                {
                    System.out.println("Not enough shares to sell!");
                }
                break;
            }
        }
    }

    public void printReport()
    {
        for (CompanyShares shares : shareList)
        {
            System.out.println("Symbol: " + shares.getName() + ", Number of Shares: " + shares.getNumberOfShares() +
                    ", Share Price: $" + shares.getSharePrice() + ", Date Time: " + shares.getDateTime());
        }
    }

    public static void main(String[] args)
    {
        StockAccount stockAccount = new StockAccount();

        stockAccount.buy(100, "MRF", 140.0, "2024-03-15 10:30:00");
        stockAccount.buy(50, "IRCTS", 500.0, "2024-03-15 11:00:00");
        stockAccount.buy(75, "GOOGLE", 2160.0, "2024-03-15 11:30:00");
        stockAccount.printReport();
        System.out.println("Total value of stocks: Rs." + stockAccount.valueOf()+"\n");

        stockAccount.sell(30, "MRF", "2024-03-16 12:00:00");
        stockAccount.printReport();
        System.out.println("Total value of stocks: Rs. " + stockAccount.valueOf()+"\n");
    }
}
