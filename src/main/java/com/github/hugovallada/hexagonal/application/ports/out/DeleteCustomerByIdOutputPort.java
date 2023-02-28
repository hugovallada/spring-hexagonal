package com.github.hugovallada.hexagonal.application.ports.out;

public interface DeleteCustomerByIdOutputPort {
    void delete(String id);
}
