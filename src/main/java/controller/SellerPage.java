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


public class SellerPage {
    @FXML
    private Button butonCreateAccount;
    @FXML
    private Button butonEditItems;
    @FXML
    private Button butonListOrders;
    @FXML
    private Button butonListCustomers;
    @FXML
    private Button butonDisconnect;
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

    public void handleCreateAccount() throws IOException {
        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("login.fxml"));
            Stage stage = (Stage) (butonCreateAccount.getScene().getWindow());
            stage.setScene(new Scene(root));
            stage.show();
        }
        catch (IOException e)
        {
            System.out.println("error");
        }
    }

    public void handleEditItems() throws IOException {
        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("EditItems.fxml"));
            Stage stage = (Stage) (butonEditItems.getScene().getWindow());
            stage.setScene(new Scene(root));
            stage.show();
        }
        catch (IOException e)
        {
            System.out.println("error");
        }
    }
    public void handleListOrders() throws IOException {
        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("SeeOrders.fxml"));
            Stage stage = (Stage) (butonListOrders.getScene().getWindow());
            stage.setScene(new Scene(root));
            stage.show();
        }
        catch (IOException e)
        {
            System.out.println("error");
        }
    }
    public void handleListCustomers() throws IOException {
        //try
        {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("SeeCustomers.fxml"));
            Stage stage = (Stage) (butonListCustomers.getScene().getWindow());
            stage.setScene(new Scene(root));
            stage.show();
        }
       /* catch (IOException e)
        {
            System.out.println("eroare");
        }*/
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