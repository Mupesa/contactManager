import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactManager {
    // List to store multiple contacts
    private List<Contact> contacts = new ArrayList<>();

    // Method to collect and store contact information
    public void contactStore(Scanner scanner) {
        System.out.print("Enter the contact name: ");
        String name = scanner.nextLine();

        System.out.print("Enter the contact email: ");
        String email = scanner.nextLine();

        System.out.print("Enter the contact phone: ");
        String phone = scanner.nextLine();  // Changed from int to String

        // Create a Contact object
        Contact contact = new Contact(name, email, phone);

        // Add the contact to the list
        contacts.add(contact);

        System.out.println("Contact stored successfully!\n");
    }

    // Method to display all contacts
    public void displayAllContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
        } else {
            System.out.println("\nAll Contacts:");
            for (Contact contact : contacts) {
                contact.displayContact();
                System.out.println("-------------------");
            }
        }
    }

    // Method to search for a contact by name
    // public void searchContact(String name) {
    //     boolean found = false;
    //     for (Contact contact : contacts) {
    //         if (contact.getName().equalsIgnoreCase(name)) {
    //             System.out.println("\nContact Found:");
    //             contact.displayContact();
    //             found = true;
    //             break;
    //         }
    //     }
    //     if (!found) {
    //         System.out.println("\nContact not found.");
    //     }
    // }

    

    // Method to delete a contact by name
    public void deleteContact(String name) {
        Contact toRemove = null;
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                toRemove = contact;
                break;
            }
        }
        if (toRemove != null) {
            contacts.remove(toRemove);
            System.out.println("\nContact deleted successfully.");
        } else {
            System.out.println("\nContact not found.");
        }
    }
}
