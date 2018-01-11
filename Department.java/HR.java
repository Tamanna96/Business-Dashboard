import java.io.*;
public class HR extends Department
{
    private int employees;
    private double revPE;
    public HR()
    {
    
    }
    
    public HR(int e)
    {
        employees = e;
    }
    
    public String printStatus()
    {
        return "Human Resources (HR): Deals with the process of hiring, firing, positioning and overseeing employees.";
    }
    
    public int numOfEmployees(String HorF)
    {
        if(HorF.equals("Hired"))
        {
            employees = employees + 1 ;
        }
        else if(HorF.equals("Fired"))
        {
            employees = employees - 1;
        }
        return employees;
    }
    
    public void getnumOfEmployees()
    {
        System.out.println("Number of employees: " + employees);
    }
    
    public double revenuePerE()
    {
        revPE = getRevenue()/employees;
        return revPE; 
    }
}
