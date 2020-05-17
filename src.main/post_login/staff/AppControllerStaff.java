package post_login.staff;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import post_login.Service;
import post_login.ServiceList;

public class AppControllerStaff {

    public TableColumn<Service, String> namecolumn;
    public TableColumn<Service, Double> pricecolumn;
    public TableView <Service> table;
    @FXML
    TextField namefield, pricefield;

    public void initialize(){
        namecolumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        pricecolumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        table.setItems(getProducts());        //umple tabelul cu serviciile deja aflate in servicelist
    }

    public void addButton() {      //add a service to our array
        // the service should be taken from the text field
        Service service = new Service();
        service.setName(namefield.getText());
        service.setPrice(Double.parseDouble(pricefield.getText()));

        ServiceList.add(service);           //add to array
        table.getItems().add(service);      //add to table
        namefield.clear();
        pricefield.clear();


    }

    public void deleteButton() {

        ObservableList<Service> serviceToDelete;
        ObservableList<Service> allServices;

        allServices = table.getItems();
        serviceToDelete = table.getSelectionModel().getSelectedItems();

        serviceToDelete.forEach(allServices::remove);       //deletes the service from the table

        ServiceList.delete((Service) serviceToDelete);                ////deletes the service from the array

    }

    public ObservableList<Service> getProducts()        //helper method for getting the items from the array and initializing table
    {
        ObservableList<Service> listOfServices = FXCollections.observableArrayList();

        listOfServices.addAll(ServiceList.getList());

        return listOfServices;
    }
}
