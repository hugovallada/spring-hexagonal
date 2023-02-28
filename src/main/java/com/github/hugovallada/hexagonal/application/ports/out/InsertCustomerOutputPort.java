package com.github.hugovallada.hexagonal.application.ports.out;

import com.github.hugovallada.hexagonal.application.core.domain.Customer;

public interface InsertCustomerOutputPort {
    
    void insert(Customer customer);

}
