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
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import model.EditItems;

import model.User;

import java.net.URL;
import java.util.ResourceBundle;


public class SeeListOfWatchesPage implements Initializable{
    @FXML
    private User user;

    public void setUser(User user) {
        this.user = user;
    }
    @FXML
    private Button inapoi;
    @FXML
    public static  TableView<EditItems> table_2;

    @FXML
    private TableView<EditItems> table;

    @FXML
    private TableColumn<EditItems, String> id;

    @FXML
    private TableColumn<EditItems, String> items;

    @FXML
    private TableColumn<EditItems,String> prices;

    @FXML
    private TableColumn<EditItems,Button> edit;
    public static ObservableList<EditItems> editItems;




    ObservableList<EditItems> list1 = FXCollections.observableArrayList(

            new EditItems("1","350 lei", "Fossil", new Button("update")),
            new EditItems("2","500 lei", "Guess", new Button("update")),
            new EditItems("3","400 lei", "Calvin Klein", new Button("update")),
            new EditItems("4","150 lei", "Nautica", new Button("update")),
            new EditItems("5","800 lei", "Diesel", new Button("update")),
            new EditItems("6","300 lei", "Casio", new Button("update")),
            new EditItems("7","450 lei", "Smart Watch", new Button("update")),
            new EditItems("8","600 lei", "Furla", new Button("update")),
            new EditItems("9","700 lei", "Tissot", new Button("update")),
            new EditItems("10","550 lei", "Daniel Klein", new Button("update"))


    );

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {    table_2=table;
        initTable();
        loadData();
        table.setItems(list1);


    }

    private void initTable(){
        intiCols();
    }

    private void intiCols(){
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        prices.setCellValueFactory(new PropertyValueFactory<>("prices"));
        items.setCellValueFactory(new PropertyValueFactory<>("items"));
        edit.setCellValueFactory(new PropertyValueFactory<>("update"));

        editableCols();
    }
    private void editableCols(){
        id.setCellFactory(TextFieldTableCell.forTableColumn());
        id.setOnEditCommit(e->{
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setId(e.getNewValue());
        });
        prices.setCellFactory(TextFieldTableCell.forTableColumn());
        prices.setOnEditCommit(e->{
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setItems(e.getNewValue());
        });
        items.setCellFactory(TextFieldTableCell.forTableColumn());
        items.setOnEditCommit(e->{
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setItems(e.getNewValue());
        });
        table.setEditable(true);
    }

    private void loadData(){
        editItems = FXCollections.observableArrayList();
        for(int i=0; i<6; i++){
            editItems.add(new EditItems(String.valueOf(i), "prices " + i, "items " + i, new Button("update")));
        }
        table.setItems(editItems);
    }


    @FXML
    public void handleInapoiAction() throws Exception {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("customerpage.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) (inapoi.getScene().getWindow());
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }


}