package automanage_user.automagane_user.infraestructure.Controller;

import automanage_user.automagane_user.domain.entity.User;
import automanage_user.automagane_user.infraestructure.interfaceService.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/sumas/usuarios")
@CrossOrigin(value = "*")
public class UserController {

    @Autowired
    private IUser informacionUsuario;

    @PostMapping("/save/user")
    @ResponseStatus(HttpStatus.OK)
    public Map<String,String> saveInfoEmpleado(@RequestBody User infoUsuario){
        informacionUsuario.save(infoUsuario);
        Map<String,String>response = new HashMap<String,String>();
        response.put("message","con exito");
        response.put("status", String.valueOf(HttpStatus.OK));
        return response;
    }

}
