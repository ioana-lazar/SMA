import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ServiceList {
    ArrayList<Service> services = new ArrayList<>();
    static String answer;

    public void initialize(){
        services.add(new Service("Netflix", 40.0));
        services.add(new Service("Spotify", 20.0));
        services.add(new Service("HBO Go", 30.0));
    }


    public static String display(){
        Stage window = new Stage();

        Label label = new Label("Choose a service:");

        ListView<String> list = new ListView<String>();
        list.getItems().addAll("Netflix", "Spotify", "HBO Go");
        list.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        Button button = new Button("Add");
        button.setOnAction(e -> {
            answer = list.getSelectionModel().getSelectedItem();
            window.close();
        });

        VBox layout = new VBox(20);
        layout.getChildren().addAll(label, list, button);
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout);
        window.setTitle("Service List");
        window.setScene(scene);
        window.showAndWait();

        return answer;
    }

    public Service contains(String name){
        for(Service s:services){
            if(s.getName().equals(name)) {
                return s;
            }
        }
        return null;
    }
}
