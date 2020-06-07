package com.telenor.boutique.service;

import com.telenor.boutique.dto.QueryObject;
import com.telenor.boutique.entity.AbstractProduct;
import com.telenor.boutique.entity.Phones;
import com.telenor.boutique.entity.Subscriptions;
import com.telenor.boutique.repository.PhonesRepository;
import com.telenor.boutique.repository.SubscriptionsRepository;
import com.telenor.boutique.service.specbuilder.PhoneSpecBuilder;
import com.telenor.boutique.service.specbuilder.ProductTypeNotFoundException;
import com.telenor.boutique.service.specbuilder.SpecBuilderFactory;
import com.telenor.boutique.service.specbuilder.SubscriptionSpecBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.*;

import static com.telenor.boutique.config.Constants.PHONE;
import static com.telenor.boutique.config.Constants.SUBSCRIPTION;

@Service
public class ProductService {

    private Logger logger = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    private PhonesRepository phonesRepository;

    @Autowired
    private SubscriptionsRepository subscriptionsRepository;

    public Map<String, List<? extends AbstractProduct>> getProduct(QueryObject queryObject) throws ProductTypeNotFoundException {

        logger.debug("getProduct service started");

        Map<String, List<? extends AbstractProduct>> resultMap = new HashMap<>();

        if(queryObject.getType().isEmpty()
                || (queryObject.getType().isPresent() && PHONE.equalsIgnoreCase(queryObject.getType().get()))){
            List<Phones> phonesList = getPhone(queryObject);
            resultMap.put(PHONE, phonesList);
            logger.debug("PhoneList returned - " + phonesList);
        }


        if(queryObject.getType().isEmpty() ||
                (queryObject.getType().isPresent() && SUBSCRIPTION.equalsIgnoreCase(queryObject.getType().get()))) {
            List<Subscriptions> subscriptionList = getSubscription(queryObject);
            resultMap.put(SUBSCRIPTION, subscriptionList);
            logger.debug("SubscriptionList returned - " + subscriptionList);
        }

        return resultMap;
    }


    public List<Phones> getPhone(QueryObject queryObject) throws ProductTypeNotFoundException {

        logger.debug("getPhone service started");
        PhoneSpecBuilder phoneSpecBuilder = (PhoneSpecBuilder) SpecBuilderFactory.getSpecBuilder(Optional.of(PHONE));
        Specification<Phones> phoneSpec = phoneSpecBuilder.getSpec(queryObject);
        return phonesRepository.findAll(phoneSpec);
    }


    public List<Subscriptions> getSubscription(QueryObject queryObject) throws ProductTypeNotFoundException {

        logger.debug("getSubscription service started");
        SubscriptionSpecBuilder subscriptionSpecBuilder = (SubscriptionSpecBuilder) SpecBuilderFactory.getSpecBuilder(Optional.of(SUBSCRIPTION));
        Specification<Subscriptions> subscriptionSpec = subscriptionSpecBuilder.getSpec(queryObject);
        return subscriptionsRepository.findAll(subscriptionSpec);
    }


    public List<AbstractProduct> getAllProducts() {
        List<AbstractProduct> result = new ArrayList<>();
        result.addAll(phonesRepository.findAll());
        result.addAll(subscriptionsRepository.findAll());
        return result;
    }
}
