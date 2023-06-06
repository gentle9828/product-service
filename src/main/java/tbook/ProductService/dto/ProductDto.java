package tbook.ProductService.dto;

import lombok.Data;

import java.util.List;

@Data
public class ProductDto {
    private List<String> productMadeBy;
    private List<String> productWeightRange;
    private List<String> productPriceRange;
}
