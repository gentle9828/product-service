package tbook.ProductService.service;

import tbook.ProductService.entity.Product;
import tbook.ProductService.vo.ResponseProduct;
import tbook.ProductService.vo.simpleResponseProduct;

import java.util.List;

public interface ProductService {
    List<ResponseProduct> getAllProducts();
    List<simpleResponseProduct> getProducts();
}
