package src.main;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class PopUp {
    public static void display(String title, String message){
        Stage window = new Stage();
        window.setTitle(title);
        window.setMinWidth(300);

        Label label = new Label();
        label.setText(message);
        label.setFont(Font.font(16));
        Button button = new Button();
        button.setText("OK");
        button.setOnAction(e -> window.close());

        VBox layout = new VBox(20);
        layout.getChildren().addAll(label, button);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 300, 200);
        window.setScene(scene);
        window.showAndWait();
    }
}
