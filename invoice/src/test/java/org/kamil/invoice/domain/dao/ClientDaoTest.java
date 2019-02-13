package org.kamil.invoice.domain.dao;

import static org.junit.Assert.assertEquals;

import java.sql.Statement;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kamil.invoice.domain.Client;
import org.kamil.invoice.domain.Product;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Product.class)
public class ClientDaoTest {
	
	DatabaseDao database = null;
	Statement dbStatement = null;
	ClientDao clientDao = null;
	Client client = null;
	
	@Before
	public void setUp() {
		database = DatabaseDao.getDb();
		dbStatement = database.stat;
		clientDao = new ClientDao(dbStatement);
		client = new Client("591-11-11-11", "Firma.pl", "Koœcierzyna", "83-400", "Testowa 1", "1");
	}
	
	@Test
	public void testBasic() {
		clientDao.insert_client(client);
		Client select_client = clientDao.select_client(client.getClientId());
		assertEquals(select_client.getNip(), client.getNip());
		assertEquals(select_client.getName(), client.getName());
		assertEquals(select_client.getCity(), client.getCity());
		assertEquals(select_client.getPost(), client.getPost());
		assertEquals(select_client.getStreet(), client.getStreet());
	}

}
