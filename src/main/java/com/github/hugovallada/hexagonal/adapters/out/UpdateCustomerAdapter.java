package com.github.hugovallada.hexagonal.adapters.out;

import com.github.hugovallada.hexagonal.adapters.out.repository.CustomerRepository;
import com.github.hugovallada.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.github.hugovallada.hexagonal.application.core.domain.Customer;
import com.github.hugovallada.hexagonal.application.ports.out.UpdateCustomerOutputPort;
import org.springframework.stereotype.Component;

@Component
public class UpdateCustomerAdapter implements UpdateCustomerOutputPort {

    private final CustomerRepository customerRepository;

    private final CustomerEntityMapper customerEntityMapper;

    public UpdateCustomerAdapter(CustomerRepository customerRepository, CustomerEntityMapper customerEntityMapper) {
        this.customerRepository = customerRepository;
        this.customerEntityMapper = customerEntityMapper;
    }


    @Override
    public void execute(Customer customer) {
        var customerEntity = customerEntityMapper.toCustomerEntity(customer);
        customerRepository.save(customerEntity);
    }
}
