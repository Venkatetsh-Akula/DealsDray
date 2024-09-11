package org.jsp.app.serviceinterface;

import org.jsp.app.entity.DealsDary;
import org.springframework.http.ResponseEntity;

public interface DealsDaryServiceInterface {

	ResponseEntity<?> saveUser(DealsDary dd);

	ResponseEntity<?> findDealsByPhone(long phn);

	ResponseEntity<?> allDetailsService();

	ResponseEntity<?> deleteDealService(int id);

}
