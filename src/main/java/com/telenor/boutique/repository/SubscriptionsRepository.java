package com.telenor.boutique.repository;

import com.telenor.boutique.entity.Subscriptions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SubscriptionsRepository extends JpaRepository<Subscriptions, Integer>, JpaSpecificationExecutor<Subscriptions> {
}