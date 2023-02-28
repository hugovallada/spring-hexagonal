package com.github.hugovallada.hexagonal.adapters.out;

import com.github.hugovallada.hexagonal.adapters.out.client.FindAddressByZipCodeClient;
import com.github.hugovallada.hexagonal.adapters.out.client.mapper.AddressResponseMapper;
import com.github.hugovallada.hexagonal.application.core.domain.Address;
import com.github.hugovallada.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import org.springframework.stereotype.Component;

@Component
public class FindAddressByZipCodeAdapter implements FindAddressByZipCodeOutputPort {

    private final FindAddressByZipCodeClient client;

    private final AddressResponseMapper mapper;

    public FindAddressByZipCodeAdapter(FindAddressByZipCodeClient client, AddressResponseMapper mapper) {
        this.client = client;
        this.mapper = mapper;
    }

    @Override
    public Address find(String zipCode) {
        final var addressResponse = client.find(zipCode);
        return mapper.toAddress(addressResponse);
    }
}
