package sample;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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

    public static String encodePassword(String salt, String password) { //taken from github repo of loose
        MessageDigest md = getMessageDigest();
        md.update(salt.getBytes(StandardCharsets.UTF_8));

        byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));

        return new String(hashedPassword, StandardCharsets.UTF_8)
                .replace("\"", "");
    }

    public static MessageDigest getMessageDigest() {    //taken from github repo of loose
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-512");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("SHA-512 does not exist!");
        }
        return md;
    }
}
