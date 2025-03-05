package com.example.demo.dto;

import lombok.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {
    private String title;
    private String content;
    private Long authorId;
    private List<Long> tagIds;
    private List<Long> categoryIds;
}
