package it.aips.aaBootJpaHibernate.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table (name="address") //necessaria perche i nomi tabella e campo NON coincidono
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "lane1") //non necessaria perche i nomi dei campi della tabella e campo classe coincidono
	private String lane1; 
	private String lane2; 
	private String state;
	private String zip;
    @OneToMany(mappedBy = "address", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Employee> employees = new ArrayList<>(); 
 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLane1() {
		return lane1;
	}
	public void setLane1(String lane1) {
		this.lane1 = lane1;
	}
	public String getLane2() {
		return lane2;
	}
	public void setLane2(String lane2) {
		this.lane2 = lane2;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	} 
	
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
}
