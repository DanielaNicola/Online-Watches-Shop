package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
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
class RegistrationTest {
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

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("register.fxml"));
        primaryStage.setTitle("Online Shop");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }

    @Test
    void testRegistration(FxRobot robot) {

        robot.clickOn("#usernameField");
        robot.write("ana");
        robot.clickOn("#passwordField");
        robot.write("123");
        robot.clickOn("#role");
        robot.clickOn("Customer");

        robot.clickOn("#buttonCreate");
        assertThat(robot.lookup("#registrationMessage").queryText()).hasText("Account created successfully!");

        robot.clickOn("#button");
        robot.clickOn("#buttonCreate");

        robot.clickOn("#usernameField");
        robot.write("ana");
        robot.clickOn("#passwordField");
        robot.write("123");
        robot.clickOn("#role");
        robot.clickOn("Customer");
        robot.clickOn("#buttonCreate");
        assertThat(robot.lookup("#registrationMessage").queryText()).hasText(String.format("An account with the username %s already exists!", "ana"));

        robot.clickOn("#button");
        robot.clickOn("#buttonCreate");
        robot.clickOn("#usernameField");

        robot.clickOn("#usernameField");
        robot.write("ion");
        robot.clickOn("#passwordField");
        robot.write("15");
        robot.clickOn("#role");
        robot.clickOn("Seller");
        robot.clickOn("#buttonCreate");
        assertThat(robot.lookup("#registrationMessage").queryText()).hasText("Account created successfully!");

        robot.clickOn("#button");
        robot.clickOn("#buttonCreate");

        robot.clickOn("#usernameField");
        robot.write("ion");
        robot.clickOn("#passwordField");
        robot.write("15");
        robot.clickOn("#role");
        robot.clickOn("Seller");
        robot.clickOn("#buttonCreate");
        assertThat(robot.lookup("#registrationMessage").queryText()).hasText(String.format("An account with the username %s already exists!", "ion"));
    }
}