package br.erivelton.ecommerce.checkout.controller.checkout;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckoutRequest implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String firstName;
	private String lastName;
	private String email;
	private String address;
	private String complement;
	private String country;
	private String state;
	private String cep;
	private Boolean saveAdress;
	private Boolean saveInfo;
	private String cardNome;
	private String cardNumber;
	private String cardDate;
	private String cardCvv;
}
