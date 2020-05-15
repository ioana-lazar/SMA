package post_login;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import login_register.FileSystemService;
import org.apache.commons.io.FileUtils;
import post_login.staff.AppControllerStaff;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ServiceList {
    public static List<Service> ServiceList;

    static String answer;

    private static final Path SERVICE_PATH = FileSystemService.getPathToFile("config", "resources/ListOfServices.json");

    public static void add(Service service) {
        ServiceList.add(service);
        persistService();
    }

    public static void delete(Service service) {
        ServiceList.remove(service);
    }

    public static void loadServicesFromFile() throws IOException        //called from main as an initializer
    {

        System.out.println(SERVICE_PATH);
        if (!Files.exists(SERVICE_PATH)) {

            FileUtils.copyURLToFile(((AppControllerStaff.class.getClassLoader()).getResource("resources/ListOfServices.json")), SERVICE_PATH.toFile());
        }

        ObjectMapper objectMapper = new ObjectMapper();

        ServiceList = objectMapper.readValue(SERVICE_PATH.toFile(), new TypeReference<List<Service>>(){});
    }

    private static void persistService() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(SERVICE_PATH.toFile(), ServiceList);
        } catch (IOException e) {
            System.out.println("Can't write service, service persists");
        }
    }

    public static String display(){
        Stage window = new Stage();

        Label label = new Label("Choose a service:");

        ListView<String> list = new ListView<>();
        for(Service service : ServiceList)
            list.getItems().addAll(service.getName());

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
        window.setTitle("post_login.Service List");
        window.setScene(scene);
        window.showAndWait();

        return answer;
    }       //shows the list to the user, returneaza selectia dupa ce da pe butonul add

    public static Service getService(String servicename)
    {
        for(Service service : ServiceList)
        {
            if(servicename.equals(service.getName()))
                return service;
        }
        return null;
    }

    public boolean contains(Service service){
        return ServiceList.contains(service);
    }

    public static List<Service> getList()
    {
        return ServiceList;
    }

}
