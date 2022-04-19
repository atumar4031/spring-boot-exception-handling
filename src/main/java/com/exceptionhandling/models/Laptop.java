package com.exceptionhandling.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Laptop {
    @Id
    @SequenceGenerator(
            name = "laptop_sequence",
            sequenceName = "laptop_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE
    )
    private Long id;
    private String title;
    @ManyToOne(cascade = CascadeType.ALL,
    fetch = FetchType.EAGER)
    @JoinColumn(
            name = "detail_id",
            referencedColumnName = "id"
    )
    private LaptopDetail laptopDetail;
    @OneToOne(cascade = CascadeType.MERGE,
            fetch = FetchType.EAGER)
    @JoinColumn(name = "decadev_id", referencedColumnName = "id")
    private Decadev decadev;
}
