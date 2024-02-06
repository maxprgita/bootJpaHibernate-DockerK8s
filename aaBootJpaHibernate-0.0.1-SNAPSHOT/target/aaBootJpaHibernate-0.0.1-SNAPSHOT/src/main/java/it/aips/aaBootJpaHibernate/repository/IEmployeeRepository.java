package it.aips.aaBootJpaHibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import it.aips.aaBootJpaHibernate.model.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

}
