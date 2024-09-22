package com.javacore.lesson09;

public class User {

    private String userName;
    private String userEmail;
    private String userPhoneNumber;
    private String userPassword;

    public User() {}

    private boolean isValid(String parameter, String regex) throws InvalidInputException {
        if (parameter.matches(regex)) {
            return true;
        }
        throw new InvalidInputException(parameter + " is not in " + regex);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) throws InvalidInputException {
        if (this.isValid(userName, "[a-zA-Zа-яА-Я]{3,256}")) {
            this.userName = userName;
        }
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) throws InvalidInputException {
        if (this.isValid(userEmail, ".+@.+\\..+")) {
            this.userEmail = userEmail;
        }
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) throws InvalidInputException {
        if (this.isValid(userPhoneNumber, "(-|\\+)?\\d{7,}")) {
            this.userPhoneNumber = userPhoneNumber;
        }
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) throws InvalidInputException {
        if (this.isValid(userPassword, "(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#$%^&*])[A-Za-z\\d!@#$%^&*]{8,}")) {
            this.userPassword = userPassword;
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPhoneNumber='" + userPhoneNumber + '\'' +
                ", userPassword='" + userPassword + '\'' +
                '}';
    }
}
