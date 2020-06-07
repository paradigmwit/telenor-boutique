package com.telenor.boutique.controller;

import com.telenor.boutique.config.Constants;
import com.telenor.boutique.dto.Data;
import com.telenor.boutique.dto.Product;
import com.telenor.boutique.dto.QueryObject;
import com.telenor.boutique.entity.AbstractProduct;
import com.telenor.boutique.entity.Phones;
import com.telenor.boutique.entity.Subscriptions;
import com.telenor.boutique.service.ProductService;
import com.telenor.boutique.service.specbuilder.ProductTypeNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

    private Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    public ResponseEntity<Data> getProduct(
            @RequestParam(value = "type", required = false) Optional<String> type,
            @RequestParam(value = "min_price", required = false) Optional<Integer> minPrice,
            @RequestParam(value = "max_price", required = false) Optional<Integer> maxPrice,
            @RequestParam(value = "city", required = false) Optional<String> city,
            @RequestParam(value = "property", required = false) Optional<String> property,
            @RequestParam(value = "property.color", required = false) Optional<String> propertyColor,
            @RequestParam(value = "property.gb_limit_min", required = false) Optional<Integer> propertyGBLimitMin,
            @RequestParam(value = "property.gb_limit_max", required = false) Optional<Integer> propertyGBLimitMax)
            throws ProductTypeNotFoundException  {

        QueryObject queryObject = new QueryObject(type, minPrice, maxPrice, city, property, propertyColor, propertyGBLimitMin, propertyGBLimitMax);
        logger.debug(queryObject.toString());

        Map<String, List<? extends AbstractProduct>> productMap = productService.getProduct(queryObject);

        return ResponseEntity.ok(mapEntityToDTO(productMap));
    }

    @GetMapping("/ping")
    public ResponseEntity<String> ping() {
        String response = "Service is up!";
        return ResponseEntity.ok(response);
    }

    @GetMapping("/products")
    public ResponseEntity<List<AbstractProduct>> getProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    //can be improved by passing list of AbstractProducts and using instance of to identify the type
    private Data mapEntityToDTO(Map<String, List<? extends AbstractProduct>> products) {
        logger.debug("Mapping products - " + products.toString());

        Data data = new Data();
        List<Product> productList = new ArrayList<>();

        if(products.keySet().contains(Constants.PHONE)){
            for(AbstractProduct entry: products.get(Constants.PHONE)) {
            Phones phone = (Phones) entry;
            Product product = new Product();
            product.setType(Constants.PHONE);
            product.setPrice(String.valueOf(phone.getPrice()));
            product.setProperties(phone.getPropertyString());
            product.setStoreAddress(phone.getAddress());
            productList.add(product);
            }
        }

        if(products.keySet().contains(Constants.SUBSCRIPTION)){
            for(AbstractProduct entry: products.get(Constants.SUBSCRIPTION)) {
                Subscriptions subscription = (Subscriptions) entry;
                Product product = new Product();
                product.setType(Constants.SUBSCRIPTION);
                product.setPrice(String.valueOf(subscription.getPrice()));
                product.setProperties(subscription.getPropertyString());
                product.setStoreAddress(subscription.getAddress());
                productList.add(product);
            }
        }

        data.setData(productList);
        return data;
    }
}
