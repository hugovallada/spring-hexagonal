package com.github.hugovallada.hexagonal.adapters.in.consumer.message;

public record CustomerMessage(String id, String name, String zipCode, String cpf, Boolean isValidCpf) {
}
