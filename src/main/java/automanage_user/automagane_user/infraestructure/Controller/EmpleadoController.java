package automanage_user.automagane_user.infraestructure.Controller;

import automanage_user.automagane_user.commons.response.ResponseBody;
import automanage_user.automagane_user.domain.dto.EmpleadoDto;
import automanage_user.automagane_user.infraestructure.interfaceService.IEmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping(value = "${spring.base_url}")
@CrossOrigin(value = "*")
public class EmpleadoController {
    @Autowired
    private IEmpleado empleadoService;

    @PostMapping("/save/employed")
    public ResponseEntity<ResponseBody<?>>saveEmpleado(@RequestBody EmpleadoDto empleadoDto){
        empleadoService.save(empleadoDto);
        return new ResponseEntity<>(ResponseBody
                .init()
                .data(empleadoDto)
                .status(200)
                .message("guardado con exito")
                .build(),HttpStatus.OK);
    }



}
