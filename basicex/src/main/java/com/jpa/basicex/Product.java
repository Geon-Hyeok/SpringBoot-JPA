package com.jpa.basicex;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "JPA_PRODUCT")
public class Product {

    @Id
    @GeneratedValue
    private Long id;
    private String brand;
    private String name;
    private int price;

    @Enumerated(EnumType.STRING)
    private ProductStatus status;
    private LocalDateTime release_date;
}
