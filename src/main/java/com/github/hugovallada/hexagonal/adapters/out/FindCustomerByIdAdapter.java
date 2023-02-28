package com.github.hugovallada.hexagonal.adapters.out;

import com.github.hugovallada.hexagonal.adapters.out.repository.CustomerRepository;
import com.github.hugovallada.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.github.hugovallada.hexagonal.application.core.domain.Customer;
import com.github.hugovallada.hexagonal.application.ports.out.FindCustomerByIdOutputPort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindCustomerByIdAdapter implements FindCustomerByIdOutputPort {

    private final CustomerRepository customerRepository;
    private final CustomerEntityMapper mapper;

    public FindCustomerByIdAdapter(CustomerRepository customerRepository, CustomerEntityMapper mapper) {
        this.customerRepository = customerRepository;
        this.mapper = mapper;
    }

    @Override
    public Optional<Customer> find(String id) {
        final var customer = customerRepository.findById(id);
        return customer.map(mapper::toCustomer);
    }
}
