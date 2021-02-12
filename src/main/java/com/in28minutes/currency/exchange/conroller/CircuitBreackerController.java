/**
 * 
 */
package com.in28minutes.currency.exchange.conroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

/**
 * @author Sameer
 *
 */
@RestController
public class CircuitBreackerController {
	private final String dummyUrl = "http://localhost:8080/some-dummy-url";
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	//@Retry(name="default")	// to configure the default(3 attempts by default) retry attempts
	//@Retry(name="sample-api", fallbackMethod="fallbackMethod")
	//@CircuitBreaker(name="sample-api", fallbackMethod="fallbackMethod")
	//@RateLimiter(name="default")	// Not working as of 12-02-2021 with the configuration
	@Bulkhead(name="sample-api")	// Not working as of 12-02-2021 with the configuration
	@GetMapping("/sample-api")
	public String sampleAPI()
	{
		logger.info("Request for sample-api");
		/*ResponseEntity<String> forEntity = new RestTemplate().getForEntity(dummyUrl, String.class);
		return forEntity.getBody();*/
		return "sample-api response";
	}
	
	public String fallbackMethod(Exception ex) {
		return "Fallback Method for sample-api";
	}
}
