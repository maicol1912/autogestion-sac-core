package automanage_user.automagane_user.aplication.Validaciones;
import automanage_user.automagane_user.domain.dto.UsuarioGeneralDto;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class ValidacionCaracteres {

    public Boolean validarCaracter(UsuarioGeneralDto usuarioGeneralDto){

         String NOMBRE_UNO = usuarioGeneralDto.getEpl_nombreuno();
         String NOMBRE_DOS = usuarioGeneralDto.getEpl_nombredos();
         String APELLIDO_UNO = usuarioGeneralDto.getEpl_apellidouno();
         String APELLIDO_DOS = usuarioGeneralDto.getEpl_apellidodos();

         if(NOMBRE_UNO.matches(".*\\d.*") ||NOMBRE_DOS.matches(".*\\d.*")||
            APELLIDO_UNO.matches(".*\\d.*") ||APELLIDO_DOS.matches(".*\\d.*")){
             return false;
         }

         if(!((NOMBRE_UNO.length()>4 && NOMBRE_UNO.length()<21)||(NOMBRE_DOS.length()>1 && NOMBRE_UNO.length()<21)||
             (APELLIDO_UNO.length()>4 && NOMBRE_UNO.length()<21)||(APELLIDO_DOS.length()>4 && NOMBRE_UNO.length()<21))){
             return false;
         }
         return true;
    }
}
