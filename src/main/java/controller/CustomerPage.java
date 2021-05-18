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
    private Button butonCreateAcc;
    @FXML
    private Button butonChooseWatch;
    @FXML
    private Button butonDisconnect;
    @FXML
    private Button butonSeeWatches;
    @FXML
    private Button butonFinalize;
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


    public void handleCreateAcc() throws IOException {
        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("register.fxml"));
            Stage stage = (Stage) (butonCreateAcc.getScene().getWindow());
            stage.setScene(new Scene(root));
            stage.show();
        }
        catch (IOException e)
        {
            System.out.println("error");
        }
    }
    public void handleChooseWatch() throws IOException {
        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("ChooseWatch.fxml"));
            Stage stage = (Stage) (butonChooseWatch.getScene().getWindow());
            stage.setScene(new Scene(root));
            stage.show();
        }
        catch (IOException e)
        {
            System.out.println("error");
        }
    }

    public void handleSeeWatches() throws IOException {
        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("SeeWatches.fxml"));
            Stage stage = (Stage) (butonSeeWatches.getScene().getWindow());
            stage.setScene(new Scene(root));
            stage.show();
        }
        catch (IOException e)
        {
            System.out.println("error");
        }
    }

    public void handleFinalize() throws IOException {
        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("Finalize.fxml"));
            Stage stage = (Stage) (butonFinalize.getScene().getWindow());
            stage.setScene(new Scene(root));
            stage.show();
        }
        catch (IOException e)
        {
            System.out.println("error");
        }
    }

    public void handleDisconnect() throws IOException {
        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("login.fxml"));
            Stage stage = (Stage) (butonDisconnect.getScene().getWindow());
            stage.setScene(new Scene(root));
            stage.show();
        }
        catch (IOException e)
        {
            System.out.println("error");
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
            registrationMessage.setText("error!");
        }
    }
}

