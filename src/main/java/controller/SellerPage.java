package controller;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.User;
import service.UserService;

import java.io.IOException;

public class SellerPage {

    @FXML
    private Button butonCreareCont;
    @FXML
    private Button butonAdaugareServiciiSiPreturi;
    @FXML
    private Button butonVizualizareListaClientiInAsteptare;
    @FXML
    private Button butonDeconectare;
    @FXML
    private User user;
    @FXML
    private Button buttonCreate;
    @FXML
    private Text registrationMessage;

    private  String userName;
    public  void setUser(User user){
        this.user=user;
    }

    public void handleCreareCont() throws IOException {
        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("crearecont.fxml"));
            Stage stage = (Stage) (butonCreareCont.getScene().getWindow());
            stage.setScene(new Scene(root));
            stage.show();
        }
        catch (IOException e)
        {
            System.out.println("eroare");
        }
    }

    public void handleAdaugareServiciiSiPreturi() throws IOException {
        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("managerEditareServiciiPreturi.fxml"));
            Stage stage = (Stage) (butonAdaugareServiciiSiPreturi.getScene().getWindow());
            stage.setScene(new Scene(root));
            stage.show();
        }
        catch (IOException e)
        {
            System.out.println("eroare");
        }
    }
    public void handleVizualizareListaClientiInAsteptare() throws IOException {
        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("managerProgAsteptare.fxml"));
            Stage stage = (Stage) (butonVizualizareListaClientiInAsteptare.getScene().getWindow());
            stage.setScene(new Scene(root));
            stage.show();
        }
        catch (IOException e)
        {
            System.out.println("eroare");
        }
    }
    public void handleDeconectare() throws IOException {
        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("login.fxml"));
            Stage stage = (Stage) (butonDeconectare.getScene().getWindow());
            stage.setScene(new Scene(root));
            stage.show();
        }
        catch (IOException e)
        {
            System.out.println("eroare");
        }
    }
    @FXML
    public void handleRegisterAction() throws Exception{
        try{
            Parent root= FXMLLoader.load(getClass().getClassLoader().getResource("register.fxml"));
            Stage stage = (Stage) (buttonCreate.getScene().getWindow());
            stage.setScene(new Scene(root));
            stage.show();

        } catch(IOException e){
            registrationMessage.setText("eroare!");
        }
    }
}
