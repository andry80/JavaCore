package com.javacore.lesson09;

public class UserRegistration {

    public static void inputUserData(User user) {
        Input input = new Input();

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
                        user.setUserPhoneNumber(input.inputParameter("phone number"));
                        System.out.println("successful");
                        num = 3;
                    }
                    case 3 ->  {
                        user.setUserPassword(input.inputParameter("password"));
                        System.out.println("successful");
                        if (user.getUserPassword().equals(input.inputParameter("confirm password"))) {
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
    }

    public static void main(String[] args) {
        User user = new User();

        inputUserData(user);

        System.out.println(user);
    }
}
