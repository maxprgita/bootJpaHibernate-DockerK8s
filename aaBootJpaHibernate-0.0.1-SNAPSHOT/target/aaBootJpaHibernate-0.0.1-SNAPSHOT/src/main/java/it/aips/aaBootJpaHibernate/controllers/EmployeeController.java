package it.aips.aaBootJpaHibernate.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.aips.aaBootJpaHibernate.DTO.EmployeeDto;
import it.aips.aaBootJpaHibernate.service.EmployeeService;

						//===============VEDI NOTA=================
@RestController
@RequestMapping("/employee")
public class EmployeeController {

	private final String OP_OK="Operazione eseguita correttamente";
	private final String OP_KO="Operazione non eseguita per problema";
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/getid/{id}")
	public ResponseEntity<EmployeeDto> getAddressById(@PathVariable("id") int id) {
		EmployeeDto result=employeeService.findById(id);
		return (result != null) ? ResponseEntity.ok(result) : ResponseEntity.notFound().build();
	}
	
	@GetMapping("/get")
	public List<EmployeeDto> getAllAddresses(){
		return employeeService.findAll();
	}
	
	@PostMapping("/post")
	public ResponseEntity<String> createAddress( @RequestBody EmployeeDto dati){
		boolean result=employeeService.save(dati);
		return rispostaTestBooleano(result);
	}
	
    @PutMapping("/put/{id}")
    public ResponseEntity<String> updateAddress(@PathVariable int id, @RequestBody EmployeeDto dati) {
    	boolean result=employeeService.update(id, dati);
    	return rispostaTestBooleano(result);
    }
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteAddress(@PathVariable("id") int id) {
		boolean result=employeeService.delete(id);
		return rispostaTestBooleano(result);
	}
	
	private ResponseEntity<String> rispostaTestBooleano(boolean test){
		return (test) ? ResponseEntity.ok().body(OP_OK) : ResponseEntity.status(HttpStatus.NOT_FOUND).body(OP_KO); 
	}
	
}
