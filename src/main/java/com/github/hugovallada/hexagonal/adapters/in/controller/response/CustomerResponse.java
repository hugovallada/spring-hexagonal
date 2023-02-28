package com.github.hugovallada.hexagonal.adapters.in.controller.response;

public record CustomerResponse(String name, AddressResponse address, String cpf, Boolean isValidCpf) {
}
