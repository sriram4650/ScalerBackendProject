package com.scaler.productservice.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;
@Getter
@Setter
@MappedSuperclass
public class basemodel {
    @Id //PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Auto increment
    private Long id;
    private Date createdAt;
    private Date updatedAt;

}
