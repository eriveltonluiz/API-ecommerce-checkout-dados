package br.erivelton.ecommerce.checkout.streaming;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

@SuppressWarnings("deprecation")
public interface CheckoutCreatedSource {
	
	String OUTPUT = "checkout-created-output";

	@Output(OUTPUT)
    MessageChannel output();
}
