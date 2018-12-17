package ru.stqa.pft.addressbook.model;

import java.io.File;
import java.util.Objects;

public class ContactData {
    private int id = Integer.MAX_VALUE;
    private String firstname;
    private String lastname;
    private String middlename;
    private String nickname;
    private String title;
    private String company;
    private String address;
    private String contactHomePhone;
    private String contactMobilePhone;
    private String contactWorkPhone;
    private String allPhones;
    private String email;
    private String email2;
    private String email3;
    private String allEmails;
    private String group;

    public File getPhoto() {
        return photo;
    }


    public ContactData withPhoto(File photo) {
        this.photo = photo;
        return this;
    }

    private File photo;

    public String getAllPhones() {
        return allPhones;
    }

    public ContactData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstname;
    }

    public String getLastName() {
        return lastname;
    }

    public String getMiddleName() {
        return middlename;
    }

    public String getNickName() {
        return nickname;
    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public String getAddress() {
        return address;
    }

    public String getHomePhone() {
        return contactHomePhone;
    }

    public String getMobilePhone() {
        return contactMobilePhone;
    }

    public String getWorkPhone() {
        return contactWorkPhone;
    }

    public String getEmail() {
        return email;
    }

    public String getEmail2() { return email2; }

    public String getEmail3() {
        return email3;
    }

    public String getAllEmails() { return allEmails; }

    public String getGroup() {
        return group;
    }


    public ContactData withId(int id) {
        this.id = id;
        return this;
    }

    public ContactData withFirstName(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public ContactData withLastName(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public ContactData withMiddleName(String middlename) {
        this.middlename = middlename;
        return this;
    }

    public ContactData withNickName(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public ContactData withTitle(String title) {
        this.title = title;
        return this;
    }

    public ContactData withCompany(String company) {
        this.company = company;
        return this;
    }

    public ContactData withAddress(String address) {
        this.address = address;
        return this;
    }

    public ContactData withHomePhone(String contactHomePhone) {
        this.contactHomePhone = contactHomePhone;
        return this;
    }

    public ContactData withMobilePhone(String contactMobilePhone) {
        this.contactMobilePhone = contactMobilePhone;
        return this;
    }

    public ContactData withWorkPhone(String contactWorkPhone) {
        this.contactWorkPhone = contactWorkPhone;
        return this;
    }

    public ContactData withEmail(String email) {
        this.email = email;
        return this;
    }

    public ContactData withEmail2(String contactEmail2) {
        this.email2 = contactEmail2;
        return this;
    }

    public ContactData withEmail3(String contactEmail3) {
        this.email3 = contactEmail3;
        return this;
    }

    public ContactData withGroup(String group) {
        this.group = group;
        return this;
    }

    public ContactData withAllEmails(String allEmails) {
        this.allEmails = allEmails;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return Objects.equals(firstname, that.firstname) &&
                Objects.equals(lastname, that.lastname) &&
                Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, firstname, lastname);
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "firstname='" + firstname + '\'' +
                ", firstname='" + firstname + '\'' +
                '}';
    }
}
