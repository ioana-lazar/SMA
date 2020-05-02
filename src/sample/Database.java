package sample;

import java.util.ArrayList;

public class Database {
    private ArrayList<User> UserList = new ArrayList<>();

    public void addUser(User user)
    {
        UserList.add(user);
    }

    public void storeToFile() // String filename
    {
        System.out.println("De facut");
    }

    public boolean contains(User user)
    {
        return UserList.contains(user);
    }
    public boolean containsUsername(String username)
    {
        for(User i: UserList)
        {
            if(i.getName().equals(username))
                return true;
        }
        return false;
    }

    public String toString()
    {
        StringBuilder buffer = new StringBuilder();
        for(User i: UserList)
        {
            buffer.append(i);
        }
        return buffer.toString();
    }
}
