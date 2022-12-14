package com.tekup.dto.auth;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.tekup.model.AppUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private Long id;

    @NotEmpty(message = "the firstname should not be empty")
    @NotBlank(message = "the firstname should not be empty")
    @Size(min = 3, max = 20, message = "the firstname must be between 3 and 20")
    private String firstname;

    @NotEmpty(message = "the lastname should not be empty")
    @NotBlank(message = "the lastname should not be empty")
    private String lastname;

    @NotEmpty
    @NotBlank
    @Email
    private String email;

    /*@JsonProperty(access = Access.READ_ONLY)
    private boolean active;*/

    public static UserDto fromEntity(AppUser user) {
        return UserDto.builder()
                .id(user.getId())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .email(user.getEmail())
                //.active(user.isActive())
                .build();
    }

    public static AppUser toEntity(UserDto user) {
        return AppUser.builder()
                .id(user.getId())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .email(user.getEmail())
                .build();
    }

}


