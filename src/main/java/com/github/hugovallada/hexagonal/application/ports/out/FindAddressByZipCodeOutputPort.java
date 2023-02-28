package com.github.hugovallada.hexagonal.application.ports.out;

import com.github.hugovallada.hexagonal.application.core.domain.Address;

public interface FindAddressByZipCodeOutputPort {
    
    Address find(String zipCode);

}
