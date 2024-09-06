package com.javacore.lesson09;

public class User {

    String userName;
    String userEmail;
    String userPhoneNumber;
    String userPassword;

    private User() {

    }

    public String getUserName() {
        return userName;
    }

    private boolean verificator(String parameter, String regex) throws InvalidInputException {
        if (parameter.matches(regex)) {
            return true;
        }
        throw new InvalidInputException(parameter + " is not in " + regex);
    }

    public void setUserName(String userName) throws InvalidInputException {
        if (this.verificator(userName, "[a-zA-Zа-яА-Я]{3,256}")) {
            this.userName = userName;
        }
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) throws InvalidInputException {
        if (this.verificator(userEmail, ".+@.+\\..+")) {
            this.userEmail = userEmail;
        }
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) throws InvalidInputException {
        if (this.verificator(userPhoneNumber, "(-|\\+)?\\d{7,}")) {
            this.userPhoneNumber = userPhoneNumber;
        }
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) throws InvalidInputException {
        if (this.verificator(userPassword, "(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#$%^&*])[A-Za-z\\d!@#$%^&*]{8,}")) {
            this.userPassword = userPassword;
        }
    }

    public static User createUser() {
        Input input = new Input();

        User user = new User();

        int num = 0;
        String buffer;

        while (true) {
            try {
                switch (num) {
                    case 0 -> {
                        buffer = input.inputParameter("name");
                        user.setUserName(buffer);
                        System.out.println("successful");
                        num = 1;
                    }
                    case 1 ->  {
                        user.setUserEmail(input.inputParameter("email"));
                        System.out.println("successful");
                        num = 2;
                    }
                    case 2 ->  {
                        user.setUserPhoneNumber(input.inputParameter("phone numer"));
                        System.out.println("successful");
                        num = 3;
                    }
                    case 3 ->  {
                        user.setUserPassword(input.inputParameter("password"));
                        System.out.println("successful");
                        if (user.userPassword.equals(input.inputParameter("confirm password"))) {
                            System.out.println("successful");
                            num = 4;
                        }else {
                            System.out.println("password is not correct");
                            continue;
                        }
                    }
                }
                if (num == 4) {
                    break;
                }
            } catch (InvalidInputException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return user;
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
