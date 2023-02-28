package com.github.hugovallada.hexagonal.application.ports.in;

public interface DeleteCustomerByIdInputPort {
    void execute(String id);
}
