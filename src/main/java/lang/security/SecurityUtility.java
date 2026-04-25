package lang.security;

import lombok.SneakyThrows;

import java.security.MessageDigest;
import java.util.Base64;

public class SecurityUtility {

    @SneakyThrows
    public static String getHash(String password) {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(password.getBytes());
        byte[] digest = messageDigest.digest();
        return Base64.getEncoder().encodeToString(digest);
    }
}
