package com.telenor.boutique.repository.specifications;

import com.telenor.boutique.entity.Subscriptions;
import org.springframework.data.jpa.domain.Specification;

public final class SubscriptionsSpecifications {

    public static Specification<Subscriptions> priceGreaterThanEqualTo(Integer minPrice) {
        return (root, query, builder) -> builder.greaterThanOrEqualTo(root.get("price"), minPrice);
    }

    public static Specification<Subscriptions> priceLessThanEqualTo(Integer maxPrice) {
        return (root, query, builder) -> builder.lessThanOrEqualTo(root.get("price"), maxPrice);
    }

    public static Specification<Subscriptions> likeCity(String city) {
        return (root, query, builder) -> builder.like(root.get("address"), "%" + city + "%");
    }

    public static Specification<Subscriptions> minLimitGreaterThanEqualTo(Integer minLimit) {
        return (root, query, builder) -> builder.greaterThanOrEqualTo(root.get("gbLimit"), minLimit);
    }

    public static Specification<Subscriptions> minLimitLessThanEqualTo(Integer maxLimit) {
        return (root, query, builder) -> builder.lessThanOrEqualTo(root.get("gbLimit"), maxLimit);
    }

}
