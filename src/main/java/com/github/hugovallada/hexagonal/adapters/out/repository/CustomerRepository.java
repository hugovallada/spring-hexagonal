package com.github.hugovallada.hexagonal.adapters.out.repository;

import com.github.hugovallada.hexagonal.adapters.out.repository.entity.CustomerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<CustomerEntity, String> {
}
