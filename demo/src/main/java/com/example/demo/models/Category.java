package com.example.demo.models;

import jakarta.persistence.*;
import lombok.*;


/**
 * Category entity mapped by JPA
 */
@Entity
@Table(name = "categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}