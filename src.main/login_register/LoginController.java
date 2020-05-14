package login_register;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    public TextField namefield, passwordfield;
    @FXML
    ChoiceBox<String> rolefield;


    Database database = new Database();
    private PopUp popUp;
    public Button loginbutton;

    public void initialize()
    {
        rolefield.getItems().addAll("User", "Staff");
        rolefield.setValue("User");
    }

    public void loginClicked() throws IOException {
        User user = new User(namefield.getText(), database.encodePassword(namefield.getText(), passwordfield.getText()), rolefield.getValue());

        if(!database.contains(user))
        {
            popUp.display("Login failed", "User or password incorrect");
            namefield.clear();
            passwordfield.clear();
        }
        else
        {
            //enter app
            VBox layout= FXMLLoader.load(getClass().getResource("../appwindow.fxml")); // incarca un vertical box, codul il ia din fisierul ala .fxml
            Stage oldstage = (Stage) loginbutton.getScene().getWindow();    // inchidem login window
            oldstage.close();

            Stage newstage = new Stage();
            newstage.setScene(new Scene(layout, 600, 370));     // nou window pentru aplicatie
            newstage.setTitle("Service Manager");
            newstage.show();
        }
    }

    public void registerClicked() {
        User user = new User(namefield.getText(), database.encodePassword(namefield.getText(), passwordfield.getText()), rolefield.getValue());

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


