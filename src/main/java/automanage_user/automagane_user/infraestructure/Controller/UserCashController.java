package automanage_user.automagane_user.infraestructure.Controller;

import automanage_user.automagane_user.domain.entity.UserCash;
import automanage_user.automagane_user.infraestructure.interfaceService.IUserCash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/sumas/usuarios")
@CrossOrigin(value = "*")
public class UserCashController {


    @Autowired
    private IUserCash iUserCash;

    @PostMapping("/save/user/cash")
    @ResponseStatus(HttpStatus.OK)
    public Map<String,String> saveInfoEmpleado(@RequestBody UserCash infoUsuarioCaja){
        iUserCash.save(infoUsuarioCaja);
        Map<String,String>response = new HashMap<String,String>();
        response.put("message","con exito");
        response.put("status", String.valueOf(HttpStatus.OK));
        return response;
    }

}
