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

import it.uniroma3.siw.Progetto_SIW_Silph.model.Fotografia;
import it.uniroma3.siw.Progetto_SIW_Silph.model.RichiestaFoto;
import it.uniroma3.siw.Progetto_SIW_Silph.repository.FotografiaRepository;
import it.uniroma3.siw.Progetto_SIW_Silph.repository.RichiestaFotoRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RichiestaFotoRepositoryTest {


	private RichiestaFoto rf1;
	private RichiestaFoto rf2;
	private RichiestaFoto rf3;
	private RichiestaFoto rf4;
	private Fotografia f;

	@Autowired
	RichiestaFotoRepository richiestaFotoRepository;

	@Autowired
	FotografiaRepository fotografiaRepository;


	@Before
	public void setUp() throws Exception {
		//attenzione, add & delete vengono gestite nel repository grazie all'id
		//si basti ricordare che noi estendiamo la classe CrudRepository<classe,id>
		rf1= new RichiestaFoto();
		rf2= new RichiestaFoto();
		rf3= new RichiestaFoto();
		rf4= new RichiestaFoto();
		rf1.setNomeUtente("Amarino");
		rf2.setNomeUtente("Emilio");
		rf3.setNomeUtente("Andrea");
		rf4.setNomeUtente("Emilio");

		f= new Fotografia();
		f.setNome("Vacanze");
	}

	@Test
	public void testUnaRichiestaFotoAggiunta() {
		richiestaFotoRepository.save(rf1);
		assertEquals(1,((List<RichiestaFoto>)richiestaFotoRepository.findAll()).size());
		assertSame(rf1,((List<RichiestaFoto>)richiestaFotoRepository.findAll()).get(0));
	}

	@Test
	public void testNessunaRichiestaFotoAggunta() {
		assertEquals(0,((List<RichiestaFoto>)richiestaFotoRepository.findAll()).size());
	}

	@Test
	public void testPiùRichiestefotoAggiunte() {
		richiestaFotoRepository.save(rf1);
		richiestaFotoRepository.save(rf2);
		richiestaFotoRepository.save(rf3);
		assertEquals(3,((List<RichiestaFoto>)richiestaFotoRepository.findAll()).size());
	}

	@Test
	public void testRimuoviRicheisteFoto() {
		richiestaFotoRepository.save(rf1);
		richiestaFotoRepository.save(rf2);
		richiestaFotoRepository.delete(rf1);
		assertEquals(1,((List<RichiestaFoto>)richiestaFotoRepository.findAll()).size());
		assertSame(rf2, ((List<RichiestaFoto>)richiestaFotoRepository.findAll()).get(0));
	}

	//testing di un'operazione cascade

	@Test
	public void testNuovaFotoInseritaAncoraNonCreata() {
		List<Fotografia> fotografieRichieste;
		fotografieRichieste= new ArrayList<Fotografia>();
		fotografieRichieste.add(f);
		this.rf1.setFotografie(fotografieRichieste);
		richiestaFotoRepository.save(rf1);
		assertSame(rf1, ((List<RichiestaFoto>)richiestaFotoRepository.findAll()).get(0));
		assertSame(f,((List<Fotografia>)fotografiaRepository.findAll()).get(0));
	}

	//test della firma definita nella Repository

	@Test
	public void testRichiestaFotoPerNomeUtente() {
		richiestaFotoRepository.save(rf1);
		richiestaFotoRepository.save(rf2);
		richiestaFotoRepository.save(rf3);
		richiestaFotoRepository.save(rf4);
		List<RichiestaFoto> lista= new ArrayList<RichiestaFoto>();
		lista.add(rf2);
		lista.add(rf4);
		int i=0;
		for(RichiestaFoto al: lista) {
			assertSame(al, richiestaFotoRepository.findByNomeUtente("Emilio").get(i));
			i++;
		}

	}
}
