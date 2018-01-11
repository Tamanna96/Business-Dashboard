import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.awt.Dialog;
import java.io.*;
class Business extends JFrame implements ActionListener 
{
    JTextField sales;
    JTextField price;
    JTextField amountSold;
    JTextField budget;
    JTextField bills;
    JTextField debts;
    JTextField costOfSales;
    JTextField employees;
    JTextField salary;
    JTextField stockLeft;
    
    JTextArea report;
    public Business()
    {
        JFrame f = new JFrame("Business Dashboard");
        GridLayout layout = new GridLayout(1,2);
        f.setSize(700, 450);//frame size
        f.setLayout(layout);//layout manager
        f.setVisible(true);//frame will be visible
        
        JPanel input = new JPanel(new GridLayout(10, 2, 0, 5));
        JPanel output = new JPanel(new FlowLayout());
        input.setVisible(true);
        output.setVisible(true);
        
        JLabel sLabel = new JLabel("  Sales:");
        JLabel pLabel = new JLabel("  Price:");
        JLabel asLabel = new JLabel("  Amount Sold:");
        JLabel bLabel = new JLabel("  Budget:");
        JLabel bilLabel = new JLabel("  Bills:");
        JLabel debtLabel = new JLabel("  Debts:");
        JLabel cosLabel = new JLabel("  Cost of sales:");
        JLabel empLabel = new JLabel("  Employees:");
        JLabel salaryLabel = new JLabel("  Salary:");
        JLabel stlLabel = new JLabel("  Stock Left:");
        JLabel repLabel = new JLabel("  Report");

        sales = new JTextField(6);
        price = new JTextField(6);
        amountSold = new JTextField(6);
        budget = new JTextField(6);
        bills = new JTextField(6); 
        debts = new JTextField(6);
        costOfSales = new JTextField(6);
        employees = new JTextField(6);
        salary = new JTextField(6);
        stockLeft = new JTextField(6);
        
        input.add(sLabel);
        input.add(sales);
        
        input.add(pLabel);
        input.add(price);
        
        input.add(asLabel);
        input.add(amountSold);
        
        input.add(bLabel);
        input.add(budget);
        
        input.add(bilLabel);
        input.add(bills);
        
        input.add(debtLabel);
        input.add(debts);
        
        input.add(cosLabel);
        input.add(costOfSales);
        
        input.add(empLabel);
        input.add(employees);
        
        input.add(salaryLabel);
        input.add(salary);
        
        input.add(stlLabel);
        input.add(stockLeft);

        report = new JTextArea(20,30);
        output.add(repLabel);
        output.add(report);
        
        f.add(input);
        f.add(output);
        
        JButton r = new JButton("View report");
        r.addActionListener(this);     
        output.add(r);
        
        JButton pr = new JButton("Previous report");
        pr.addActionListener(this);
        output.add(pr);
    }

    public void actionPerformed(ActionEvent event)
    {  
        String command = event.getActionCommand();  
        try
        {
            if(command.equals("View report"))  
            { 
                String salesString = sales.getText();
                double s = Double.parseDouble(salesString);
                
                String priceString = price.getText();
                double p = Double.parseDouble(priceString);
                
                String soldString = amountSold.getText();
                int amountSold = Integer.parseInt(soldString);
                
                String budgetString = budget.getText();
                double budg = Double.parseDouble(budgetString);
                
                String billsString = bills.getText();
                double bill = Double.parseDouble(billsString);
                
                String debtsString = debts.getText();
                double debt = Double.parseDouble(debtsString);
                
                String CoSString = costOfSales.getText();
                double CoS = Double.parseDouble(CoSString);
                
                String employeeString = employees.getText();
                int e = Integer.parseInt(employeeString);
                
                String salaryString = salary.getText();
                double salary = Double.parseDouble(salaryString);
                
                String stockLeftString = stockLeft.getText();
                int stock = Integer.parseInt(stockLeftString);
                
                Department d1 = new Department(s, p);
                Sales s1 = new Sales(amountSold);
                Finance f1 = new Finance(budg);
                HR hr1 = new HR(e);
           
                ArrayList<Double> pRevenue = new ArrayList<Double>();
                pRevenue.add(0.0);
                pRevenue.add(0, d1.getRevenue());
                
                double pR = pRevenue.get(0);
                
                report.setText(d1.printStatus() + " \n" + s1.printStatus() + " \n" + f1.printStatus() + " \n" + hr1.printStatus() + " \nRevenue: " + d1.getRevenue() + " \nExpenses: " + 
                               f1.getexpenses(salary, bill, debt) + " \nProfit: " + f1.profit(CoS) + " \nBudget: " + f1.getnewBudget() + "\nProduct performance: " + s1.productPerformance(stock) + "%" + 
                               " \nSales growth: " + s1.salesGrowth(pR) + "%" + " \nRevenue per employee: " + hr1.revenuePerE() + " \n" + f1.loss());
                
                try
                {            
                    File fout = new File("report.txt");
                	FileOutputStream outputStream = new FileOutputStream(fout);
                 
                	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
                	report.write(bw);             
                	bw.close();
                }
                catch(IOException f)
                {
                    JFrame eF = new JFrame();
                    JOptionPane.showMessageDialog(eF, "Exception caught","ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
            else if(command.equals("Previous report"))
            {
                Previous p = new Previous();
                p.report();
            }
        }
        catch(NumberFormatException e)
        {
            JFrame eFrame = new JFrame();
            JOptionPane.showMessageDialog(eFrame, "WARNING! TEXTFIELDS ARE EMPTY OR NUMBERS HAVE NOT BEEN ENTERED.","WARNING", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public static void main(String[] param)
    {
        Business b1 = new Business();
      
        b1.addWindowListener(new WindowAdapter() 
        {
            public void windowClosing(WindowEvent ev) {
                System.exit(0);
            }
        });

    }
}
