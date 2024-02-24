package com.sales.sales.dto;

import lombok.*;

/**
 * @author Reem Gh.
 */
@Data
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {

    private String code;
    private String description;
    private String reason;
}
