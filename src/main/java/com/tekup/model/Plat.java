package com.tekup.model;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Plat  extends AbstractEntity{


	private String platName;
	private double platPrix;
	private String platType;
	private String description;
	private String image;
	
	@ManyToMany (mappedBy = "plats" ,fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<Commande> orders;

	
	@ManyToOne
	private Manager manager;


	/*public void addOrder(Commande entity ) {
		if (this.orders==null ) {this.orders = new HashSet<Commande>();}
		this.orders.add(entity);
		if ( entity.getPlats()==null ) {entity.setPlats(new HashSet<Plat>());}
		entity.getPlats().add(this);
	}*/
}

