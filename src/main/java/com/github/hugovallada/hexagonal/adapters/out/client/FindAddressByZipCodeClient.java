package com.github.hugovallada.hexagonal.adapters.out.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.github.hugovallada.hexagonal.adapters.out.client.response.*;

@FeignClient(name = "FindAddressByZipCodeClient", url = "${hugovallada.client.address.url}")
public interface FindAddressByZipCodeClient {

    @GetMapping("/{zipCode}")
    AddressResponse find(@PathVariable String zipCode);

}
