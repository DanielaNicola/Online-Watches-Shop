package exceptions;

public class UsernameDoesNotExists extends  Exception{

    private String username;
    public UsernameDoesNotExists(String username) {
        super(String.format("Username and/or password are wrong", username));
        this.username = username;
    }


    public String getUsername()
    {
        return username;
    }

}
