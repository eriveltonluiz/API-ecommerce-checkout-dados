package br.erivelton.ecommerce.checkout.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Service;

import br.erivelton.ecommerce.checkout.controller.checkout.CheckoutRequest;
import br.erivelton.ecommerce.checkout.entity.CheckoutEntity;
import br.erivelton.ecommerce.checkout.event.CheckoutCreatedEvent;
import br.erivelton.ecommerce.checkout.repository.CheckoutRepository;
import br.erivelton.ecommerce.checkout.streaming.CheckoutCreatedSource;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CheckoutServiceImpl implements CheckoutService {

	private final CheckoutRepository checkoutRepository;
	private final CheckoutCreatedSource checkoutCreatedSource;

	@Override
	public Optional<CheckoutEntity> create(CheckoutRequest checkoutRequest) {
		final CheckoutEntity checkoutEntity = CheckoutEntity.builder().code(UUID.randomUUID().toString())
				.status(CheckoutEntity.Status.CREATED).build();

		final CheckoutEntity entity = checkoutRepository.save(checkoutEntity);
		final CheckoutCreatedEvent checkoutCreatedEvent = CheckoutCreatedEvent.newBuilder()
				.setCheckoutCode(entity.getCode()).setStatus(entity.getStatus().name()).build();
		
		checkoutCreatedSource.output().send(MessageBuilder.withPayload(checkoutCreatedEvent).build());
		return Optional.of(entity);
	}
}
