package automanage_user.automagane_user.infraestructure.configuration;

import org.springframework.context.annotation.Configuration;

@Configuration
public class EncodeUrlVerification {
    public String codificarUrl(String cedula){
        char array[] = cedula.toCharArray();
        for(int i = 0 ; i<array.length;i++){
            array[i] = (char)(array[i] + (char)20);
        }
        String encriptado = String.valueOf(array);
        return encriptado;
    }

    public Boolean verificarUrl(String cedula,String encode) {
        char array[] = encode.toCharArray();
        for (int i = 0; i < array.length; i++) {
            array[i] = (char) (array[i] - (char)20);
        }
        String desencriptado = String.valueOf(array);
        if(cedula.equals(desencriptado)){
            return true;
        }
        return false;
    }

    public String descodificarUrl(String encode) {
        char array[] = encode.toCharArray();
        for (int i = 0; i < array.length; i++) {
            array[i] = (char) (array[i] - (char)20);
        }
        String desencriptado = String.valueOf(array);
        return desencriptado;
    }

    public Boolean validarToken(String token){
        if(!token.equals("1707a235937a8330cc761917450ffbad")){
            return false;
        }
        return true;
    }
}
