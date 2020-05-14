import java.nio.file.Path;
import java.nio.file.Paths;

public class FileSystemService {        //taken from the example provided
    private static final String APPLICATION_FOLDER = ".registration-example";
    private static final String USER_FOLDER = System.getProperty("user.home");
    private static final Path APPLICATION_HOME_PATH = Paths.get(USER_FOLDER, APPLICATION_FOLDER); //will create a path in the user folder like "home/registration"

    public  static Path getPathToFile(String... path)
    {
        return APPLICATION_HOME_PATH.resolve(Paths.get(".", path)); //if it's a directory, it will join the path with that directory
    }
}
