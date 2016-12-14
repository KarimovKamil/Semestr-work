package ru.itis.inform.models;

import java.sql.Date;

public class Customer {
    private int customerId;
    private String passport;
    private String lastName;
    private String firstName;
    private String middleName;
    private String phoneNumber;
    private Date dateOfBirth;

    public Customer() {
    }

    public Customer(Builder builder) {
        this.customerId = builder.customerId;
        this.passport = builder.passport;
        this.lastName = builder.lastName;
        this.firstName = builder.firstName;
        this.middleName = builder.middleName;
        this.phoneNumber = builder.phoneNumber;
        this.dateOfBirth = builder.dateOfBirth;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getPassport() {
        return passport;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public static class Builder {
        private int customerId;
        private String passport;
        private String lastName;
        private String firstName;
        private String middleName;
        private String phoneNumber;
        private Date dateOfBirth;

        public Builder customerId(int value) {
            customerId = value;
            return this;
        }

        public Builder passport(String arg) {
            passport = arg;
            return this;
        }

        public Builder lastName(String arg) {
            lastName = arg;
            return this;
        }

        public Builder firstName(String arg) {
            firstName = arg;
            return this;
        }

        public Builder middleName(String arg) {
            middleName = arg;
            return this;
        }

        public Builder phoneNumber(String arg) {
            phoneNumber = arg;
            return this;
        }

        public Builder dateOfBirth(Date arg) {
            dateOfBirth = arg;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }
}
