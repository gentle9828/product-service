package tbook.ProductService.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

import javax.persistence.Column;
import java.math.BigDecimal;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseProduct {
    private String productImage;
    private String productName;
    private String productMadeBy;
    private String productCpu;
    private int productRamCapacity;
    private String productRamDetail;
    private int productStorageCapacity;
    private String productStorageDetail;
    private String productDisplaySize;
    private String productDisplayDetail;
    private BigDecimal productBattery;
    private String productGraphic;
    private BigDecimal productWeight;
    private int productPrice;
    private int stock;
}

//    @QueryProjection
//    public ResponseProduct(String productImage, String productName, String productMadeBy, String productCpu, int productRamCapacity, String productRamDetail, int productStorageCapacity, String productStorageDetail, String productDisplaySize, String productDisplayDetail, BigDecimal productBattery, String productGraphic, BigDecimal productWeight, int productPrice, int stock) {
//        this.productImage = productImage;
//        this.productName = productName;
//        this.productMadeBy = productMadeBy;
//        this.productCpu = productCpu;
//        this.productRamCapacity = productRamCapacity;
//        this.productRamDetail = productRamDetail;
//        this.productStorageCapacity = productStorageCapacity;
//        this.productStorageDetail = productStorageDetail;
//        this.productDisplaySize = productDisplaySize;
//        this.productDisplayDetail = productDisplayDetail;
//        this.productBattery = productBattery;
//        this.productGraphic = productGraphic;
//        this.productWeight = productWeight;
//        this.productPrice = productPrice;
//        this.stock = stock;
//    }

