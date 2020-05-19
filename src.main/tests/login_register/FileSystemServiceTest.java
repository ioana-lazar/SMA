package login_register;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileSystemServiceTest {

    @Test
    void getPathToFile() {
        assertEquals("C:\\Users\\andre\\.registration-example\\.\\config\\resources\\ListOfServices.json", String.valueOf(FileSystemService.getPathToFile("config", "resources/ListOfServices.json")));
    }
}