package automanage_user.automagane_user.infraestructure.Controller;

import automanage_user.automagane_user.commons.response.ResponseBody;
import automanage_user.automagane_user.domain.dto.EmpleadoDto;
import automanage_user.automagane_user.domain.entity.Empleado;
import automanage_user.automagane_user.infraestructure.interfaceService.IEmployed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "${spring.base_url}")
@CrossOrigin(value = "*")
public class EmployedController {
    @Autowired
    private IEmployed informacionEmpleado;

    @PostMapping("/save/employed")
    public ResponseEntity<ResponseBody<?>>saveInfoEmpleado(@RequestBody EmpleadoDto empleadoDto){
        informacionEmpleado.save(empleadoDto);
        return new ResponseEntity<>(ResponseBody
                .init()
                .data(empleadoDto)
                .status(200)
                .message("guardado con exito")
                .build(),HttpStatus.OK);
    }



}
