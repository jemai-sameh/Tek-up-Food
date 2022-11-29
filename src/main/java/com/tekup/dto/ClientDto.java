package com.tekup.dto;




import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.Email;

import com.tekup.model.Client;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientDto {
	private Long clientID;
	
	private String firstName;
	private String lastName;
	
	//@Pattern(regexp="^[0-9]{10}$",message="it should be a number ")
	private String phoneNumber;
	private String passwd;
    
	@Email(regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])",message="it should be an email ")
	private String mail;
	
	
	  public static ClientDto fromEntity(Client client) {
		    if (client == null) {
		      return null;
		    }

		    return ClientDto.builder()
		    	.clientID(client.getClientID())
		        .firstName(client.getFirstName())
		        .lastName(client.getLastName())
		        .phoneNumber(client.getPhoneNumber())
		        .passwd(client.getPasswd())
		        .mail(client.getMail())
		        .build();
		  }
	  public static Client toEntity(ClientDto clientDto) {
		    if (clientDto == null) {
		      return null;
		    }
	  
	  Client client = new Client();
	  client.setClientID(clientDto.getClientID());
	  client.setFirstName(clientDto.getFirstName());
	  client.setLastName(clientDto.getLastName());
	  client.setPhoneNumber(clientDto.getPhoneNumber());
	  client.setMail(clientDto.getMail());
	  client.setPasswd(clientDto.getPasswd());
	    return client;
	  }

	  public static List<ClientDto> fromListEntity(List<Client> clients) {
			return clients.stream().map(x -> fromEntity(x)).collect(Collectors.toList());
			}
}
