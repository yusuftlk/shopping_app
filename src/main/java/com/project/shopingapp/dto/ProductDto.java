package com.project.shopingapp.dto;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class ProductDto {
    private Long id;
    private CategoryDto category;
    private String productCode;
    private String name;
    private Float price;
    private String description;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private LocalDateTime creationDate;
    private Boolean status;
}
