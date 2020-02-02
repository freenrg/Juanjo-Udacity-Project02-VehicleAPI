package com.udacity.pricing;

import com.udacity.pricing.domain.price.Price;
import com.udacity.pricing.service.PriceException;
import com.udacity.pricing.service.PricingService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PricingServiceApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void testGetPrice() throws PriceException {
		PricingService pricingService = new PricingService();
		Price price = pricingService.getPrice(1L);

		Assert.assertEquals(price.getCurrency(), "USD");
		Assert.assertTrue(price.getPrice().compareTo(new BigDecimal(5000))>=0);
		Assert.assertTrue(price.getPrice().compareTo(new BigDecimal(25000))<0);

	}

}
