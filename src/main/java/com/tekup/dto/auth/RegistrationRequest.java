package com.tekup.dto.auth;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.tekup.model.AppUser;
import com.tekup.model.Manager;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegistrationRequest {

    @NotEmpty(message = "the firstname should not be empty")
    @NotBlank(message = "the firstname should not be empty")
    @Size(min = 3, max = 20, message = "the firstname must be between 3 and 20")
    private String fullName;




    @NotEmpty
    @NotBlank
    private String phoneNumber;

    @NotEmpty
    @NotBlank
    @Email
    private String email;

    @NotEmpty
    @NotBlank
    private String password;





    public static AppUser toEntity(RegistrationRequest request) {
        return AppUser.builder()
                .fullName(request.getFullName())
                .phoneNumber(request.getPhoneNumber())
                .email(request.getEmail())
                .password(request.getPassword())
                .build();
    }
    public static Manager toEntityManager(RegistrationRequest request) {
        return Manager.builder()
                .fullName(request.getFullName())
                .phoneNumber(request.getPhoneNumber())
                .email(request.getEmail())
                .password(request.getPassword())
                .build();
    }

}

