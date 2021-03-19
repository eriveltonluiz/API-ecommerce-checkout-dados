package br.erivelton.ecommerce.checkout.service;

import java.util.Optional;

import br.erivelton.ecommerce.checkout.controller.checkout.CheckoutRequest;
import br.erivelton.ecommerce.checkout.entity.CheckoutEntity;

public interface CheckoutService {
	
	Optional<CheckoutEntity> create(CheckoutRequest checkoutRequest);
}
