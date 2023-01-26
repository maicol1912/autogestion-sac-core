package automanage_user.automagane_user.infraestructure.interfaceService;

import automanage_user.automagane_user.domain.dto.EmpleadoDto;
import automanage_user.automagane_user.domain.dto.querys.EmpresaDto;

import java.util.List;

public interface IEmpresa {

    public List<EmpresaDto> listAll();

}
