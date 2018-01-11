public class Sales extends Department
{
    private int itemsSold;
    private double growth;
    public Sales()
    {
    
    }
    
    public Sales(int item)
    {
        itemsSold = item;
    }
    
    public String printStatus()
    {
        return "Sales: Looks at sales growth, sales targets and product performance.";
    }
    
    public float productPerformance(int sl)
    {
        int stockLeft = sl;
        float performance = (itemsSold/stockLeft) * 100;
        return performance;
    }
    
    public double salesGrowth(double pR)
    {
        double currentRevenue = getRevenue();
        double previousRevenue = pR;
        growth = (currentRevenue/previousRevenue)*100;
        return growth;
    }
}
