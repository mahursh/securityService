package com.mftplus.secondsecurityservice.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mftplus.secondsecurityservice.base.Base;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder

@Entity(name = "userEntity")
@Table(name = "user_tbl")
public class User extends Base {

    @Id
    @SequenceGenerator(name = "userSeq", sequenceName = "user_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userSeq")
    @Column(name = "user_id")
    private Long id;

    @Column(name = "user_user_name",  columnDefinition = "VARCHAR2(30)", unique = true)
    @Pattern(regexp = "^[a-zA-Z1-9\\s]{3,30}$", message = "Invalid Username")
    @Size(min = 3, max = 30, message = "Username must be between 3 and 30 characters")
    @NotBlank(message = "Should Not Be Null")
    private String username;

    @Column(name = "user_password", columnDefinition = "VARCHAR2(30)")
    @Pattern(regexp = "^[a-zA-Z1-9\\s]{8,30}$", message = "Invalid Password")
    @Size(min = 8, max = 30, message = "Password must be between 8 and 30 characters")
    @NotBlank(message = "Should Not Be Null")
//    @JsonIgnore
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Column(name = "user_email", columnDefinition = "VARCHAR2(30)")
    @Email(message = "Email Is Not Valid !")
    @NotBlank(message = "Should Not Be Null")
    private String email;

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER , mappedBy = "user")
//    private Set<Role> roleSet = new HashSet<>() ;

    @Column(name = "user_status")
    private boolean status = true;
}
