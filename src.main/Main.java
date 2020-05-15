import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import login_register.Database;
import post_login.ServiceList;

public class Main extends Application {

    //load users

    @Override
    public void start(Stage primaryStage) throws Exception{

        Database.loadUsersFromFile();
        ServiceList.loadServicesFromFile();

        Parent root = FXMLLoader.load(getClass().getResource("login_register/loginwindow.fxml"));

        primaryStage.setTitle("Welcome!");
        primaryStage.setScene(new Scene(root, 550, 150));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
