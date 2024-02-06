package it.aips.aaBootJpaHibernate.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import it.aips.aaBootJpaHibernate.DTO.AddressDto;
import it.aips.aaBootJpaHibernate.model.Address;

@Component
public class AddressMapper {

	public AddressDto toDTO(Address model) {
		AddressDto dto=new AddressDto();
		dto.setId(model.getId());
		dto.setLane1(model.getLane1());
		dto.setState(model.getState());
		
		return dto;
	}
	
	public Address toModel(AddressDto dto) {
		Address model=new Address();
		model.setId(dto.getId());
		model.setLane1(dto.getLane1());
		model.setState(dto.getState());
		
		return model;
	}
	
    public List<AddressDto> toDtoList(List<Address> addresses) {
        return addresses.stream()
            .map(this::toDTO)
            .collect(Collectors.toList());
    }

}
