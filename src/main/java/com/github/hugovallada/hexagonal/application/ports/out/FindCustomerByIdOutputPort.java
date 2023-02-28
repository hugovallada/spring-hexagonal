package com.github.hugovallada.hexagonal.application.ports.out;

import com.github.hugovallada.hexagonal.application.core.domain.Customer;

import java.util.Optional;

public interface FindCustomerByIdOutputPort {

    Optional<Customer> find(String id);

}
