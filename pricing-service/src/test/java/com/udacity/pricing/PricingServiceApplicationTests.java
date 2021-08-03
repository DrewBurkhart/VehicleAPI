package com.udacity.pricing;

import com.udacity.pricing.domain.price.Price;
import com.udacity.pricing.domain.price.PriceRepository;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class PricingServiceApplicationTests {

	@Autowired
	PriceRepository priceRepository;

	@Test
	public void contextLoads() {
	}

	// Some help from
	// https://www.javaguides.net/2018/09/spring-data-jpa-repository-testing-using-spring-boot-datajpatest.html
	// and https://stackoverflow.com/a/38725479
	@Test
	public void findByIdTest() {
		BigDecimal expectedPrice = new BigDecimal("1.50");
		Price price = new Price("USD", expectedPrice, 1L);
		priceRepository.save(price);
		Price vehiclePrice = priceRepository.findById(1L).orElse(null);

		assert vehiclePrice != null;
		assertEquals(vehiclePrice.getPrice(), expectedPrice);
	}

}
