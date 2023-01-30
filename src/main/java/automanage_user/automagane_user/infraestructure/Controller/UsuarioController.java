package automanage_user.automagane_user.infraestructure.Controller;

import automanage_user.automagane_user.domain.dto.UsuarioDto;
import automanage_user.automagane_user.infraestructure.interfaceService.IUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import automanage_user.automagane_user.commons.response.ResponseBody;
@RestController
@RequestMapping(value = "${spring.base_url}")
@CrossOrigin(value = "*")
public class UsuarioController {

    @Autowired
    private IUsuario usuarioService;

    @PostMapping("/save/user")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ResponseBody<?>> saveInfoEmpleado(@RequestBody UsuarioDto infoUsuario){
        usuarioService.save(infoUsuario);
        return new ResponseEntity<>(
                ResponseBody
                .init()
                .data(infoUsuario)
                .status(200)
                .message("guardado con exito")
                .build(),HttpStatus.OK);
    }

}
