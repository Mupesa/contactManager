import java.util.ArrayList;
import java.util.List;


public class Contact {
    // Fields to store contact information
    private String name;
    private String email;
    private String phone; // Changed from int to String

    // Constructor to initialize the contact
    public Contact(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    // Method to display contact details
    public void displayContact() {
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
    }

    // Override toString for better output representation
    @Override
    public String toString() {
        return "Name: " + name + ", Email: " + email + ", Phone: " + phone;
    }
}
