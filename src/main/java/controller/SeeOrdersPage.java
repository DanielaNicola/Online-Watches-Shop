package controller;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import model.User;
import model.Orders;
import service.UserService;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class SeeOrdersPage implements Initializable {

    @FXML
    private TableView<Orders> table;
    @FXML
    private Button inapoi;
    @FXML
    private TableColumn<Orders, Integer> ID;

    @FXML
    private TableColumn<Orders, String> orders1;

    private ObservableList<Orders> orders2;

    ObservableList<Orders> list = FXCollections.observableArrayList(
    );
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        int i = 0;
        for(User user : UserService.userRepository.find()){
            if(user.getAcceptat() == 1){
                i++;
                String info= "Client: " + user.getUsername() + " " + user.getUsername() +  ", Optiune: " + UserService.getOptiune(user.getUsername()) ;
                list.add(new Orders(info ,i)) ;
                //System.out.println(info);
            }
        }
        ID.setCellValueFactory(new PropertyValueFactory<Orders,Integer>("ID"));
        orders1.setCellValueFactory(new PropertyValueFactory<Orders,String>("orders"));

        table.setItems(list);
    }
    @FXML
    public void handleInapoiAction() throws Exception {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("SellerPage.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) (inapoi.getScene().getWindow());
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            System.out.println("Eroare");
        }
    }
}