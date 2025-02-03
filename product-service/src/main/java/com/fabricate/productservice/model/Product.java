package com.fabricate.productservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name ="name", schema ="product-service")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {


    @Id
    private String productId;
    private String productName;
    private String productDescription;
    private String productPrice;
    
}
