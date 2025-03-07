import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactManager {
    private List<Contact> contacts = new ArrayList<>();

    // Store a new contact
    public void addContact(String name, String email, String phone) {
        Contact contact = new Contact(name, email, phone);
        contacts.add(contact);
        System.out.println("Contact stored successfully!");
    }

    // Display all contacts
    public void displayAllContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
            return;
        }
        
        System.out.println("\nAll Contacts:");
        for (Contact contact : contacts) {
            contact.displayContact();
            System.out.println("-------------------");
        }
    }

    // Search for a contact by name
    public Contact searchContact(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                return contact;
            }
        }
        return null;
    }

    // Delete a contact by name
    public boolean deleteContact(String name) {
        Contact contactToRemove = searchContact(name);
        if (contactToRemove != null) {
            contacts.remove(contactToRemove);
            System.out.println("Contact deleted successfully.");
            return true;
        }
        System.out.println("Contact not found.");
        return false;
    }

    // Get contacts list for GUI or other purposes
    public List<Contact> getContacts() {
        return new ArrayList<>(contacts);
    }

    // Method to collect contact information via console
    public void addContactConsole(Scanner scanner) {
        System.out.print("Enter contact name: ");
        String name = scanner.nextLine();

        System.out.print("Enter contact email: ");
        String email = scanner.nextLine();

        System.out.print("Enter contact phone: ");
        String phone = scanner.nextLine();

        addContact(name, email, phone);
    }
}