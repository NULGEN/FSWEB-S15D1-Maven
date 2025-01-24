package org.example.mobile;

import java.util.ArrayList;
import java.util.List;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
    }

    public MobilePhone(String myNumber, List<Contact> myContacts) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>(myContacts);
    }

    public String getMyNumber() {
        return myNumber;
    }

    public ArrayList<Contact> getMyContacts() {
        return myContacts;
    }

    public boolean addNewContact(Contact contact) {
        if (contact ==null || contact.getName() ==null || contact.getPhoneNumber() == null) {
            return false;
        }
        if(findContact(contact.getName())>=0){
            return  false;
        }
        myContacts.add(contact);
        return true;
    }

    // Update contact
    public boolean updateContact(Contact oldContact, Contact newContact) {
        int index = findContact(oldContact);
        if (index == -1) {
            return false; // Old contact does not exist
        }
        myContacts.set(index, newContact);
        return true;
    }

    // Remove contact
    public boolean removeContact(Contact contact) {
        int index = findContact(contact);
        if (index == -1 || contact == null) {
            return false; // Contact does not exist
        }
        //myContacts.remove(index);
       // return true;
        return  this.myContacts.remove(contact);
    }

    public Contact queryContact(String name) {
        int index = findContact(name);
        if (index != -1) {
            return myContacts.get(index);
        }
        return null;
    }

    // Print all contacts
    public void printContacts() {
        System.out.println("Contact List:");
        for (Contact contact : myContacts) {
            System.out.println(contact.getName() + " -> " + contact.getPhoneNumber());
        }
    }

        // Find contact by Contact object
        public int findContact(Contact contact){
            return myContacts.indexOf(contact);
        }

        // Find contact by name
        public int findContact(String name){
            for (int i = 0; i < myContacts.size(); i++) {
                if (myContacts.get(i).getName().equals(name)) {
                    return i;
                }
            }
            return -1;
        }

    }

