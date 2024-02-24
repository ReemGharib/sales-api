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
public class ClientDto {

    private Long id;

    private String name;

    private String lastName;

    private String mobile;
}
