package com.tekup.dto;

import com.tekup.model.Plat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class LabelValueDto {
    private Long value;
    private String label;
    private double prix;
    public static LabelValueDto fromEntity(Plat plat) {
        return LabelValueDto.builder()
                .value(plat.getId())
                .label(plat.getPlatName())
                .prix(plat.getPlatPrix())
                .build();
    }
}
