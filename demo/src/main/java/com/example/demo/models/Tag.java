package com.example.demo.models;

import jakarta.persistence.*;
import lombok.*;


/**
 * Tag entity mapped by JPA
 */
@Entity
@Table(name = "tags")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
