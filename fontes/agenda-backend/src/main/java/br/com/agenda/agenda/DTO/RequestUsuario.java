package br.com.agenda.agenda.DTO;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;

public record RequestUsuario(@Length(max = 100, message = "Limite de 100 caracteres excedido") String nome,
        @Length(max = 100, message = "Limite de 100 caracteres excedido") @Email String email,
        @Length(min = 6, max = 30, message = "A senha deve conter entre 6 a 30 caracteres") String senha,
        @Length(max = 100, message = "Limite de 100 caracteres excedido") String logradouro,
        @Length(max = 20, message = "Limite de 20 caracteres excedido") String numero,
        @Length(max = 100, message = "Limite de 100 caracteres excedido") String bairro,
        @Length(max = 100, message = "Limite de 100 caracteres excedido") String complemento,
        @Length(max = 100, message = "Limite de 100 caracteres excedido") String cidade,
        @Length(max = 2, message = "UF deve conter 2 digitos") String uf,
        @Length(min = 8, max = 9, message = "O cep deve conter 9 dígitos") String cep,
        @Length(max = 19, message = "O campo deve conter até 19 dígitos") String telefone,
        Boolean ativo, @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer id) {

            

}
