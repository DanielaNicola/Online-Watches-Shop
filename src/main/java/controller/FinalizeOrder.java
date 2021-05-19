package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.User;
import service.UserService;

import static controller.Login.getUserCurrent;

public class FinalizeOrder {

    @FXML
    private Button inapoi;
    @FXML
    private Button FinalizeOrder;

    @FXML
    private Text Mesaj;

    @FXML
    private User user;
    public void setUser(User user) {
        this.user = user;
    }

    public void handleFinalize() {
        UserService.adaugareOptiune(getUserCurrent,"FinalizeOrder");
        Mesaj.setText("Order was finalized!");
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