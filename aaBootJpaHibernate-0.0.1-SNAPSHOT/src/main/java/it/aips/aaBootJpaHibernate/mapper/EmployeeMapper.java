package it.aips.aaBootJpaHibernate.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import it.aips.aaBootJpaHibernate.DTO.EmployeeDto;
import it.aips.aaBootJpaHibernate.model.Employee;

@Component
public class EmployeeMapper {

	public EmployeeDto toDTO(Employee model) {
		EmployeeDto dto=new EmployeeDto();
		dto.setId(model.getId());
		dto.setName(model.getName());
		dto.setEmail(model.getEmail());
		
		return dto;
	}
	
	public Employee toModel(EmployeeDto dto) {
		Employee model=new Employee();
		model.setId(dto.getId());
		model.setName(dto.getName());
		model.setEmail(dto.getEmail());
		
		return model;
	}
	
    public List<EmployeeDto> toDtoList(List<Employee> employee) {
        return employee.stream()
            .map(this::toDTO)
            .collect(Collectors.toList());
    }

/*	public EmployeeDto toDTO(Optional<Employee> address) {
		return toDTO(address);
	}*/
}
