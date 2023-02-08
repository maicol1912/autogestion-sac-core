package automanage_user.automagane_user.aplication.services;

import automanage_user.automagane_user.aplication.Exception.NotTokenValid;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
@Service
public class TokenService {
    private static final Logger LOGGER = Logger.getLogger(TokenService.class);
    private final ConcurrentHashMap<String, Token> tokenStore = new ConcurrentHashMap<>();

    public String generateToken() {
        Long expiresIn = 60000L;
        String token = UUID.randomUUID().toString();
        Date expirationDate = new Date(System.currentTimeMillis() + expiresIn);
        tokenStore.put(token, new Token(token, expirationDate));
        LOGGER.info("se realiza la generacion del token");
        return token;
    }

    public boolean isTokenValid(String token) {
        String tokenFormatter = token.replace("Bearer ","");
        Token storedToken = tokenStore.get(tokenFormatter);
        if (storedToken == null) {
            return false;
        }
        return storedToken.expirationDate.after(new Date());
    }

    private static class Token {
        private final String token;
        private final Date expirationDate;

        Token(String token, Date expirationDate) {
            this.token = token;
            this.expirationDate = expirationDate;
        }
    }

    public Boolean validarToken(String token){
        if(!this.isTokenValid(token)){
            throw new NotTokenValid("el token no es valido");
        }
        LOGGER.info("se valida el token y este es valido");
        return true;
    }
}
