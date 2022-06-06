package com.study.kanapka.specification;

import com.study.kanapka.model.Order;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.Collections;

import static com.study.kanapka.specification.SearchOperations.*;

@Component
public class OrderSpecification {

    public Specification<Order> isEqual(String key, Object arg) {
        GenericSpecificationsBuilder<Order> builder = new GenericSpecificationsBuilder<>();
        return builder.with(key, EQUALITY, Collections.singletonList(arg)).build();
    }

    public Specification<Order> isLessThan(String key, Object arg) {
        GenericSpecificationsBuilder<Order> builder = new GenericSpecificationsBuilder<>();
        return builder.with(key, LESS_THAN, Collections.singletonList(arg)).build();
    }

    public Specification<Order> isGreaterThan(String key, Comparable arg) {
        GenericSpecificationsBuilder<Order> builder = new GenericSpecificationsBuilder<>(); return builder.with
                (key, GREATER_THAN , Collections.singletonList (arg)).build();
    }

    public Specification<Order> isIn(String key, Comparable arg) {
        GenericSpecificationsBuilder<Order> builder = new GenericSpecificationsBuilder<>(); return builder.with
                (key, IN , Collections.singletonList (arg)).build();
    }
}