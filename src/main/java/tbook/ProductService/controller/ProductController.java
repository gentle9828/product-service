package tbook.ProductService.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tbook.ProductService.dto.ProductDto;
import tbook.ProductService.entity.Product;
import tbook.ProductService.repository.ProductFilterRepository;
import tbook.ProductService.service.ProductService;
import tbook.ProductService.vo.ResponseProduct;
import tbook.ProductService.vo.simpleResponseProduct;

import java.util.List;

@RestController
@RequestMapping("/product-service")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final ProductFilterRepository productFilterRepository;

    @GetMapping("/products")
    public ResponseEntity<List<ResponseProduct>> findAllProducts() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productService.getAllProducts());
    }

//    @GetMapping("/products/{Id}")
//    public ResponseEntity<Product> findProductByProductName(@PathVariable("Id") Long Id) {
//        return ResponseEntity.status(HttpStatus.OK).body(productService.getByProductId(Id));
//    }

    @GetMapping("/products/simple")
    public ResponseEntity<List<simpleResponseProduct>> findProducts() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productService.getProducts());
    }

//    @GetMapping("/products_filter")
//    public ResponseEntity<List<Product>> filter(
//            @RequestParam(required = false) List<String> productMadeBy,
//            @RequestParam(required = false) List<String> productWeightRange,
//            @RequestParam(required = false) List<String> productPriceRange) {
//
//        ProductDto productDTO = new ProductDto();
//        productDTO.setProductMadeBy(productMadeBy);
//        productDTO.setProductWeightRange(productWeightRange);
//        productDTO.setProductPriceRange(productPriceRange);
//
//        return ResponseEntity
//                .status(HttpStatus.OK)
//                .body(productFilterRepository.filterProducts(productDTO));
//    }

    @GetMapping("/products/filter")
    public Page<Product> filterProducts(@ModelAttribute ProductDto productDto, Pageable pageable) {
        return productFilterRepository.filterProducts(productDto, pageable);
    }

}
