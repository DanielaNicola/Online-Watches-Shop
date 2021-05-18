package controller;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import exceptions.UsernameAlreadyExists;
import exceptions.UsernameDoesNotExists;
import model.User;
import service.UserService;
import org.dizitart.no2.objects.ObjectRepository;

import java.io.IOException;
import static org.dizitart.no2.objects.filters.ObjectFilters.eq;

public class Login {
    private final ObjectRepository<User> REPOSITORY = UserService.getUserRepository();
    public static String getUserCurrent;
    @FXML
    private Text registrationMessage;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameField;
    @FXML
    private Button buttonLogin;
    @FXML
    private Button buttonCreate;

    public void handleLoginAction() throws Exception {
        try {
            User user = UserService.login(usernameField.getText(), passwordField.getText());
            getUserCurrent=usernameField.getText();
            String details = user.toString();
            if(user.getRole().equals("Seller")) {
                FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("sellerpage.fxml"));
                Parent root= loader.load();
                Stage stage = (Stage) (buttonLogin.getScene().getWindow());
                stage.setScene(new Scene(root));
                SellerPage seller = loader.getController();
                seller.setUser(user);
                stage.show();}
            else
            if(user.getRole().equals("Customer")){
                FXMLLoader loader1 = new FXMLLoader(getClass().getClassLoader().getResource("customerpage.fxml"));
                Parent root= loader1.load();
                Stage stage = (Stage) (buttonLogin.getScene().getWindow());
                stage.setScene(new Scene(root));
                CustomerPage customer = loader1.getController();
                customer.setUser(user);

                stage.show();
            }
            registrationMessage.setText("Succesful Login!");


        } catch (UsernameDoesNotExists e) {
            registrationMessage.setText(e.getMessage());
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
            registrationMessage.setText("Error.Please login again!");
        }
    }

    public String getUsername(){
        return usernameField.getText();
    }
    public String getPassword(){
        return passwordField.getText();
    }

}