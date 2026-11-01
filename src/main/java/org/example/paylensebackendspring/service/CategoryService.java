package org.example.paylensebackendspring.service;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.example.paylensebackendspring.dto.CategoryResponse;
import org.example.paylensebackendspring.repository.CategoryRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    public List<CategoryResponse> listActive() {
        return categoryRepository.findByActiveTrue().stream()
                .map(CategoryResponse::from)
                .toList();
    }
}
