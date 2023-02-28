package com.github.hugovallada.hexagonal.application.core.usecase;

import com.github.hugovallada.hexagonal.application.core.domain.Customer;
import com.github.hugovallada.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.github.hugovallada.hexagonal.application.ports.in.UpdateCustomerInputPort;
import com.github.hugovallada.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.github.hugovallada.hexagonal.application.ports.out.UpdateCustomerOutputPort;

public class UpdateCustomerUseCase implements UpdateCustomerInputPort {

    private final FindCustomerByIdInputPort findCustomerByIdInputPort;
    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;
    private final UpdateCustomerOutputPort updateCustomerOutputPort;

    public UpdateCustomerUseCase(FindCustomerByIdInputPort findCustomerByIdInputPort, FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort, UpdateCustomerOutputPort updateCustomerOutputPort) {
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.updateCustomerOutputPort = updateCustomerOutputPort;
    }

    public void execute(Customer customer, String zipCode) {
        findCustomerByIdInputPort.find(customer.getId());
        var address = findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);
        updateCustomerOutputPort.execute(customer);
    }

}
