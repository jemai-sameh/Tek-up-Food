package com.tekup.dto;


import com.tekup.model.Manager;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class ManagerDto {
	private Long id;
	private String fullName;
	private Instant birthDay;
	//@Pattern(regexp="^[0-9]{10}$",message="it should be a number ")
	private String phoneNumber;
	@Email(regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])",message="it should be an email ")
	private String email;

	private String password;
	

	public static ManagerDto fromEntity(Manager manager) {
	    if (manager == null) {
	      return null;
	    }
	    return ManagerDto.builder()
	    		.id(manager.getId())
	    		.fullName(manager.getFullName())
				.email(manager.getEmail())
				.password(manager.getPassword())
	    		.phoneNumber(manager.getPhoneNumber()).build();
	  }
  public static Manager toEntity(ManagerDto managerDto) {
	    if (managerDto == null) {
	      return null;
	    }
  
	    Manager manager = new Manager();
	    manager.setId(managerDto.getId());
	    manager.setFullName(managerDto.getFullName());
	  manager.setEmail(managerDto.getEmail());

	  manager.setPassword(managerDto.getPassword());
	    manager.setPhoneNumber(managerDto.getPhoneNumber());
    return manager;
  }

	public static List<ManagerDto> fromListEntity(List<Manager> list) {
		return list.stream().map(x -> fromEntity(x)).collect(Collectors.toList());
	}
}
