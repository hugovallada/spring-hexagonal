package com.github.hugovallada.hexagonal.config;

import com.github.hugovallada.hexagonal.adapters.out.*;
import com.github.hugovallada.hexagonal.application.core.usecase.DeleteCustomerByIdUseCase;
import com.github.hugovallada.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import com.github.hugovallada.hexagonal.application.core.usecase.InsertCustomerUseCase;
import com.github.hugovallada.hexagonal.application.core.usecase.UpdateCustomerUseCase;
import com.github.hugovallada.hexagonal.application.ports.in.DeleteCustomerByIdInputPort;
import com.github.hugovallada.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.github.hugovallada.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.github.hugovallada.hexagonal.application.ports.in.UpdateCustomerInputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Injector {

    @Bean
    public InsertCustomerInputPort insertCustomerUseCase(
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
            InsertCustomerAdapter insertCustomerAdapter,
            SendCpfValidationAdapter sendCpfValidationAdapter
    ) {
        return new InsertCustomerUseCase(findAddressByZipCodeAdapter, insertCustomerAdapter, sendCpfValidationAdapter);
    }

    @Bean
    public FindCustomerByIdInputPort findCustomerByIdUseCase(
            FindCustomerByIdAdapter findCustomerByIdAdapter
    ) {
        return new FindCustomerByIdUseCase(findCustomerByIdAdapter);
    }

    @Bean
    public UpdateCustomerInputPort updateCustomerUseCase(
            FindCustomerByIdInputPort findCustomerByIdInputPort,
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
            UpdateCustomerAdapter updateCustomerAdapter
    ) {
        return new UpdateCustomerUseCase(findCustomerByIdInputPort, findAddressByZipCodeAdapter, updateCustomerAdapter);
    }

    @Bean
    public DeleteCustomerByIdInputPort deleteCustomerByIdUseCase(
            FindCustomerByIdInputPort findCustomerByIdInputPort,
            DeleteCustomerByIdAdapter deleteCustomerByIdAdapter
    ) {
        return new DeleteCustomerByIdUseCase(findCustomerByIdInputPort, deleteCustomerByIdAdapter);
    }


}
