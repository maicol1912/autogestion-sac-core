package automanage_user.automagane_user.infraestructure.Controller;

import automanage_user.automagane_user.commons.response.ResponseBody;
import automanage_user.automagane_user.domain.entity.User;
import automanage_user.automagane_user.infraestructure.interfaceService.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "${spring.base_url}")
@CrossOrigin(value = "*")
public class UserController {
/*
    @Autowired
    private IUser informacionUsuario;

    @PostMapping("/save/user")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ResponseBody<?>> saveInfoEmpleado(@RequestBody User infoUsuario){
        informacionUsuario.save(infoUsuario);
        return new ResponseEntity<>(ResponseBody
                .init()
                .data(infoUsuario)
                .status(200)
                .message("guardado con exito")
                .build(),HttpStatus.OK);
    }
*/
}
