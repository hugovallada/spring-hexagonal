package com.github.hugovallada.hexagonal.adapters.out.client.mapper;

import com.github.hugovallada.hexagonal.adapters.out.client.response.AddressResponse;
import com.github.hugovallada.hexagonal.application.core.domain.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {

    Address toAddress(AddressResponse addressResponse);
}
