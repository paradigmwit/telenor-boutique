package com.telenor.boutique.service.specbuilder;

import com.telenor.boutique.dto.QueryObject;
import com.telenor.boutique.entity.AbstractProduct;
import org.springframework.data.jpa.domain.Specification;

public abstract class AbstractSpecBuilder {

    public abstract Specification<? extends AbstractProduct> getSpec(QueryObject queryObject);
}
