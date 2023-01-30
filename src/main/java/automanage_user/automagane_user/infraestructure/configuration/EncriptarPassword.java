package automanage_user.automagane_user.infraestructure.configuration;

import org.springframework.context.annotation.Configuration;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Configuration
public class EncriptarPassword {

    public String encript(String passwordOriginal){
        try{
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] messageDigest = md.digest(passwordOriginal.getBytes());
            BigInteger bigInt = new BigInteger(1,messageDigest);

            return bigInt.toString();
        }catch (NoSuchAlgorithmException e){
            return e.toString();
        }


    }
}
