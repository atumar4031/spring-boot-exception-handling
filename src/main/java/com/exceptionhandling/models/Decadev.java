package com.exceptionhandling.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class Decadev {
    @Id
    @SequenceGenerator(
            name = "decadev_sequence",
            sequenceName = "decadev_sequence",
            allocationSize = 1
    )
   @GeneratedValue(
           generator = "decadev_sequence",
           strategy = GenerationType.SEQUENCE

   )
    private Long id;
    @NotNull(message = "first name is required")
    private String firstname;
    @NotNull(message = "last name is required")
    private String lastname;
    @Email
    @NotNull(message = "email is required")
    @Valid
    private String email;
    @NotNull(message = "Stack is required")
    private String stack;
    @NotNull(message = "pod is required")
    private String pod;
    @OneToOne(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "laptop_id",referencedColumnName = "id")
    private Laptop laptop;
}
