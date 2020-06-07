package com.telenor.boutique.service.specbuilder;

import com.telenor.boutique.dto.QueryObject;
import com.telenor.boutique.entity.Phones;
import com.telenor.boutique.repository.specifications.PhonesSpecifications;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class PhoneSpecBuilder extends AbstractSpecBuilder {

    @Override
    public Specification<Phones> getSpec(QueryObject queryObject) {

        Specification<Phones> phonesSpecification = Specification
                .where(queryObject.getCity().isPresent() ? PhonesSpecifications.likeCity(queryObject.getCity().get()) : null)
                .and(queryObject.getMinPrice().isPresent() ? PhonesSpecifications.priceGreaterThanEqualTo(queryObject.getMinPrice().get()) : null)
                .and(queryObject.getMaxPrice().isPresent() ? PhonesSpecifications.priceLessThanEqualTo(queryObject.getMaxPrice().get()) : null)
                .and(queryObject.getPropertyColor().isPresent() ? PhonesSpecifications.equalToColor(queryObject.getPropertyColor().get()) : null );

        return phonesSpecification;
    }
}
