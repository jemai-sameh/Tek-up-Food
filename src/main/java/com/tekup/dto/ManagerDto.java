package com.tekup.dto;

import javax.validation.constraints.Pattern;

import com.tekup.model.Manager;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ManagerDto {
	private Long managerID;	
	private String firstName;
	private String lastName;
	@Pattern(regexp="^[0-9]{10}$",message="it should be a number ")
	private String phoneNumber;
	private String passwd;
	
	
	public static ManagerDto fromEntity(Manager manager) {
	    if (manager == null) {
	      return null;
	    }

	    return ManagerDto.builder()
	    		.managerID(manager.getManagerID())
	    		.firstName(manager.getFirstName())
	    		.lastName(manager.getLastName())
	    		.passwd(manager.getPasswd())
	    		.phoneNumber(manager.getPhoneNumber()).build();
	  }
  public static Manager toEntity(ManagerDto managerDto) {
	    if (managerDto == null) {
	      return null;
	    }
  
	    Manager manager = new Manager();
	    
	    manager.setManagerID(manager.getManagerID());
	    manager.setFirstName(manager.getFirstName());
	    manager.setLastName(manager.getLastName());
	    manager.setPasswd(manager.getPasswd());
	    manager.setPhoneNumber(manager.getPhoneNumber());
    return manager;
  }


}
