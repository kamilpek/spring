package org.kamil.invoice.domain;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Product.class)
public class ProductTest {
	
	Product product;

	@Test
	public void testBasic() {
		product = new Product("1", "Galaxy S7", 1, 100, 123, 23, "1");		
		assertTrue(123 == product.getBrutto());
		assertTrue(100 == product.getNetto());
	}

}
