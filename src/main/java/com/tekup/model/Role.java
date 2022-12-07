package com.tekup.model;


import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Role {
    @Id
    private Long id;
    @Enumerated(EnumType.STRING)
    private Erole role;

    @OneToMany(mappedBy = "role" ,fetch= FetchType.LAZY)
    private Set<AppUser> users;
}

