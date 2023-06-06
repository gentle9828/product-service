package tbook.ProductService.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import tbook.ProductService.dto.ProductDto;
import tbook.ProductService.entity.Product;

public interface ProductFilterRepository {
    Page<Product> filterProducts (ProductDto productDto, Pageable pageable);
}
