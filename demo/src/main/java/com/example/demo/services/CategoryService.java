package com.example.demo.services;

import com.example.demo.dto.CategoryDTO;
import com.example.demo.dto.CategoryUpdateDTO;
import com.example.demo.models.Category;
import com.example.demo.repositories.CategoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAll() { return categoryRepository.findAll(); }

    public Optional<Category> findById(Long id) { return categoryRepository.findById(id); }

    @Transactional
    public Category save(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setName(categoryDTO.getName());
        return categoryRepository.save(category);
    }

    /**
     * Save function override to update category
     * @Params CategoryUpdateDTO category data to update
     * @Return updated category
     */
    @Transactional
    public Category save(CategoryUpdateDTO categoryDTO) {
        if(!categoryRepository.existsById(categoryDTO.getId())){
            throw new RuntimeException("Category not found");
        }

        Category category = Category.builder()
                .id(categoryDTO.getId())
                .name(categoryDTO.getName())
                .build();
        return categoryRepository.save(category);
    }

    public void deleteById(Long id) {
        if (!categoryRepository.existsById(id)) {
            throw new RuntimeException("Post not found");
        }
        categoryRepository.deleteById(id);
    }
}