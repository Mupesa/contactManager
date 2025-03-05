import java.util.*;
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class contactGUI extends JFrame{
    // private JFrame frame;
    private JTextField newContactField;
    private JButton savedContactField;
    private JButton expandField;
    private JLabel label;


    //creating the constructor for the contactGUI class

    public contactGUI()
    {
        //creating the JFrame components
        JFrame frame=new JFrame("Contacts Page");
        frame.setSize(400,300);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);  // centers frame at the center of the window


        // creating components fot the panel
        JPanel panel=new JPanel();
        panel.setName("Add Contact");
        //creating the layout for the panel
        panel.setLayout(new GridLayout(4, 2, 5, 5));

        //creating the components
        //create the label to to enter the name
        label=new JLabel("Name of Contact");
        newContactField= new JTextField();
        panel.add(newContactField);

        //creating the saved button
        savedContactField=new JButton("Saved Contacts");
        panel.add(savedContactField);
        
        //creating the expand button


    }
}
