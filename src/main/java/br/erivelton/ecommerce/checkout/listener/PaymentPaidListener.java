package br.erivelton.ecommerce.checkout.listener;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

import br.erivelton.ecommerce.checkout.entity.CheckoutEntity;
import br.erivelton.ecommerce.checkout.repository.CheckoutRepository;
import br.erivelton.ecommerce.checkout.streaming.PaymentPaidSink;
import br.erivelton.ecommerce.payment.event.PaymentCreatedEvent;
import lombok.RequiredArgsConstructor;

@SuppressWarnings("deprecation")
@Component
@RequiredArgsConstructor
public class PaymentPaidListener {

	private final CheckoutRepository checkoutRepository;
	
	@StreamListener(PaymentPaidSink.INPUT)
	public void handler(PaymentCreatedEvent event) {
		final CheckoutEntity checkoutEntity = checkoutRepository.findByCode(event.getCheckoutCode().toString()).orElseThrow();
		
		checkoutEntity.setStatus(CheckoutEntity.Status.APROVED);
		checkoutRepository.save(checkoutEntity);
	}
}
