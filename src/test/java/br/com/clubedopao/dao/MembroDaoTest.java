package br.com.clubedopao.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.clubedopao.modelo.Membro;
import br.com.clubedopao.repository.MembrosRepository;

@ContextConfiguration(locations = { "classpath:applicationContextTest.xml" })
public class MembroDaoTest extends AbstractTransactionalTestNGSpringContextTests {

	@Autowired
	private MembrosRepository membroDao;

	@BeforeMethod
	public void inicializar() {
		membroDao.save(new Membro("Gabriel", "gmagaton@gmail.com"));
		membroDao.save(new Membro("Manuel", "manuel@gmail.com"));
		membroDao.save(new Membro("Rafael", "rafael@gmail.com"));
	}

	@Test
	public void deveBuscarMembroPorNome() {
		List<Membro> membros = membroDao.findByNome("Gabriel");
		Assert.assertNotNull(membros);
		Assert.assertTrue(membros.size() == 1);
	}

}
