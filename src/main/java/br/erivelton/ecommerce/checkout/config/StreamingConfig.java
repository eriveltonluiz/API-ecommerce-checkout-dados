package br.erivelton.ecommerce.checkout.config;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

import br.erivelton.ecommerce.checkout.streaming.CheckoutCreatedSource;
import br.erivelton.ecommerce.checkout.streaming.PaymentPaidSink;

@SuppressWarnings("deprecation")
@Configuration
@EnableBinding(value = {
        CheckoutCreatedSource.class,
        PaymentPaidSink.class
})
public class StreamingConfig {
}
