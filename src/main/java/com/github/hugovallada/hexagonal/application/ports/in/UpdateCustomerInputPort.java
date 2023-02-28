package com.github.hugovallada.hexagonal.application.ports.in;

import com.github.hugovallada.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerInputPort {


    void execute(Customer customer, String zipCode);

}
