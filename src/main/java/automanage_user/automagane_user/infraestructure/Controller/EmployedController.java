package automanage_user.automagane_user.infraestructure.Controller;

import automanage_user.automagane_user.commons.response.ResponseBody;
import automanage_user.automagane_user.domain.dto.querys.PuntoCreditoDto;
import automanage_user.automagane_user.domain.entity.Employed;
import automanage_user.automagane_user.domain.dto.querys.PuntoCreditoRowMapper;
import automanage_user.automagane_user.infraestructure.interfaceService.IEmployed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/sumas/usuarios")
@CrossOrigin(value = "*")
public class EmployedController {
    @Autowired
    private IEmployed informacionEmpleado;

    @PostMapping("/save/employed")
    public ResponseEntity<ResponseBody<?>>saveInfoEmpleado(@RequestBody Employed infoEmpleado){
        System.out.println(infoEmpleado.getFirstLastName());
        informacionEmpleado.save(infoEmpleado);
        return new ResponseEntity<>(ResponseBody
                .init()
                .data(infoEmpleado)
                .status(200)
                .message("guardado con exito")
                .build(),HttpStatus.OK);
    }



}
