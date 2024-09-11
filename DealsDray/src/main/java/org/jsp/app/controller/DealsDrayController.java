package org.jsp.app.controller;

import org.jsp.app.entity.DealsDary;
import org.jsp.app.exception.InvalidCredentials;
import org.jsp.app.serviceinterface.DealsDaryServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/DealsDray")
public class DealsDrayController {
	@Autowired
	private DealsDaryServiceInterface ddserviceinterface;
	@GetMapping("/DealsDray")
	public ResponseEntity<?> getAllDealsDetails(){
		return ddserviceinterface.allDetailsService();
	}
	@GetMapping("/DealsDray/{phn}")
	public ResponseEntity<?> dealsGetMethodPhone(@PathVariable long phn){
		return ddserviceinterface.findDealsByPhone(phn);
	}
	@PostMapping("/DealsDray")
	public ResponseEntity<?> dealsPostMethod(@RequestBody DealsDary dd){
		return ddserviceinterface.saveUser(dd);
	}
	@DeleteMapping("/DealsDray/{id}")
	public ResponseEntity<?> dealsDeleteById(@PathVariable int id){
		return ddserviceinterface.deleteDealService(id);
	}
}
