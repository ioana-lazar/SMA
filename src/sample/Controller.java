package sample;

import javafx.scene.control.TextField;

public class Controller {
    public TextField namefield, passwordfield;
    Database database = new Database();

    public void loginClicked(){
        User user = new User(namefield.getText(), passwordfield.getText());
        if(!database.contains(user))
        {
            System.out.println("User or password incorrect");                           //pop up cu mesaj
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
        User user = new User(namefield.getText(), passwordfield.getText());
        if(database.containsUsername(user.getName()))
        {
            System.out.println("Username already exists");                           //pop up cu mesaj
            namefield.clear();
            passwordfield.clear();
        }
        else
        {
            if(user.checkUsername(user.getName()) && user.checkPassword(user.getPassword()))
            {
                database.addUser(user);
                System.out.println("Registered!");
            }
            else
            {
                System.out.println("Username must be between 5 - 15 characters(only letters and numbers allowed).\nPassword must be between 7 - 12 characters\n");
            }

        }

    }
}


