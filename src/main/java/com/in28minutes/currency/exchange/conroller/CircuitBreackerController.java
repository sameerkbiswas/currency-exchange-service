/**
 * 
 */
package com.in28minutes.currency.exchange.conroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Sameer
 *
 */
@RestController
public class CircuitBreackerController {

	@GetMapping("/sample-api")
	public String sampleAPI()
	{
		return "Sample-API";
	}
}
