package com.bsuir.trtpo.backend.service.serviceImpl;

import com.bsuir.trtpo.backend.entity.Product;
import com.bsuir.trtpo.backend.repository.ProductRepository;
import com.bsuir.trtpo.backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Optional<Product> getProductByName(String name) {
        return productRepository.findProductByName(name);
    }

    @Override
    public List<Product> findProducts(String query, String sort, String order) {
        List<Product> allProducts = new ArrayList<>(productRepository.findAllByPriceIsNotNullAndAmountIsGreaterThan(0));
        List<Product> validProducts = findProducts(query, allProducts);
        validProducts = sortProducts(createComparatorForSort(sort,order),validProducts);
        return validProducts;
    }

    @Override
    public List<Product> findProducts(String query, List<Product> validProducts) {
        return null;
    }

    @Override
    public Product getProductById(Integer id) {
        return productRepository.findProductById(id);
    }

    private List<Product> sortProducts(
        Comparator<Product> productComparator, List<Product> products) {
            Objects.requireNonNull(products, "Collection should not be null");

            if (productComparator != null) {
                products = products
                        .stream()
                        .sorted(productComparator)
                        .collect(Collectors.toList());
            }
            return products;
    }

    private Comparator<Product> createComparatorForSort(String sort, String order) {
        Comparator<Product> productComparator = null;
        if (sort != null && !sort.trim().isEmpty() && order != null && !order.trim().isEmpty()) {
            if ("description".equalsIgnoreCase(sort)) {
                productComparator = "asc".equalsIgnoreCase(order)

                        ? Comparator.comparing(Product::getDescription)
                        : Comparator.comparing(Product::getDescription).reversed();
            } else if ("price".equalsIgnoreCase(sort)) {
                productComparator = "asc".equalsIgnoreCase(order)
                        ? Comparator.comparing(Product::getPrice)
                        : Comparator.comparing(Product::getPrice).reversed();
            }
        }
        return productComparator;
    }
}
