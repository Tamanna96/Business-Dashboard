import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.awt.Dialog;
import java.io.*;
class Previous extends JFrame
{
    JTextArea rep;
    public Previous()
    {
        JFrame previous = new JFrame("Previous Report");
        previous.setLayout(new FlowLayout());
        previous.setSize(600, 500);
        previous.setVisible(true);
                        
        JLabel preLabel = new JLabel("Report ");
        rep = new JTextArea(15, 30);
        rep.setEditable(false);
        previous.add(preLabel);
        previous.add(rep);
    }

    public void report()
    {
         try
         {        
              BufferedReader inputStream = new BufferedReader(new FileReader("report.txt"));
              rep.read(inputStream, null);
              inputStream.close();
         }
         catch(IOException p)
         {
              JFrame pR = new JFrame();
              JOptionPane.showMessageDialog(pR, "File does not exist","ERROR", JOptionPane.ERROR_MESSAGE);
         }
    }
}
