package br.com.clubedopao.repositorio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.clubedopao.modelo.Membro;

@ContextConfiguration(locations = { "classpath:applicationContextTest.xml" })
public class MembroDaoTest extends AbstractTransactionalTestNGSpringContextTests {

	@Autowired
	private MembrosRepositorio membroRepositorio;

	@BeforeMethod
	public void inicializar() {
		membroRepositorio.save(new Membro("Gabriel", "gmagaton@gmail.com"));
		membroRepositorio.save(new Membro("Manuel", "manuel@gmail.com"));
		membroRepositorio.save(new Membro("Rafael", "rafael@gmail.com"));
	}

	@Test
	public void deveBuscarMembroPorNome() {
		final List<Membro> membros = membroRepositorio.findByNome("Gabriel");
		Assert.assertNotNull(membros);
		Assert.assertTrue(membros.size() == 1);
	}

	@Test
	public void deveBuscarMembroPorEmail() {
		final Membro membroPorEmail = membroRepositorio.findByEmail("manuel@gmail.com");
		Assert.assertNotNull(membroPorEmail);
		Assert.assertEquals(membroPorEmail.getNome(), "Manuel");
	}

}
