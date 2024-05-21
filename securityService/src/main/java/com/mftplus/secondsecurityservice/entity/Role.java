package com.mftplus.secondsecurityservice.entity;

import com.mftplus.secondsecurityservice.base.Base;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity(name = "roleEntity")
@Table(name = "role_tbl" )
public class Role extends Base {

    @Id
    @SequenceGenerator(name = "roleSeq", sequenceName = "role_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roleSeq")
    @Column(name = "role_id")
    private Long id;

    @Column(name = "role_name",  columnDefinition = "NVARCHAR2(50)")
    @Pattern(regexp = "^[a-zA-Zآ-ی\\s]{3,50}$", message = "Invalid Role Name")
    @Size(min = 3, max = 50, message = "Role Name must be between 3 and 50 characters")
    @NotBlank(message = "Should Not Be Null")
    private String roleName; //TODO: Make it enum .

    @ManyToOne(cascade = CascadeType.ALL , fetch = FetchType.LAZY )
    @JoinColumn(name = "role_user_id")
    private User user ;
}
