package com.sales.sales.dto;

import lombok.*;

import java.time.LocalDate;

/**
 * @author Reem Gh.
 */
@Data
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    private Long id;

    private String name;

    private String description;

    private String category;

    private LocalDate creationDate;
}
