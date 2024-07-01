package com.example.zhbe.models;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryModel {
    private Integer id;

    @NotBlank
    private String name;

    @NotBlank
    private String description;

}
