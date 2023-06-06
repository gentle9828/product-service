package tbook.ProductService.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import tbook.ProductService.dto.ProductDto;
import tbook.ProductService.entity.Product;
import tbook.ProductService.entity.QProduct;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductFilterRepositoryImpl implements ProductFilterRepository {

    private final EntityManager em;
    private final JPAQueryFactory queryFactory;

    @Override
    public Page<Product> filterProducts(ProductDto productDto, Pageable pageable) {
        QProduct product = QProduct.product;

        BooleanBuilder builder = new BooleanBuilder();

        // productMadeBy 필터
        if (productDto.getProductMadeBy() != null && !productDto.getProductMadeBy().isEmpty()) {
            BooleanBuilder madebyBuilder = new BooleanBuilder();
            for(String madeby : productDto.getProductMadeBy()) {
                switch (madeby) {
                    case "SAMSUNG":
                        madebyBuilder.or(product.productMadeBy.contains("삼성"));
                        break;
                    case "LG":
                        madebyBuilder.or(product.productMadeBy.contains("LG"));
                        break;
                    case "RAZER":
                        madebyBuilder.or(product.productMadeBy.contains("에이서"));
                        break;
                    case "ASUS":
                        madebyBuilder.or(product.productMadeBy.contains("ASUS"));
                        break;
                    case "MSI":
                        madebyBuilder.or(product.productMadeBy.contains("MSI"));
                        break;
                    case "레노버":
                        madebyBuilder.or(product.productMadeBy.contains("레노버"));
                        break;
                }
            }
            builder.and(madebyBuilder);
        }

        // productWeight 필터
        if (productDto.getProductWeightRange() != null && !productDto.getProductWeightRange().isEmpty()) {
            BooleanBuilder weightBuilder = new BooleanBuilder();
            for (String weightRange : productDto.getProductWeightRange()) {
                switch (weightRange) {
                    case "~1kg":
                        weightBuilder.or(product.productWeight.lt(BigDecimal.ONE));
                        break;
                    case "1kg ~ 1.5kg":
                        weightBuilder.or(product.productWeight.between(BigDecimal.ONE, new BigDecimal("1.5")));
                        break;
                    case "1.5kg ~ 2kg":
                        weightBuilder.or(product.productWeight.between(new BigDecimal("1.5"), BigDecimal.valueOf(2)));
                        break;
                    case "2kg ~ 3kg":
                        weightBuilder.or(product.productWeight.between(BigDecimal.valueOf(2), BigDecimal.valueOf(3)));
                        break;
                }
            }
            builder.and(weightBuilder);
        }

        // productPrice 필터
        if (productDto.getProductPriceRange() != null && !productDto.getProductPriceRange().isEmpty()) {
            BooleanBuilder priceBuilder = new BooleanBuilder();
            for (String priceRange : productDto.getProductPriceRange()) {
                switch (priceRange) {
                    case "~40만원":
                        priceBuilder.or(product.productPrice.lt(400000));
                        break;
                    case "40 ~ 70만원":
                        priceBuilder.or(product.productPrice.between(400000, 700000));
                        break;
                    case "70 ~ 100만원":
                        priceBuilder.or(product.productPrice.between(700000, 1000000));
                        break;
                    case "100 ~ 200만원":
                        priceBuilder.or(product.productPrice.between(1000000, 2000000));
                        break;
                    case "200만원 이상":
                        priceBuilder.or(product.productPrice.gt(2000000));
                        break;
                }
            }
            builder.and(priceBuilder);
        }

        QueryResults<Product> queryResults = queryFactory
                .selectFrom(product)
                .where(builder)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetchResults();

        List<Product> products = queryResults.getResults();
        long total = queryResults.getTotal();

        return new PageImpl<>(products, pageable, total);
    }
}
