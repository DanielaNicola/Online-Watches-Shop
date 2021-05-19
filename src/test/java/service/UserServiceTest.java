package service;

import static org.junit.jupiter.api.Assertions.*;
import exceptions.UsernameAlreadyExists;
import model.User;
import org.apache.commons.io.FileUtils;
//import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


class UserServiceTest {

    @AfterEach
    void tearDown() {

        UserService.database.close();
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("BeforeClass");

    }

    @AfterAll
    static void afterAll() {
        System.out.println("AfterClass");

    }

    @BeforeEach
    void setUp() throws Exception {


        FileSystemService.APPLICATION_FOLDER = ".test-registration-example";
        FileSystemService.initDirectory();
        FileUtils.cleanDirectory(FileSystemService.getApplicationHomeFolder().toFile());
        UserService.initDatabase();

    }

    @Test
    @DisplayName("Data Base was initialized and has no users")
    void testDatabaseIsInitializedAndNoUserIsPersisted() {
        //UserService.initDatabase();
        assertThat(UserService.getAllUsers()).isNotNull();
        assertThat(UserService.getAllUsers()).isEmpty();
    }

    @Test
    @DisplayName("User is added in Data Base")
    void testUserIsAddedToDatabase() throws UsernameAlreadyExists {
        //UserService.initDatabase();
        UserService.addUser("ana", "123", "Customer");
        assertThat(UserService.getAllUsers()).isNotEmpty();
        assertThat(UserService.getAllUsers()).size().isEqualTo(1);
        User user = UserService.getAllUsers().get(0);
        assertThat(user).isNotNull();
        assertThat(user.getUsername()).isEqualTo("ana");
        assertThat(user.getPassword()).isEqualTo(UserService.encodePassword("ana", "123"));
        assertThat(user.getRole()).isEqualTo("Customer");


        UserService.addUser("ion", "15", "Seller");
        assertThat(UserService.getAllUsers()).isNotEmpty();
        assertThat(UserService.getAllUsers()).size().isEqualTo(2);
        User user1 = UserService.getAllUsers().get(1);
        assertThat(user1).isNotNull();
        assertThat(user1.getUsername()).isEqualTo("ion");
        assertThat(user1.getPassword()).isEqualTo(UserService.encodePassword("ion", "15"));
        assertThat(user1.getRole()).isEqualTo("Seller");


    }

    @Test
    @DisplayName("User can't be added twice")
    void testUserCanNotBeAddedTwice() {
        assertThrows(UsernameAlreadyExists.class, () -> {
            UserService.addUser("ana", "123", "Customer");
            UserService.addUser("ana", "123", "Customer");
        });
    }

    @Test
    @DisplayName("Verify option")
    void testAdaugareOptiune() throws Exception {
        UserService.addUser("ana", "123", "Customer");
        UserService.adaugareOptiune("ana", "Fossil");
        assertThat(UserService.getAllUsers()).isNotEmpty();
        assertThat(UserService.getAllUsers()).size().isEqualTo(1);
        User user = UserService.getAllUsers().get(0);
        assertThat(user).isNotNull();
        assertThat(user.getOptiune()).isEqualTo("Fossil");
    }

    @Test
    @DisplayName("Verify if user exists")
    void testcheckUsernameAlreadyExists() throws UsernameAlreadyExists {
        UserService.addUser("ana", "123", "Customer");
        assertThrows(UsernameAlreadyExists.class, () -> {
            UserService.checkUserDoesNotAlreadyExist("ana");
        });

    }
}

