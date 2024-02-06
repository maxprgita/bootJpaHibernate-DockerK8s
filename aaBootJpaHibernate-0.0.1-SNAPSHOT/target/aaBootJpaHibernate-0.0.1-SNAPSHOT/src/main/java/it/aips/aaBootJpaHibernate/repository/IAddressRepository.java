package it.aips.aaBootJpaHibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import it.aips.aaBootJpaHibernate.model.Address;

public interface IAddressRepository extends JpaRepository<Address, Integer> {

}
