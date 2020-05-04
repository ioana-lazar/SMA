package sample;

import javafx.scene.control.TextField;

public class Controller {
    public TextField namefield, passwordfield;
    Database database = new Database();
    PopUp popUp;

    public void loginClicked(){
        User user = new User(namefield.getText(), passwordfield.getText());
        if(!database.contains(user))
        {
            popUp.display("Login failed", "User or password incorrect");
            namefield.clear();
            passwordfield.clear();
        }
        else
        {
            System.out.println("Logged in!");                              //intra in aplicatie acum
            //se inchide fereastra de log in
        }
    }

    public void registerClicked()
    {
        User user = new User(namefield.getText(),  database.encodePassword(namefield.getText(), passwordfield.getText()));

        if(database.containsUsername(user.getName()))
        {
            popUp.display("Registration failed", "Username already exists");
            namefield.clear();
            passwordfield.clear();
        }
        else
        {
            if(user.checkUsername(user.getName()) && user.checkPassword(user.getPassword()))
            {
                database.addUser(user);
                popUp.display("Registration succeeded", "User " + user.getName() + " is now registered!");
                System.out.println(database);
            }
            else
            {
                popUp.display("Warning", "Username must be between 5 - 15 characters(only letters and numbers allowed).\nPassword must be between 7 - 12 characters");

            }

        }

    }
}


