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
import it.uniroma3.siw.Progetto_SIW_Silph.model.Fotografo;
import it.uniroma3.siw.Progetto_SIW_Silph.repository.FotografiaRepository;
import it.uniroma3.siw.Progetto_SIW_Silph.repository.FotografoRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class FotografiaRepositoryTest {
	private Fotografia f1;
	private Fotografia f2;
	private Fotografia f3;
	private Fotografia f4;
	private Fotografo fo1;
	
	@Autowired
	FotografiaRepository fotografiaRepository;
	
	@Autowired
	FotografoRepository fotografoRepository;
	
	
	@Before
	public void setUp() throws Exception {
		//attenzione, add & delete vengono gestite nel repository grazie all'id
		//si basti ricordare che noi estendiamo la classe CrudRepository<classe,id>
		f1= new Fotografia();
		f2= new Fotografia();
		f3= new Fotografia();
		f4= new Fotografia();
		f1.setNome("cane");
		f2.setNome("gatto");
		f3.setNome("volpe");
		f4.setNome("gatto");
		
		fo1= new Fotografo();
		fo1.setNome("Amarino");
		}
	
	@Test
	public void testUnaFotoAggiunta() {
		fotografiaRepository.save(f1);
		assertEquals(1,((List<Fotografia>)fotografiaRepository.findAll()).size());
		assertSame(f1,((List<Fotografia>)fotografiaRepository.findAll()).get(0));
	}
	
	@Test
	public void testNessunaFotoAggiunta() {
		assertEquals(0,((List<Fotografia>)fotografiaRepository.findAll()).size());
	}
	
	@Test
	public void testPiùfotoAggiunte() {
		fotografiaRepository.save(f1);
		fotografiaRepository.save(f2);
		fotografiaRepository.save(f3);
		assertEquals(3,((List<Fotografia>)fotografiaRepository.findAll()).size());
	}
	
	@Test
	public void testRimuoviFoto() {
		fotografiaRepository.save(f1);
		fotografiaRepository.save(f2);
		fotografiaRepository.delete(f1);
		assertEquals(1,((List<Fotografia>)fotografiaRepository.findAll()).size());
		assertSame(f2, ((List<Fotografia>)fotografiaRepository.findAll()).get(0));
	}
	
	//testing di un'operazione cascade
	
	@Test
	public void testNuovoFotografoInseritoAncoraNonCreato() {
		this.f1.setFotografo(fo1);
		fotografiaRepository.save(f1);
		assertSame(f1, ((List<Fotografia>)fotografiaRepository.findAll()).get(0));
		assertSame(fo1,((List<Fotografo>)fotografoRepository.findAll()).get(0));
	}
	
	//test dell firma definita nella Repository
	
	@Test
	public void testFotoPerNome() {
		fotografiaRepository.save(f1);
		fotografiaRepository.save(f2);
		fotografiaRepository.save(f3);
		fotografiaRepository.save(f4);
		List<Fotografia> lista= new ArrayList<Fotografia>();
		lista.add(f2);
		lista.add(f4);
		int i=0;
		for(Fotografia al: lista) {
		assertSame(al, fotografiaRepository.findByNome("gatto").get(i));
		i++;
		}
		
	}
}
