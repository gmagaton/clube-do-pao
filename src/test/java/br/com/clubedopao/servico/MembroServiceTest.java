package br.com.clubedopao.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.clubedopao.excecao.JaExisteMembroComEmailInformadoException;
import br.com.clubedopao.modelo.Membro;
import br.com.clubedopao.repository.MembrosRepository;
import br.com.clubedopao.service.MembroService;

@ContextConfiguration(locations = { "classpath:applicationContextTest.xml" })
public class MembroServiceTest extends AbstractTransactionalTestNGSpringContextTests {

	@Autowired
	private MembrosRepository membroDao;
	
	@Autowired
	private MembroService membroService;

	@BeforeMethod
	public void inicializar() {
		membroDao.save(new Membro("Gabriel", "gmagaton@gmail.com"));
		membroDao.save(new Membro("Manuel", "manuel@gmail.com"));
		membroDao.save(new Membro("Rafael", "rafael@gmail.com"));
	}

	@Test
	public void deveBuscarMembroPorNome() {
		Membro membro = new Membro("Novo", "gmagaton@gmail.com");
		try {
			membroService.salvar(membro);
			Assert.fail("Execao de validacao de email nao foi lancada");
		} catch (JaExisteMembroComEmailInformadoException e) {
			Assert.assertTrue(true);
		}
	}

}
