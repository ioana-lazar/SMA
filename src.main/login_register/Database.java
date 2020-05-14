package login_register;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.commons.io.FileUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;


public class Database {
    private static List<User> UserList;

    private static final Path USERS_PATH = FileSystemService.getPathToFile("config", "resources/users.json");

    public static void loadUsersFromFile() throws IOException           //should work as an initializer
    {

        System.out.println(USERS_PATH);
        if (!Files.exists(USERS_PATH)) {

            FileUtils.copyURLToFile(((Database.class.getClassLoader()).getResource("resources/users.json")), USERS_PATH.toFile());
        }

        ObjectMapper objectMapper = new ObjectMapper();

        UserList = objectMapper.readValue(USERS_PATH.toFile(), new TypeReference<List<User>>() {
        });
    }

    public void addUser(User user)           //add to json file, not to arraylist of users
    {

        UserList.add(user);
        persistUsers();
    }

    private void persistUsers()
    {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(USERS_PATH.toFile(), UserList);
        } catch (IOException e) {
            System.out.println("Dumnezeu");
        }
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
