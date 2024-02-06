package it.aips.aaBootJpaHibernate.controllers;

import java.util.Collections;
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

import it.aips.aaBootJpaHibernate.DTO.AddressDto;
import it.aips.aaBootJpaHibernate.DTO.EmployeeDto;
import it.aips.aaBootJpaHibernate.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {
	
	private enum MsgStati {
	    OP_OK("Operazione eseguita correttamente"),
	    OP_KO("Operazione non eseguita per problema"),
	    ERR_IND("Errore durante il recupero degli indirizzi."),
	    NO_IND("Nessun indirizzo trovato.");

	    private final String messagio;

	    MsgStati(String messagio) {
	        this.messagio = messagio;
	    }

	    public String getMessage() {
	        return messagio;
	    }
	}


	@Autowired
	AddressService addressService;
	
    @GetMapping("/{addressId}/employees")
    public ResponseEntity<List<?>> getEmployeesByAddressId(@PathVariable Integer addressId) { 
    	List<EmployeeDto> result= addressService.getEmployeesByAddressId(addressId);
		   if (result != null && !result.isEmpty()) {
		        return ResponseEntity.ok(result);
		    } else {
		        String message = (result == null) ? MsgStati.ERR_IND.getMessage() : MsgStati.NO_IND.getMessage();
		        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonList(message));
		    }
    }
	
	@GetMapping("/getid/{id}")
	public ResponseEntity<AddressDto> getAddressById(@PathVariable("id") int id) {
		AddressDto result=addressService.findById(id);
		return (result != null) ? ResponseEntity.ok(result) : ResponseEntity.notFound().build();
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<?>> getAllAddresses(){
		List<AddressDto> result= addressService.findAll();
		   if (result != null && !result.isEmpty()) {
		        return ResponseEntity.ok(result);
		    } else {
		    	String message = (result == null) ? MsgStati.ERR_IND.getMessage() : MsgStati.NO_IND.getMessage();
		        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonList(message));
		    }
	}
	
	@PostMapping("/post")
	public ResponseEntity<String> createAddress( @RequestBody AddressDto dati){
		boolean result=addressService.save(dati);
		return rispostaTestBooleano(result);
	}
	
    @PutMapping("/put/{id}")
    public ResponseEntity<String> updateAddress(@PathVariable int id, @RequestBody AddressDto dati) {
    	boolean result=addressService.update(id, dati);
    	return rispostaTestBooleano(result);
    }
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteAddress(@PathVariable("id") int id) {
		boolean result=addressService.delete(id);
		return rispostaTestBooleano(result);
	}
	
	private ResponseEntity<String> rispostaTestBooleano(boolean test){
		return (test) ? ResponseEntity.ok().body(MsgStati.OP_OK.getMessage()) 
					  : ResponseEntity.status(HttpStatus.NOT_FOUND).body(MsgStati.OP_KO.getMessage()); 
	}
	
}
