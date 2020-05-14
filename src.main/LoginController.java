import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    public TextField namefield, passwordfield;
    Database database = new Database();
    private PopUp popUp;
    public Button loginbutton;

    public void loginClicked() throws IOException {
        User user = new User(namefield.getText(), database.encodePassword(namefield.getText(), passwordfield.getText()));

        if(!database.contains(user))
        {
            popUp.display("Login failed", "User or password incorrect");
            namefield.clear();
            passwordfield.clear();
        }
        else
        {
            //enter app
            VBox layout= FXMLLoader.load(getClass().getResource("appwindow.fxml"));
            Stage oldstage = (Stage) loginbutton.getScene().getWindow();
            oldstage.close();

            Stage newstage = new Stage();
            newstage.setScene(new Scene(layout, 600, 370));
            newstage.setTitle("Service Manager");
            newstage.show();
        }
    }

    public void registerClicked() {
        User user = new User(namefield.getText(),  database.encodePassword(namefield.getText(), passwordfield.getText()));

        if(database.containsUsername(user.getName()))
        {
            popUp.display("Registration failed", "Username already exists");
            namefield.clear();
            passwordfield.clear();
        }
        else
        {
            if(user.checkUsername(user.getName()) && user.checkPassword(passwordfield.getText()))
            {
                database.addUser(user);
                popUp.display("Registration succeeded", "User " + user.getName() + " is now registered!");
            }
            else
            {
                popUp.display("Warning", "Username must be between 5 - 15 characters(only letters and numbers allowed).\nPassword must be between 7 - 12 characters");

            }

        }

    }
}


