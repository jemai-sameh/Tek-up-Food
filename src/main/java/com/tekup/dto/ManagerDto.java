package com.tekup.dto;


import com.tekup.model.Manager;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class ManagerDto {
	private Long id;
	private String firstName;
	private String lastName;
	//@Pattern(regexp="^[0-9]{10}$",message="it should be a number ")
	private String phoneNumber;
	@Email(regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])",message="it should be an email ")
	private String mail;

	private String passwd;
	
	
	public static ManagerDto fromEntity(Manager manager) {
	    if (manager == null) {
	      return null;
	    }
	    return ManagerDto.builder()
	    		.id(manager.getId())
	    		.firstName(manager.getFirstName())
	    		.lastName(manager.getLastName())
				.mail(manager.getMail())
				.passwd(manager.getPasswd())
	    		.phoneNumber(manager.getPhoneNumber()).build();
	  }
  public static Manager toEntity(ManagerDto managerDto) {
	    if (managerDto == null) {
	      return null;
	    }
  
	    Manager manager = new Manager();
	    manager.setId(managerDto.getId());
	    manager.setFirstName(managerDto.getFirstName());
	    manager.setLastName(managerDto.getLastName());
	  manager.setMail(managerDto.getMail());
	  manager.setPasswd(managerDto.getPasswd());
	    manager.setPhoneNumber(managerDto.getPhoneNumber());
    return manager;
  }

	public static List<ManagerDto> fromListEntity(List<Manager> list) {
		return list.stream().map(x -> fromEntity(x)).collect(Collectors.toList());
	}
}
