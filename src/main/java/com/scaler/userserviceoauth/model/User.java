package com.scaler.userserviceoauth.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "users")
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseModel{

    private String name;
    private String email;
    private String hashedPassword;
    private String phone;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> role;
    private boolean enabled;
    private boolean isEmailVerified;
}
