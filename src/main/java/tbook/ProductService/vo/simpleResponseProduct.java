package tbook.ProductService.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class simpleResponseProduct {
    private String productImage;
    private String productName;
}
