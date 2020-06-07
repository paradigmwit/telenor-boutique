package com.telenor.boutique.service.specbuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

import static com.telenor.boutique.config.Constants.PHONE;
import static com.telenor.boutique.config.Constants.SUBSCRIPTION;

public class SpecBuilderFactory {

    private static Logger logger = LoggerFactory.getLogger(SpecBuilderFactory.class);

    public static AbstractSpecBuilder getSpecBuilder(Optional<String> specType) throws ProductTypeNotFoundException {


        if(specType.isPresent() && specType.get().equals(PHONE)) {
            logger.debug("Returning PhoneSpecBuilder");
            return new PhoneSpecBuilder();
        }
        else if(specType.isPresent() && specType.get().equals(SUBSCRIPTION)) {
            logger.debug("Returning SubscriptionSpecBuilder");
            return new SubscriptionSpecBuilder();
        }
        else
            throw new ProductTypeNotFoundException("Spec Builder Not Found");
    }
}
