package com.project.shopingapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.shopingapp.dto.ProductImageDto;
import com.project.shopingapp.dto.request.CreateProductImageRequest;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="productimage")
public class ProductImage {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private String image;

    public ProductImage(Product product, String image) {
        this.product = product;
        this.image = image;
    }
}
