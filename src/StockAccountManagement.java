import java.util.ArrayList;
import java.util.Scanner;

class Stock
{
    String name;
    int numberOfShares;
    double sharePrice;

    public Stock(String name, int numberOfShares, double sharePrice)
    {
        this.name = name;
        this.numberOfShares = numberOfShares;
        this.sharePrice = sharePrice;
    }

    public double getValue()
    {
        return numberOfShares * sharePrice;
    }
}

class StockPortfolio
{
    ArrayList<Stock> stocks = new ArrayList<>();


    public void addStock(Stock stock)
    {
        stocks.add(stock);
    }

    public double getTotalValue()
    {
        double totalValue = 0;
        for (Stock stock : stocks) {
            totalValue = totalValue + stock.getValue();
        }
        return totalValue;
    }

    public void printStockReport()
    {
        System.out.println("Stock Report:");
        System.out.println("------------------------------");
        for (Stock stock : stocks)
        {
            System.out.println("Stock Name: " + stock.name);
            System.out.println("Number of Shares: " + stock.numberOfShares);
            System.out.println("Share Price: Rs. " + stock.sharePrice);
            System.out.println("Total Value: Rs. " + stock.getValue());
            System.out.println();
        }
        System.out.println("------------------------------");
        System.out.println("Total Portfolio Value: Rs. " + getTotalValue());
    }
}

public class StockAccountManagement
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        StockPortfolio portfolio = new StockPortfolio();

        System.out.print("Enter the number of stocks: ");
        int numberOfStocks = sc.nextInt();
        sc.nextLine(); // Consume newline

        for (int i = 0; i < numberOfStocks; i++)
        {
            System.out.println("Enter details for Stock " + (i + 1) + ":");
            System.out.print("Enter Stock Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Number of Shares: ");
            int numberOfShares = sc.nextInt();
            System.out.print("Enter Share Price: ");
            double sharePrice = sc.nextDouble();
            sc   .nextLine();

            Stock stock = new Stock(name, numberOfShares, sharePrice);
            portfolio.addStock(stock);
        }

        portfolio.printStockReport();
    }
}
