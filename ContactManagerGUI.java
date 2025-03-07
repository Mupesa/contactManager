import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ContactManagerGUI extends JFrame {
    private ContactManager contactManager;
    private JTextField nameField, emailField, phoneField;
    private JTextArea displayArea;
    private JButton addButton, displayButton, deleteButton;

    public ContactManagerGUI() {
        contactManager = new ContactManager();
        
        // Set up the frame
        setTitle("Contact Manager");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Input Panel
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Add Contact"));

        inputPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Email:"));
        emailField = new JTextField();
        inputPanel.add(emailField);

        inputPanel.add(new JLabel("Phone:"));
        phoneField = new JTextField();
        inputPanel.add(phoneField);

        // Buttons Panel
        JPanel buttonPanel = new JPanel(new FlowLayout());
        addButton = new JButton("Add Contact");
        displayButton = new JButton("Display Contacts");
        deleteButton = new JButton("Delete Contact");

        buttonPanel.add(addButton);
        buttonPanel.add(displayButton);
        buttonPanel.add(deleteButton);

        // Display Area
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        // Add components to frame
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Add Action Listeners
        addButton.addActionListener(e -> addContact());
        displayButton.addActionListener(e -> displayContacts());
        deleteButton.addActionListener(e -> deleteContact());
    }

    private void addContact() {
        String name = nameField.getText().trim();
        String email = emailField.getText().trim();
        String phone = phoneField.getText().trim();

        if (!name.isEmpty() && !email.isEmpty() && !phone.isEmpty()) {
            contactManager.addContact(name, email, phone);
            clearFields();
            displayContacts();
        } else {
            JOptionPane.showMessageDialog(this, "Please fill in all fields");
        }
    }

    private void displayContacts() {
        displayArea.setText("");
        List<Contact> contacts = contactManager.getContacts();
        if (contacts.isEmpty()) {
            displayArea.append("No contacts found.");
        } else {
            for (Contact contact : contacts) {
                displayArea.append(contact.toString() + "\n");
            }
        }
    }

    private void deleteContact() {
        String name = JOptionPane.showInputDialog(this, "Enter name of contact to delete:");
        if (name != null && !name.trim().isEmpty()) {
            contactManager.deleteContact(name.trim());
            displayContacts();
        }
    }

    private void clearFields() {
        nameField.setText("");
        emailField.setText("");
        phoneField.setText("");
    }

    // Main method to run the application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ContactManagerGUI().setVisible(true);
        });
    }
}