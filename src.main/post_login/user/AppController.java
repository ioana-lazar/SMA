package post_login.user;

import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import post_login.Date;
import post_login.Service;
import post_login.ServiceList;

public class AppController {
    public TableColumn<Service, String> namecolumn;  //o coloana cu nume de tip service
    public TableColumn<Service, Double> pricecolumn; //o coloana cu pret de tip service
    public TableColumn<Service, Date> datecolumn;      // data
    public TableView<Service> table; //aici sunt adaugate coloanele de sus

    public void initialize(){
        namecolumn.setCellValueFactory(new PropertyValueFactory<>("name")); //o sa contina proprietatea nume, din servicii
        pricecolumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        //datecolumn.setCellValueFactory(new PropertyValueFactory<>("date"));

        //table.setItems(getProducts());
        //table.getColumns().addAll(namecolumn, pricecolumn, datecolumn);
    }

    public void add(){
        String result = ServiceList.display();
        Service service = ServiceList.getService(result);

        table.getItems().add(service);
    }

    public void delete(){
        ObservableList<Service> serviceToDelete, allServices;
        allServices = table.getItems();
        serviceToDelete = table.getSelectionModel().getSelectedItems();

        serviceToDelete.forEach(allServices::remove);
    }
}
