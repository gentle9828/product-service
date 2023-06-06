package tbook.ProductService.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import tbook.ProductService.entity.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
