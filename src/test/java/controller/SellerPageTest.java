package controller;

import static org.junit.jupiter.api.Assertions.*;
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
class SellerPageTest {
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

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("sellerpage.fxml"));
        primaryStage.setTitle("Online Shop");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }
    @Test
    void testPaginaManager(FxRobot robot) {
        robot.clickOn("#butonEditItems");
        robot.clickOn("#butonBack");
        robot.clickOn("#butonListOrders");
        robot.clickOn("#inapoi");
        robot.clickOn("#butonListCustomers");
        robot.clickOn("#inapoi");
        robot.clickOn("#butonDisconnect");


    }


}