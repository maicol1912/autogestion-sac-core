package automanage_user.automagane_user.aplication.Validaciones;

import automanage_user.automagane_user.aplication.Exception.NotTokenValid;
import automanage_user.automagane_user.commons.Exceptions.CodigoErrorEnum;
import automanage_user.automagane_user.domain.dto.UsuarioGeneralDto;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class ValidacionCaracteres {

    private static final Logger LOGGER = Logger.getLogger(ValidacionCaracteres.class);
    public Boolean validarCaracter(UsuarioGeneralDto usuarioGeneralDto){
         LOGGER.info("se inicia validacion de los campos de informacion personal");

         String NOMBRE_UNO = usuarioGeneralDto.getEpl_nombreuno();
         String NOMBRE_DOS = usuarioGeneralDto.getEpl_nombredos();
         String APELLIDO_UNO = usuarioGeneralDto.getEpl_apellidouno();
         String APELLIDO_DOS = usuarioGeneralDto.getEpl_apellidodos();

         if(NOMBRE_UNO.matches(".*\\d.*") ||NOMBRE_DOS.matches(".*\\d.*")||
            APELLIDO_UNO.matches(".*\\d.*") ||APELLIDO_DOS.matches(".*\\d.*")){
             return false;
         }
         LOGGER.info("se realiza validacion de los campos de informacion personal y estos son -> validos");
         return true;
    }
}
