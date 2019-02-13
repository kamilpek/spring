package org.kamil.invoice.domain.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kamil.invoice.domain.Product;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ProductRepository.class)
public class ProductRepositoryTest {
	
	ProductRepository productRepository;
	Product product;
	
	@Before
	public void setUp() {
		product = new Product("1", "Galaxy S7", 1, 100, 123, 23, "1");
	}
	
	@Test
	public void testBasic() {
		productRepository.addProduct(product);
		Product select_product = productRepository.getProductById(product.getProductId());
		assertTrue(select_product.getNetto() == product.getNetto());
		assertTrue(select_product.getTax() == product.getTax());
		assertTrue(select_product.getBrutto() == product.getBrutto());
		assertEquals(select_product.getName(), product.getName());
	}

}
