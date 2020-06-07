package com.telenor.boutique.service.specbuilder;

import com.telenor.boutique.dto.QueryObject;
import com.telenor.boutique.entity.Subscriptions;
import com.telenor.boutique.repository.specifications.SubscriptionsSpecifications;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class SubscriptionSpecBuilder extends AbstractSpecBuilder {

    @Override
    public Specification<Subscriptions> getSpec(QueryObject queryObject) {

        Specification<Subscriptions> subscriptionSpecification = Specification
                .where(queryObject.getCity().isPresent() ? SubscriptionsSpecifications.likeCity(queryObject.getCity().get() ) : null)
                .and(queryObject.getMinPrice().isPresent() ? SubscriptionsSpecifications.priceGreaterThanEqualTo(queryObject.getMinPrice().get()) : null)
                .and(queryObject.getMaxPrice().isPresent() ? SubscriptionsSpecifications.priceLessThanEqualTo(queryObject.getMaxPrice().get()) : null)
                .and(queryObject.getPropertyLimitMin().isPresent() ? SubscriptionsSpecifications.minLimitGreaterThanEqualTo(queryObject.getPropertyLimitMin().get()) : null)
                .and(queryObject.getPropertyLimitMax().isPresent() ? SubscriptionsSpecifications.minLimitLessThanEqualTo(queryObject.getPropertyLimitMax().get()) : null);

        return subscriptionSpecification;
    }
}
