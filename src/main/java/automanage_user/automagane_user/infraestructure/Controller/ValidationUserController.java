package automanage_user.automagane_user.infraestructure.Controller;

import automanage_user.automagane_user.aplication.Exception.NotFoundActivateUser;
import automanage_user.automagane_user.aplication.Validaciones.*;
import automanage_user.automagane_user.aplication.services.SendEmail;
import automanage_user.automagane_user.commons.response.ResponseBody;
import automanage_user.automagane_user.infraestructure.configuration.EncodeUrlVerification;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;


@RestController
@RequestMapping(value = "${spring.base_url}")
@CrossOrigin(value = "*")
public class ValidationUserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ValidationUserController.class);
    @Autowired
    private EncodeUrlVerification encriptarUrl;

    @Autowired
    private SendEmail sendEmail;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private ValidacionEmpleadoService validacionEmpleadoService;

    @Autowired
    private ValidacionUsuarioService validacionUsuarioService;

    @Autowired
    private ValidacionUsuarioPorCajaService validacionUsuarioPorCajaService;

    @Autowired
    private ValidacionCambioEstadoUsuario validacionCambioEstadoUsuario;

   /* @GetMapping("/check/{cedula}/{encode}")
    public ResponseEntity<ResponseBody<?>> validarUrlCodificada(@RequestHeader String cedula, @PathVariable String encode) {
        if(!encriptarUrl.validarToken(cedula,encode)) {
            return new ResponseEntity<>(
                    ResponseBody
                            .init()
                            .data(null)
                            .code(409)
                            .message(exception.getMessage())
                            .build(), HttpStatus.CONFLICT);
        }
        if(usuarioService.findByCedula(cedula).isEmpty()){
            return "no existe el usuario que quieres activar";
        }
        UsuarioEntity usuarioEntity = usuarioService.findByCedula(cedula).get();
        usuarioEntity.setEstadoUsuario("ACT");
        usuarioService.save(usuarioEntity);
        return "si es igual usuario activado";
    }
*/
    @GetMapping("/validate/activar/{cedula}")
    @Transactional
    public ResponseEntity<ResponseBody<?>>cambiarEstadoUsuario(@PathVariable String cedula,@RequestHeader("Authorization") String authorization){

        LOGGER.info("Se inicia proceso de validacion de los datos del empleado para el cambio de estado");
        if(!validacionEmpleadoService.validateCambioEstadoEmpleado(cedula)){
            throw new NotFoundActivateUser("el empleado no puede ser cambiado de estado porque no existe");
        }
        LOGGER.info("Se inicia proceso de validacion de los datos del usuario para el cambio de estado");
        if(!validacionUsuarioService.validateCambioEstadoUsuario(cedula)){
            throw new NotFoundActivateUser("el empleado no puede ser cambiado de estado porque no existe");
        }
        LOGGER.info("Se inicia proceso de validacion de los datos del usuario por caja para el cambio de estado");
        if(!validacionUsuarioPorCajaService.validateCambioEstadoUsuarioPorCaja(cedula)){
            throw new NotFoundActivateUser("el empleado no puede ser cambiado de estado porque no existe");
        }
        LOGGER.info("Se inicia proceso de validacion del token enviado");
        validacionCambioEstadoUsuario.validarToken(authorization);

        LOGGER.info("Se inicia proceso de validacion del usuario que va a ser cambiado");
        validacionCambioEstadoUsuario.validarEstadoUsuarioParaCambio(cedula);
        return new ResponseEntity<>(
                ResponseBody
                        .init()
                        .data(cedula)
                        .code(200)
                        .message("se ha cambiado el estado del usuario, ahora su estado es activo")
                        .build(),HttpStatus.OK);
    }

}
