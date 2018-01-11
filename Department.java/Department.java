import java.awt.*;
import java.awt.event.*;
class Department
{
    static double sales;
    static double price;
    static double revenue;
    public Department()
    {
       
    }
    
    public Department(double s, double p)
    {
       sales = s;
       price = p;
    }
    
    public String printStatus()
    {
        return "The dashboard is used to review the progress of the business.";
    }
    
    public double getSales()
    {
        return sales;
    }
    
    public double getPrice()
    {
        return price;
    }
    
    public static double getRevenue()
    {
        revenue = (sales * price);
        return revenue;
    }
}
