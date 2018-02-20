package com.colombomobilemeetup.demo2;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    public static ArrayList<User> users = new ArrayList<>();

    static {
        users.add(new User("Sanath", "Nandasiri"));
        users.add(new User("Jagath", "Prasanna"));
        users.add(new User("Saman", "Kumara"));
        users.add(new User("Kanchana", "Mendis"));
        users.add(new User("Amila", "Suranga"));
    }

    public static List<User> getUsers() {
        return users;
    }
}
