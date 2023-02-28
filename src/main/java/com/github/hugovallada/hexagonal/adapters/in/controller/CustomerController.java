package com.github.hugovallada.hexagonal.adapters.in.controller;

import com.github.hugovallada.hexagonal.adapters.in.controller.mapper.CustomerMapper;
import com.github.hugovallada.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.github.hugovallada.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.github.hugovallada.hexagonal.application.core.domain.Customer;
import com.github.hugovallada.hexagonal.application.ports.in.DeleteCustomerByIdInputPort;
import com.github.hugovallada.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.github.hugovallada.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.github.hugovallada.hexagonal.application.ports.in.UpdateCustomerInputPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final InsertCustomerInputPort insertCustomerInputPort;
    private final FindCustomerByIdInputPort findCustomerByIdInputPort;

    private final UpdateCustomerInputPort updateCustomerInputPort;

    private final DeleteCustomerByIdInputPort deleteCustomerByIdInputPort;

    private final CustomerMapper mapper;

    public CustomerController(InsertCustomerInputPort insertCustomerInputPort, FindCustomerByIdInputPort findCustomerByIdInputPort, UpdateCustomerInputPort updateCustomerInputPort, DeleteCustomerByIdInputPort deleteCustomerByIdInputPort, CustomerMapper mapper) {
        this.insertCustomerInputPort = insertCustomerInputPort;
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.updateCustomerInputPort = updateCustomerInputPort;
        this.deleteCustomerByIdInputPort = deleteCustomerByIdInputPort;
        this.mapper = mapper;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<Void> insert(@RequestBody @Valid CustomerRequest customerRequest){
        insertCustomerInputPort.insert(mapper.toCustomer(customerRequest), customerRequest.zipCode());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public CustomerResponse findById(@PathVariable String id) {
        final var customer = findCustomerByIdInputPort.find(id);
        return mapper.toCustomerResponse(customer);
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void update(@PathVariable final String id, @RequestBody @Valid CustomerRequest customerRequest) {
        Customer customer = mapper.toCustomer(customerRequest);
        customer.setId(id);
        updateCustomerInputPort.execute(customer, customerRequest.zipCode());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void update(@PathVariable final String id) {
        deleteCustomerByIdInputPort.execute(id);
    }

}
