package com.tekup.dto;


import com.tekup.model.Manager;

import lombok.Builder;
import lombok.Data;

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
	private String passwd;
	
	
	public static ManagerDto fromEntity(Manager manager) {
	    if (manager == null) {
	      return null;
	    }
	    return ManagerDto.builder()
	    		.id(manager.getId())
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
	    manager.setId(managerDto.getId());
	    manager.setFirstName(managerDto.getFirstName());
	    manager.setLastName(managerDto.getLastName());
	    manager.setPasswd(managerDto.getPasswd());
	    manager.setPhoneNumber(managerDto.getPhoneNumber());
    return manager;
  }

	public static List<ManagerDto> fromListEntity(List<Manager> list) {
		return list.stream().map(x -> fromEntity(x)).collect(Collectors.toList());
	}
}
