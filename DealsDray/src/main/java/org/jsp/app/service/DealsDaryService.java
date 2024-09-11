package org.jsp.app.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;


import org.jsp.app.config.TwilioConfig;
import org.jsp.app.daointerface.DealsDaryDaoInterface;
import org.jsp.app.entity.DealsDary;
import org.jsp.app.exception.InvalidCredentials;
import org.jsp.app.exception.InvalidPhoneNumber;
import org.jsp.app.exception.NoDealFoundException;
import org.jsp.app.responsestructure.ResponseStructure;
import org.jsp.app.serviceinterface.DealsDaryServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DealsDaryService implements DealsDaryServiceInterface{
	
	@Autowired
	private DealsDaryDaoInterface dddaointerface;
	
	@Override
	public ResponseEntity<?> allDetailsService() {
		List<DealsDary> alldeals=dddaointerface.findAllDealsDao();
		if(alldeals.size()>0) {
			return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().httpcode(HttpStatus.OK.value())
					.message("All Users in Deals").body(alldeals).build());
		}else {
			return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().httpcode(HttpStatus.OK.value())
					.message("No Users Found").body(alldeals).build());
		}
	}
	
	
	@Override
	public ResponseEntity<?> saveUser(DealsDary dd) {
		DealsDary deal=dddaointerface.saveDao(dd);
		if(dd!=null || dd.getEmail()!=null ||dd.getPhone()>0) {
			return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().httpcode(HttpStatus.OK.value())
					.message("Login Created").body(deal).build());
		}
		else {
			throw InvalidCredentials.builder().message("Invalid Data").build();
		}
	}
	
	
	@Override
	public ResponseEntity<?> findDealsByPhone(long phn) {
		Optional<DealsDary> deal=dddaointerface.findByPhone(phn);
		if(deal.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().httpcode(HttpStatus.OK.value())
					.message("Details Found").body(deal.get()).build());
		}else {
			throw InvalidPhoneNumber.builder().message("No Phone Number found").build();
		}
	}


	@Override
	public ResponseEntity<?> deleteDealService(int id) {
		Optional<DealsDary> deal=dddaointerface.findDealByIDDao(id);
		if(deal.isPresent()) {
			dddaointerface.deleteDealByIdDao(id);
			return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().httpcode(HttpStatus.OK.value())
					.message("Deal Deleted").body(deal.get()).build());
		}
		else {
			throw NoDealFoundException.builder().message("No such Deal Found").build();
		}
	}
	
	
//	 @Autowired
//	    private TwilioConfig twilioConfig;
//
//	    private Map<Long, String> otpStorage = new HashMap<>(); // To store OTP temporarily
//
//	    // Generate a 6-digit OTP
//	    private String generateOtp() {
//	        Random random = new Random();
//	        int otp = 100000 + random.nextInt(900000); // Generates OTP between 100000 and 999999
//	        return String.valueOf(otp);
//	    }
//
//	    // Send OTP via Twilio
//	    private void sendOtp(long phone, String otp) {
//	        String phoneWithCountryCode = "+91" + phone; // Assuming you're sending to India. Change the country code as needed.
//	        Message.creator(
//	                new PhoneNumber(phoneWithCountryCode),
//	                new PhoneNumber(twilioConfig.getTwilioPhoneNumber()), 
//	                "Your OTP for DealsDray is: " + otp
//	        ).create();
//	    }
//
//	    @Override
//	    public ResponseEntity<?> findDealsByPhone(long phn) {
//	        Optional<DealsDary> deal = dddaointerface.findByPhone(phn);
//	        if (deal.isPresent()) {
//	            String otp = generateOtp();
//	            otpStorage.put(phn, otp); // Store OTP against phone number
//	            sendOtp(phn, otp); // Send OTP to phone number
//
//	            return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().httpcode(HttpStatus.OK.value())
//	                    .message("OTP sent to your phone").body("OTP sent").build());
//	        } else {
//	            throw InvalidPhoneNumber.builder().message("No Phone Number found").build();
//	        }
//	    }

	    // New method to validate OTP
//	    public ResponseEntity<?> validateOtp(long phn, String otp) {
//	        if (otpStorage.containsKey(phn) && otpStorage.get(phn).equals(otp)) {
//	            otpStorage.remove(phn); // OTP validated, remove it
//	            return ResponseEntity.status(HttpStatus.OK).body("OTP validation successful!");
//	        } else {
//	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid OTP!");
//	        }
//	    }
}
