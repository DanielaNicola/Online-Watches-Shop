package controller;

import static org.junit.jupiter.api.Assertions.*;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import exceptions.UsernameAlreadyExists;
import exceptions.UsernameDoesNotExists;
import service.FileSystemService;
import service.UserService;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import static org.testfx.assertions.api.Assertions.assertThat;

@ExtendWith(ApplicationExtension.class)
class LoginTest {
    @AfterEach
    void tearDown() {

        UserService.database.close();
    }

    @BeforeEach
    void setUp() throws Exception {
        FileSystemService.APPLICATION_FOLDER = ".test-registration-example";
        FileSystemService.initDirectory();
        FileUtils.cleanDirectory(FileSystemService.getApplicationHomeFolder().toFile());
        UserService.initDatabase();

    }

    @Start
    void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("login.fxml"));
        primaryStage.setTitle("Online Shop");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }

    @Test
    void testLogin(FxRobot robot) throws UsernameAlreadyExists {
        UserService.addUser("ana" , "123" , "Customer");
        robot.clickOn("#usernameField");
        robot.write("ana");
        robot.clickOn("#passwordField");
        robot.write("123");
        robot.clickOn("#buttonLogin");

        robot.clickOn("#butonDisconnect");

        robot.clickOn("#usernameField");
        robot.write("maria");
        robot.clickOn("#passwordField");
        robot.write("1234");

        robot.clickOn("#buttonLogin");
        assertThat(robot.lookup("#registrationMessage").queryText()).hasText(String.format("Username and/or password are wrong", "denim"));


        robot.clickOn("#buttonCreate");
        robot.clickOn("#button");


        UserService.addUser("ion" , "15" , "Seller");


        robot.clickOn("#usernameField");
        robot.write("ion");
        robot.clickOn("#passwordField");
        robot.write("15");

        robot.clickOn("#buttonLogin");

    }

}