package com.example.demo.controllers;

import com.example.demo.dto.CategoryDTO;
import com.example.demo.models.Category;
import com.example.demo.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controller for managing Categories.
 */
@RestController
@RequestMapping("/categories")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    /**
     * Retrieve all categories.
     * @return List of all categories.
     */
    @GetMapping
    public List<Category> getAllCategories() { return categoryService.findAll(); }

    /**
     * Retrieve a category by ID.
     * @param id Category ID.
     * @return Category details if found.
     */
    @GetMapping("/{id}")
    public Optional<Category> getCategoryById(@PathVariable Long id) { return categoryService.findById(id); }

    /**
     * Create a new category.
     * @param category Category object.
     * @return The created category.
     */
    @PostMapping
    public Category createCategory(@RequestBody CategoryDTO category) { return categoryService.save(category); }

    /**
     * Delete a category by ID.
     * @param id Category ID.
     */
    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) { categoryService.deleteById(id); }
}
