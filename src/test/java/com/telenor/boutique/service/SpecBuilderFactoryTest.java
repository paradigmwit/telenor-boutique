package com.telenor.boutique.service;

import com.telenor.boutique.config.Constants;
import com.telenor.boutique.service.specbuilder.PhoneSpecBuilder;
import com.telenor.boutique.service.specbuilder.ProductTypeNotFoundException;
import com.telenor.boutique.service.specbuilder.SpecBuilderFactory;
import com.telenor.boutique.service.specbuilder.SubscriptionSpecBuilder;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SpecBuilderFactoryTest {

    @Test
    public void getPhoneSpecBuilder(){
        PhoneSpecBuilder phoneSpecBuilder = (PhoneSpecBuilder) SpecBuilderFactory.getSpecBuilder(Optional.of(Constants.PHONE));
        assertThat(phoneSpecBuilder).isInstanceOf(PhoneSpecBuilder.class);
    }

    @Test
    public void getSubscriptionSpecBuilder(){
        SubscriptionSpecBuilder phoneSpecBuilder = (SubscriptionSpecBuilder) SpecBuilderFactory.getSpecBuilder(Optional.of(Constants.SUBSCRIPTION));
        assertThat(phoneSpecBuilder).isInstanceOf(SubscriptionSpecBuilder.class);
    }

    @Test
    public void onUnknownSpecBuilderTypeThrowsException(){
        try{
            SpecBuilderFactory.getSpecBuilder(Optional.of("RandomText"));
        }catch (Exception exception){
            assertThat(exception).isInstanceOf(ProductTypeNotFoundException.class);
        }
    }
}
