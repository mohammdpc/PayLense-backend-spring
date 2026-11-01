package org.example.paylensebackendspring.dto;

import org.example.paylensebackendspring.entity.Category;

public record CategoryResponse(
        Integer id,
        String categoryName,
        String description,
        String iconName
) {
    public static CategoryResponse from(Category e) {
        return new CategoryResponse(
                e.getId(),
                e.getCategoryName(),
                e.getDescription(),
                e.getIconName()
        );
    }
}
