package com.tekup.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.tekup.model.Plat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class PlatDto {

	private Long id;
	private String platName;
	private BigDecimal platPrix;
	private String platType;
	private String description;
	private String image;
	
	private ManagerDto manager;
	public static PlatDto fromEntity(Plat plat) {
	    if (plat == null) {
	      return null;
	    }

	    return PlatDto.builder()
	    		.id(plat.getId())
	    		.description(plat.getDescription())
	    		.image(plat.getImage())
	    		.platName(plat.getPlatName())
	    		.platPrix(plat.getPlatPrix())
	    		.platType(plat.getPlatType())
	    		.manager(ManagerDto.fromEntity(plat.getManager()))
	    		.build();
	  }
  public static Plat toEntity(PlatDto platDto) {
	    if (platDto == null) {
	      return null;
	    }
  
	    Plat plat = new Plat();
	    
	    plat.setId(platDto.getId());
	    plat.setDescription(platDto.getDescription());
	    plat.setImage(platDto.getImage());
	    plat.setPlatName(platDto.getPlatName());
	    plat.setPlatPrix(platDto.getPlatPrix());
	    plat.setPlatType(platDto.getPlatType());
	    plat.setManager(ManagerDto.toEntity(platDto.getManager()));
    return plat;
  }
	public static List<PlatDto> fromListEntity(List<Plat> list) {
		return list.stream().map(x -> fromEntity(x)).collect(Collectors.toList());
	}
	public static Set<Plat> fromListDtoEntity(Set<PlatDto> list) {
		return list.stream().map(x -> toEntity(x)).collect(Collectors.toSet());
	}

}
