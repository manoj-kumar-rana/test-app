package com.manojrana.app.controllers;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manojrana.app.models.Payment;

@RestController
@RequestMapping("/api/v1")
public class ApiController {

	@GetMapping("/hello")
	public String sayHello() {

		return "Hello Mr. Rana";

	}
	
	@GetMapping("/hello2")
	public String sayHello2() {

		return "Hello Mr. Manoj";

	}

	@PostMapping("/payment")
	public void getPayment(@RequestBody Payment payment, HttpServletResponse httpServletResponse) {

		System.out.println("Payment Id : " + payment.getPmtId());
		System.out.println("Payment Amt: " + payment.getAmount());

		String redirectUrl = "http://localhost:8080/api/v1/auth/payment-success";

		httpServletResponse.setHeader("Location", redirectUrl);
		httpServletResponse.setStatus(302);

	}

}
