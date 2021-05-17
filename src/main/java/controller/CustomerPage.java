package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.User;

import java.io.IOException;

public class CustomerPage {
    @FXML
    private Button butonCreareCont;
    @FXML
    private Button butonAlegereAngajat;
    @FXML
    private Button butonDeconectare;
    @FXML
    private Button butonVizualizareListaServiciiSiPreturi;
    @FXML
    private Button AlegereOptiuneDorita;
    @FXML
    private Button buttonCreate;
    @FXML
    private Text registrationMessage;

    @FXML
    private User user;

    public void setUser(User user)
    {
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
    public void handleAlegereAngajat() throws IOException {
        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("clientAlegereAngajat.fxml"));
            Stage stage = (Stage) (butonAlegereAngajat.getScene().getWindow());
            stage.setScene(new Scene(root));
            stage.show();
        }
        catch (IOException e)
        {
            System.out.println("eroare");
        }
    }

    public void handleVizualizareListaServiciiSiPreturi() throws IOException {
        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("clientServiciiPreturi.fxml"));
            Stage stage = (Stage) (butonAlegereAngajat.getScene().getWindow());
            stage.setScene(new Scene(root));
            stage.show();
        }
        catch (IOException e)
        {
            System.out.println("eroare");
        }
    }

    public void handleAlegereOptiuneDorita() throws IOException {
        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("clientAlegereOptiune.fxml"));
            Stage stage = (Stage) (butonAlegereAngajat.getScene().getWindow());
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
