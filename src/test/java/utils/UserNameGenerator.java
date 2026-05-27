package utils;

import java.util.UUID;

/**
 * @author wiles42
 */
public class UserNameGenerator {

    public static String generateEmail(){
        return "test" + UUID.randomUUID() + "@gmail.com";
    }
    public static String generatePassword(){
        return "Password123!";
    }
}
