package it.uniroma3.siw.Progetto_SIW_Silph.persistenzaTest;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import it.uniroma3.siw.Progetto_SIW_Silph.model.Utente;
import it.uniroma3.siw.Progetto_SIW_Silph.repository.UtenteRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class FunzionarioSilphRepositoryTest {
		private Utente fs1;
		private Utente fs2;
		private Utente fs3;
		private Utente fs4;

		@Autowired
		UtenteRepository funzionarioSilphRepository;


		@Before
		public void setUp() throws Exception {
			//attenzione, add & delete vengono gestite nel repository grazie all'id
			//si basti ricordare che noi estendiamo la classe CrudRepository<classe,id>
			fs1= new Utente();
			fs2= new Utente();
			fs3= new Utente();
			fs4= new Utente();
			fs1.setNome("Amarino");
			fs2.setNome("Emilio");
			fs3.setNome("Andrea");
			fs4.setNome("Emilio");
		}

		@Test
		public void testUnFunzioanarioAggiunto() {
			funzionarioSilphRepository.save(fs1);
			assertEquals(1,((List<Utente>)funzionarioSilphRepository.findAll()).size());
			assertSame(fs1,((List<Utente>)funzionarioSilphRepository.findAll()).get(0));
		}

		@Test
		public void testNessunFunzionarioAggunto() {
			assertEquals(0,((List<Utente>)funzionarioSilphRepository.findAll()).size());
		}

		@Test
		public void testPiùFunzionariAggiunti() {
			funzionarioSilphRepository.save(fs1);
			funzionarioSilphRepository.save(fs2);
			funzionarioSilphRepository.save(fs3);
			assertEquals(3,((List<Utente>)funzionarioSilphRepository.findAll()).size());
		}

		@Test
		public void testRimuoviFunzionario() {
			funzionarioSilphRepository.save(fs1);
			funzionarioSilphRepository.save(fs2);
			funzionarioSilphRepository.delete(fs1);
			assertEquals(1,((List<Utente>)funzionarioSilphRepository.findAll()).size());
			assertSame(fs2, ((List<Utente>)funzionarioSilphRepository.findAll()).get(0));
		}

		//test della firma definita nella Repository

		@Test
		public void testFunzionarioPerNome() {
			funzionarioSilphRepository.save(fs1);
			funzionarioSilphRepository.save(fs2);
			funzionarioSilphRepository.save(fs3);
			funzionarioSilphRepository.save(fs4);
			List<Utente> lista= new ArrayList<Utente>();
			lista.add(fs2);
			lista.add(fs4);
			int i=0;
			for(Utente al: lista) {
				assertSame(al, funzionarioSilphRepository.findByNome("Emilio").get(i));
				i++;
			}

		}
	}
