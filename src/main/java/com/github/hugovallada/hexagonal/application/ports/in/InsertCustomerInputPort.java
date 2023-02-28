package com.github.hugovallada.hexagonal.application.ports.in;

import com.github.hugovallada.hexagonal.application.core.domain.Customer;

public interface InsertCustomerInputPort {

    void insert(Customer customer, String zipCode);

}
