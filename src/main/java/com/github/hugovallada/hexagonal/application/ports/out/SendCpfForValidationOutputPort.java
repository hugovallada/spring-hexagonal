package com.github.hugovallada.hexagonal.application.ports.out;

public interface SendCpfForValidationOutputPort {
    void execute(String cpf);
}
