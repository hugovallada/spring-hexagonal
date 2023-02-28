package com.github.hugovallada.hexagonal.adapters.out;

import com.github.hugovallada.hexagonal.adapters.out.repository.CustomerRepository;
import com.github.hugovallada.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.github.hugovallada.hexagonal.application.core.domain.Customer;
import com.github.hugovallada.hexagonal.application.ports.out.InsertCustomerOutputPort;
import org.springframework.stereotype.Component;

@Component
public class InsertCustomerAdapter implements InsertCustomerOutputPort {

    private final CustomerRepository customerRepository;

    private final CustomerEntityMapper mapper;

    public InsertCustomerAdapter(CustomerRepository customerRepository, CustomerEntityMapper mapper) {
        this.customerRepository = customerRepository;
        this.mapper = mapper;
    }

    @Override
    public void insert(Customer customer) {
        customerRepository.save(mapper.toCustomerEntity(customer));
    }
}
