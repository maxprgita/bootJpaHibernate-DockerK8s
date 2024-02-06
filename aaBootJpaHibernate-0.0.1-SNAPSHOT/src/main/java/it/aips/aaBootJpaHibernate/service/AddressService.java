package it.aips.aaBootJpaHibernate.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.aips.aaBootJpaHibernate.DTO.AddressDto;
import it.aips.aaBootJpaHibernate.DTO.EmployeeDto;
import it.aips.aaBootJpaHibernate.mapper.AddressMapper;
import it.aips.aaBootJpaHibernate.mapper.EmployeeMapper;
import it.aips.aaBootJpaHibernate.model.Address;
import it.aips.aaBootJpaHibernate.repository.IAddressRepository;

@Service
public class AddressService {

	@Autowired
	IAddressRepository repo;

	@Autowired
	private AddressMapper mapperAdd;

	@Autowired
	private EmployeeMapper mapperEmpl;

	public List<EmployeeDto> getEmployeesByAddressId(Integer addressId) {
		Address address = repo.findById(addressId).orElse(null);

		if (address != null) {
			return address.getEmployees().stream().map(mapperEmpl::toDTO).collect(Collectors.toList());
		} else {
			return null;
		}
	}

	public List<AddressDto> findAll() {
		return mapperAdd.toDtoList(repo.findAll());
	}

	public AddressDto findById(int id) {
		Optional<Address> address = repo.findById(id);
		return address.map(mapperAdd::toDTO).orElse(null);
	}

	public boolean save(AddressDto dati) {
		repo.save(mapperAdd.toModel(dati));
		return true;
	}

	public boolean update(int id, AddressDto dati) {
		if (repo.existsById(id)) {
			repo.save(mapperAdd.toModel(dati));
			return true;
		} else
			return false;
	}

	public boolean delete(int id) {
		if (repo.existsById(id)) {
			repo.deleteById(id);
			return true;
		} else
			return false;
	}

}
