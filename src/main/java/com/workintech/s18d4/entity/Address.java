package com.workintech.s18d4.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "address", schema = "public")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private long id;
    @Column(name = "city")
    private String city;
    @Column
    private String country;
    @Column
    private String description;
    @Column
    private String street;
    @Column
    private Integer no;

    @OneToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST},mappedBy = "address")
    private Customer customer;
}
