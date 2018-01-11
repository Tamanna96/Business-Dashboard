public class Finance extends Department
{
    private double budget;
    private double expenses;
    private double profit;
    private double loss;
    public Finance()
    {
    
    }
    
    public Finance(double b)
    {
        budget = b;
    }
    
    public String printStatus()
    {
        return "Finance: Looks at budget, expenses, revenue, profit and loss.";
    }
    
    public double getexpenses(double es, double bill, double d)
    {
        double employeeSalary = es;
        double bills = bill;
        double debts = d;
        
        expenses = employeeSalary + bills + debts; 
        return expenses;
    }
     
    public double getnewBudget()
    {
        budget = budget - expenses;
        return budget;
    }
    
    public double profit(double c)
    {
        double costsOfSales = c;
        double grossProfit = getRevenue() - costsOfSales;
        double netProfit = grossProfit - expenses;
        profit = netProfit;
        return profit;
    }
    
    public String loss()
    {
        if(profit < 0)
        {
            loss = profit;
            return "Loss: " + loss;
        }
        else
        {
            loss = 0;
            return "Loss: " + loss;
        }
    }
}
