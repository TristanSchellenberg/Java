import java.util.ArrayList;
import java.util.Scanner;

public class ContactManager {
    static ArrayList<ContactInfo> contactList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int userSelection;
        do {
            System.out.println("WELCOME TO TRISTAN'S ADDRESS BOOK");
            System.out.println("1. Add New Contact");
            System.out.println("2. Display All Contacts");
            System.out.println("3. Search for a Contact");
            System.out.println("4. Remove a Contact");
            System.out.println("5. Exit Application");
            System.out.print("Choose an option: ");
            userSelection = scanner.nextInt();

            switch (userSelection) {
                case 1:
                    createNewContact();
                    break;
                case 2:
                    displayAllContacts();
                    break;
                case 3:
                    searchForContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    System.out.println("Exiting the Address Book...");
                    break;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        } while (userSelection != 5);
    }

    public static void createNewContact() {
        System.out.print("Enter contact's name: ");
        String contactName = scanner.next();
        System.out.print("Enter contact's address: ");
        String contactAddress = scanner.next();
        System.out.print("Enter contact's phone number: ");
        String contactPhone = scanner.next();
        System.out.print("Enter contact's email: ");
        String contactEmail = scanner.next();
        
        ContactInfo newContact = new ContactInfo(contactName, contactAddress, contactPhone, contactEmail);
        contactList.add(newContact);
        System.out.println("New contact has been added!");
    }

    public static void displayAllContacts() {
        if (contactList.isEmpty()) {
            System.out.println("No contacts available.");
        } else {
            for (int i = 0; i < contactList.size(); i++) {
                System.out.println("Contact " + (i + 1) + ":");
                System.out.println(contactList.get(i));
            }
        }
    }

    public static void searchForContact() {
        System.out.print("Enter the name of the contact to search for: ");
        String searchName = scanner.next();
        boolean isFound = false;
        for (ContactInfo contact : contactList) {
            if (contact.getContactName().equalsIgnoreCase(searchName)) {
                System.out.println("Contact details:");
                System.out.println(contact);
                isFound = true;
                break;
            }
        }
        if (!isFound) {
            System.out.println("No contact found with the name: " + searchName);
        }
    }

    public static void removeContact() {
        System.out.print("Enter the name of the contact to remove: ");
        String removeName = scanner.next();
        boolean isRemoved = false;
        for (ContactInfo contact : contactList) {
            if (contact.getContactName().equalsIgnoreCase(removeName)) {
                contactList.remove(contact);
                System.out.println("Contact removed successfully.");
                isRemoved = true;
                break;
            }
        }
        if (!isRemoved) {
            System.out.println("No contact found with the name: " + removeName);
        }
    }
}

class ContactInfo {
    private String contactName;
    private String contactAddress;
    private String contactPhone;
    private String contactEmail;

    public ContactInfo(String contactName, String contactAddress, String contactPhone, String contactEmail) {
        this.contactName = contactName;
        this.contactAddress = contactAddress;
        this.contactPhone = contactPhone;
        this.contactEmail = contactEmail;
    }

    public String getContactName() {
        return contactName;
    }

    public String getContactAddress() {
        return contactAddress;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    @Override
    public String toString() {
        return "Name: " + contactName + "\nAddress: " + contactAddress
                + "\nPhone: " + contactPhone + "\nEmail: " + contactEmail;
    }
}
