package it.aips.aaBootJpaHibernate.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.aips.aaBootJpaHibernate.DTO.EmployeeDto;
import it.aips.aaBootJpaHibernate.mapper.EmployeeMapper;
import it.aips.aaBootJpaHibernate.model.Employee;
import it.aips.aaBootJpaHibernate.repository.IEmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	IEmployeeRepository repo;

	@Autowired
	private EmployeeMapper mapper;

	public List<EmployeeDto> findAll() {
		return mapper.toDtoList(repo.findAll());
	}

	public EmployeeDto findById(int id) {
		Optional<Employee> address = repo.findById(id);
		return address.map(mapper::toDTO).orElse(null);
	}

	public boolean save(EmployeeDto dati) {
		repo.save(mapper.toModel(dati));
		return true;
	}

	public boolean update(int id, EmployeeDto dati) {
		if (repo.existsById(id)) {
			repo.save(mapper.toModel(dati));
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
