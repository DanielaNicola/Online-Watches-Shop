package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
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


@ExtendWith(ApplicationExtension.class)
class CustomerPageTest {

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

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("customerpage.fxml"));
        primaryStage.setTitle("Online Shop");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }
    @Test
    void testCustomerPage(FxRobot robot) {
        robot.clickOn("#butonChooseWatch");
        robot.clickOn("#ButonBack");
        robot.clickOn("#butonSeeWatches");
        robot.clickOn("#inapoi");
        robot.clickOn("#butonFinalize");
        robot.clickOn("#inapoi");
        robot.clickOn("#butonDisconnect");
    }
}