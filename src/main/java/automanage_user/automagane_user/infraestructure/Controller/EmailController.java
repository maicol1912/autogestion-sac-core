package automanage_user.automagane_user.infraestructure.Controller;

import automanage_user.automagane_user.aplication.services.SendEmail;
import automanage_user.automagane_user.infraestructure.configuration.EncodeUrlVerification;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "${spring.base_url}")
@CrossOrigin(value = "*")
public class EmailController {


    @Autowired
    private EncodeUrlVerification encriptarUrl;

    @Autowired
    private SendEmail sendEmail;

    @Autowired
    private ModelMapper mapper;

    /*@GetMapping("/check/{cedula}/{encode}")
    @ResponseStatus(HttpStatus.OK)
    public String validarUrlCodificada(@PathVariable String cedula, @PathVariable String encode) {
        if(!encriptarUrl.verificarUrl(cedula,encode)) {
            return "no se pudo acceder al usuario, Eliminado";
        }
        if(usuarioService.findByCedula(cedula).isEmpty()){
            return "no existe el usuario que quieres activar";
        }
        UsuarioEntity usuarioEntity = usuarioService.findByCedula(cedula).get();
        usuarioEntity.setEstadoUsuario("ACT");
        usuarioService.save(usuarioEntity);
        return "si es igual usuario activado";
    }*/

    @GetMapping("/saludo")
    public String saludar(){
        return "hola mano";
    }
}
