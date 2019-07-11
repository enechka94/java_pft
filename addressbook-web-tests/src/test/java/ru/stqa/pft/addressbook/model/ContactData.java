package ru.stqa.pft.addressbook.model;

public class ContactData {
    private final String firstname;
    private final String middlename;
    private final String lastname;
    private final String nickname;
    private final String company;
    private final String address;
    private final String homeNumber;
    private final String mobileNumber;
    private final String workNumber;
    private final String email1;
    private final String email2;
    private final String email3;
    private final String bday;
    private final String bmonth;
    private final String byear;
    private String group;

    public ContactData(String firstname, String middlename, String lastname, String nickname, String company, String address, String homeNumber, String mobileNumber, String workNumber, String email1, String email2, String email3, String bday, String bmonth, String byear, String group) {
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.nickname = nickname;
        this.company = company;
        this.address = address;
        this.homeNumber = homeNumber;
        this.mobileNumber = mobileNumber;
        this.workNumber = workNumber;
        this.email1 = email1;
        this.email2 = email2;
        this.email3 = email3;
        this.bday = bday;
        this.bmonth = bmonth;
        this.byear = byear;
        this.group = group;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public String getNickname() {
        return nickname;
    }

    public String getCompany() {
        return company;
    }

    public String getAddress() {
        return address;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getWorkNumber() {
        return workNumber;
    }

    public String getEmail1() {
        return email1;
    }

    public String getEmail2() {
        return email2;
    }

    public String getEmail3() {
        return email3;
    }

    public String getBday() {
        return bday;
    }

    public String getBmonth() {
        return bmonth;
    }

    public String getByear() {
        return byear;
    }

    public String getGroup() {
        return group;
    }
}
