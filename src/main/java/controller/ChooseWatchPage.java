package controller;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.User;
import service.UserService;

import java.net.URL;
import java.util.ResourceBundle;

import static controller.Login.getUserCurrent;

public class ChooseWatchPage implements Initializable {
    ObservableList list = FXCollections.observableArrayList();
    ObservableList listQuantity = FXCollections.observableArrayList();

    @FXML
    private ChoiceBox<String> Watch;
    @FXML
    private ChoiceBox<String> Quantity;
    @FXML
    private Button buttonSelect;

    @FXML
    private Button ButonBack;
    @FXML
    private User user;
    @FXML
    private Text screen;
    @FXML
    private Text screen1;
    @FXML
    private Text mesaj;
    @FXML
    private Text detalii;


    public void setUser(User user) {
        this.user = user;
    }

    @FXML
    public void handleChooseWatch() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("ChooseWatch.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) (buttonSelect.getScene().getWindow());
        stage.setScene(new Scene(root));
        CustomerPage watch = loader.getController();
        watch.setUser(user);
        stage.show();
    }


    @FXML
    public void handleBack() throws Exception {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("customerpage.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) (ButonBack.getScene().getWindow());
            stage.setScene(new Scene(root));
            CustomerPage client = loader.getController();
            client.setUser(user);
            stage.show();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadData();
        loadDataQuantity();
    }

    private void loadData() {
        list.removeAll(list);
        String a = "Fossil";
        String b = "Guess";
        String c = "Calvin Klein";
        String d = "Nautica";
        String e = "Diesel";
        String f = "Casio";
        String g = "Smart Watch";
        String h = "Furla";
        String i = "Tissot";
        String j = "Daniel Klein";
        list.addAll(a, b, c, d, e, f, g, h, i, j);
        Watch.getItems().addAll(list);
    }

    private void loadDataQuantity() {
        listQuantity.removeAll(listQuantity);
        String a = "1";
        String b = "2";
        String c = "3";
        String d = "4";
        String e = "5";
        String f = "6";
        String g = "7";
        String h = "8";
        String i = "9";
        String j = "10";

        listQuantity.addAll(a, b, c, d, e, f, g, h, i, j );
        Quantity.getItems().addAll(listQuantity);
    }


    @FXML

    public void displayValue(javafx.event.ActionEvent actionEvent) {
        String watch = Watch.getValue();
        String optiuneUser = UserService.getOptiune(getUserCurrent);
        String quantity = Quantity.getValue();
        if (watch == null) {
            screen.setText("Select Watch:");
        } else if (watch .contains(optiuneUser)) {
            mesaj.setText("The product was selected!");
            int index = watch .indexOf("-");
            String watchName = watch .substring(0, index);
            System.out.println(watchName);
            UserService.setWatch(getUserCurrent, watchName);
            UserService.setQuantity(getUserCurrent, quantity);





    }
}
}
