package com.telenor.boutique.repository.specifications;

import com.telenor.boutique.entity.Phones;
import org.springframework.data.jpa.domain.Specification;

public final class PhonesSpecifications {

    public static Specification<Phones> priceGreaterThanEqualTo(Integer minPrice) {
        return (root, query, builder) -> builder.greaterThanOrEqualTo(root.get("price"), minPrice);
    }

    public static Specification<Phones> priceLessThanEqualTo(Integer maxPrice) {
        return (root, query, builder) -> builder.lessThanOrEqualTo(root.get("price"), maxPrice);
    }

    public static Specification<Phones> likeCity(String city) {
        return (root, query, builder) -> builder.like(root.get("address"), "%" + city + "%");
    }
    
    public static Specification<Phones> equalToColor(String color) {
        return (root, query, builder) -> builder.equal(root.get("color"), color);
    }
}
