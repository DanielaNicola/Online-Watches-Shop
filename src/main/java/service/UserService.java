package service;
import exceptions.UsernameAlreadyExists;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import exceptions.UsernameDoesNotExists;
import model.User;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Objects;

import static service.FileSystemService.getPathToFile;

public class UserService {
    public static ObjectRepository<User> userRepository;
    public static Nitrite database;
    public static void initDatabase() {
        FileSystemService.initDirectory();
         database = Nitrite.builder()
                .filePath(getPathToFile("ShopOnline.db").toFile())
                .openOrCreate("test", "test");

        userRepository = database.getRepository(User.class);
    }


    public static User login(String username, String password) throws UsernameDoesNotExists {
        User crt;

        crt = attemptLogin(username, password);

        if (crt == null) {
            throw new UsernameDoesNotExists(username);
        }

        return crt;
    }

    public static User attemptLogin(String username, String password) {
        for (User user : userRepository.find()) {
            if (Objects.equals(username, user.getUsername()) && Objects.equals(encodePassword(username, password), user.getPassword())) {
                return user;
            }
        }

        return null;
    }


    public static void addUser(String username, String password, String role) throws UsernameAlreadyExists {
        checkUserDoesNotAlreadyExist(username);
        userRepository.insert(new User(username, encodePassword(username, password), role));
    }

   public static void checkUserDoesNotAlreadyExist(String username) throws UsernameAlreadyExists {
        for (User user : userRepository.find()) {
            if (Objects.equals(username, user.getUsername()))
                throw new UsernameAlreadyExists(username);
        }
    }
    public static List<User> getAllUsers(){
        return userRepository.find().toList();
    }

    public static String encodePassword(String salt, String password) {
        MessageDigest md = getMessageDigest();
        md.update(salt.getBytes(StandardCharsets.UTF_8));

        byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));

        // This is the way a password should be encoded when checking the credentials
        return new String(hashedPassword, StandardCharsets.UTF_8)
                .replace("\"", ""); //to be able to save in JSON format
    }


    private static MessageDigest getMessageDigest() {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-512");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("SHA-512 does not exist!");
        }
        return md;
    }

    public static ObjectRepository<User> getUserRepository() {
        return userRepository;
    }

    public static void adaugareOptiune(String username, String optiune) {
        for (User user : userRepository.find()) {
            if (Objects.equals(username, user.getUsername())) {
                user.setOptiune(optiune);
                userRepository.update(user);
            }

        }
    }

    public static void setUserAcc(String username){
        for(User user : userRepository.find()){
            if(Objects.equals(username, user.getUsername())){
                user.setAcceptat(1);
                userRepository.update(user);
            }
        }
    }

    public static int getUserAcc(String username){
        for(User user : userRepository.find()){
            if(Objects.equals(username, user.getUsername())){
                return user.getAcceptat();
            }
        }
        return 0;
    }

    public static String getOptiune(String username) {
        for (User user : userRepository.find()) {
            if (Objects.equals(username, user.getUsername())) {
                return user.getOptiune();
            }

        }
        return null;
    }

    public static String getWatch(String username){
        for (User user : userRepository.find()) {
            if (Objects.equals(username, user.getUsername())) {
                return user.getWatch();
            }
        }
        return null;

    }

    public static String setWatch(String username, String watchName){
        for (User user : userRepository.find()) {
            if (Objects.equals(username, user.getUsername())) {
                user.setWatch(watchName);
                userRepository.update(user);
            }
        }
        return null;

    }


    public static String getQuantity(String username){
        for (User user : userRepository.find()) {
            if (Objects.equals(username, user.getUsername())) {
                return user.getQuantity();
            }
        }
        return null;

    }

    public static String setQuantity(String username, String quantity){
        for (User user : userRepository.find()) {
            if (Objects.equals(username, user.getUsername())) {
                user.setQuantity(quantity);
                userRepository.update(user);
            }
        }
        return null;

    }





}
