import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class AppController {
    public TableColumn<Service, String> namecolumn;  //o coloana cu nume de tip service
    public TableColumn<Service, Double> pricecolumn; //o coloana cu pret de tip service
    public TableColumn<Service, Date> datecolumn;      // data
    public TableView table; //aici sunt adaugate coloanele de sus

    public void initialize(){
        namecolumn.setCellValueFactory(new PropertyValueFactory<>("name")); //o sa contina proprietatea nume, din servicii
        pricecolumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        datecolumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        //table.setItems(getProducts());
        //table.getColumns().addAll(namecolumn, pricecolumn, datecolumn);
    }

    public void add(){
        ServiceList popup = new ServiceList();
        popup.initialize();
        String result = popup.display();

        Service s = popup.contains(result);

        table.getItems().add(s);
    }

    public void delete(){
        ObservableList<Service> serviceToDelete, allServices;
        allServices = table.getItems();
        serviceToDelete = table.getSelectionModel().getSelectedItems();

        serviceToDelete.forEach(allServices::remove);
    }
}
