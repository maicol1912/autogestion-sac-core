package automanage_user.automagane_user.infraestructure.Controller;

import automanage_user.automagane_user.commons.response.ResponseBody;
import automanage_user.automagane_user.domain.entity.UsuarioPorCaja;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "${spring.base_url}")
@CrossOrigin(value = "*")
public class UserCashController {


    /*@Autowired
    private IUserCash iUserCash;

    @PostMapping("/save/user/cash")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ResponseBody<?>> saveInfoEmpleado(@RequestBody UsuarioPorCaja infoUsuarioCaja){
        iUserCash.save(infoUsuarioCaja);
        return new ResponseEntity<>(ResponseBody
                .init()
                .data(infoUsuarioCaja)
                .status(200)
                .message("guardado con exito")
                .build(),HttpStatus.OK);
    }
    */
}
