package br.erivelton.ecommerce.checkout.controller.checkout;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.erivelton.ecommerce.checkout.entity.CheckoutEntity;
import br.erivelton.ecommerce.checkout.service.CheckoutService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/checkout")
@RequiredArgsConstructor
public class CheckoutController {
	
	private final CheckoutService checkoutService;

    @PostMapping("/")
    public ResponseEntity<CheckoutResponse> create(@RequestBody CheckoutRequest checkoutRequest) {
    	final CheckoutEntity checkoutEntity = checkoutService.create(checkoutRequest).orElseThrow();
    	final CheckoutResponse checkoutResponse = CheckoutResponse.builder().code(checkoutEntity.getCode()).build();
        return ResponseEntity.ok().body(checkoutResponse);
    }
	  
}
