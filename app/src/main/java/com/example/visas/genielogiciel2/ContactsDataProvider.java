package com.example.visas.genielogiciel2;

/**
 * Created by visas on 5/16/18.
 */

public class ContactsDataProvider {

    private String contactName;
    private int contactNumber;

    public ContactsDataProvider(String contactName, int contactNumber) {
        this.contactName = contactName;
        this.contactNumber = contactNumber;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public int getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(int contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String contactNumberToString(){
        return contactNumber+"";
    }
}
