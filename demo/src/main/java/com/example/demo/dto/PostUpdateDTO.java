package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostUpdateDTO {
    private Long id;
    private String title;
    private String content;
    private List<Long> tagIds;
    private List<Long> categoryIds;
}
