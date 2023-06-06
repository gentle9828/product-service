package tbook.ProductService.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import tbook.ProductService.entity.Product;
import tbook.ProductService.repository.ProductRepository;
import tbook.ProductService.vo.ResponseProduct;
import tbook.ProductService.vo.simpleResponseProduct;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public List<ResponseProduct> getAllProducts() {
        List<Product> products = productRepository.findAll();
        ModelMapper modelMapper = new ModelMapper();

        List<ResponseProduct> findProduct = new ArrayList<>();
        products.forEach(v -> findProduct.add(modelMapper.map(v, ResponseProduct.class)));
        return findProduct;
    }



    @Override
    public List<simpleResponseProduct> getProducts() {
        List<Product> products = productRepository.findAll();
        ModelMapper modelMapper = new ModelMapper();

        List<simpleResponseProduct> findProduct = new ArrayList<>();
        products.forEach(v -> findProduct.add(modelMapper.map(v, simpleResponseProduct.class)));
        return findProduct;
    }


//    @Override
//    public Product getByProductId(Long Id) {
//        Optional<Product> findProduct = productRepository.findById(Id);
//
////        if(findProduct == null ) {
////            throw new ProductNotFoundException("해당 상품은 존재하지 않습니다.");
////        }
//
//        ModelMapper modelMapper = new ModelMapper();
//
//        Product responseProduct = modelMapper.map(findProduct, Product.class);
//        return responseProduct;
//    }
}
