package it.uniroma3.siw.Progetto_SIW_Silph.persistenzaTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import it.uniroma3.siw.Progetto_SIW_Silph.model.Album;
import it.uniroma3.siw.Progetto_SIW_Silph.model.Fotografia;
import it.uniroma3.siw.Progetto_SIW_Silph.repository.AlbumRepository;
import it.uniroma3.siw.Progetto_SIW_Silph.repository.FotografiaRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
public class AlbumRepositoryTest {
	private Album a;
	private Album b;
	private Album c;
	private Album d;
	private Fotografia f1;
	
	@Autowired
	AlbumRepository albumRepository;
	
	@Autowired
	FotografiaRepository fotografiaRepository;
	
	
	@Before
	public void setUp() throws Exception {
		//attenzione, add & delete vengono gestite nel repository grazie all'id
		//si basti ricordare che noi estendiamo la classe CrudRepository<classe,id>
		a= new Album();
		b= new Album();
		c= new Album();
		d= new Album();
		a.setNome("Nevermind");
		b.setNome("Scapeland");
		c.setNome("Portrait");
		d.setNome("Scapeland");
		
		f1= new Fotografia();
		f1.setNome("Lago");
		}
	
	@Test
	public void testUnAlbumAggiunto() {
		a.setNome("Nevermind");
		albumRepository.save(a);
		assertEquals(1,((List<Album>)albumRepository.findAll()).size());
		assertSame(a,((List<Album>)albumRepository.findAll()).get(0));
	}
	
	@Test
	public void testNessunAlbumAggiunto() {
		assertEquals(0,((List<Album>)albumRepository.findAll()).size());
	}
	
	@Test
	public void testPiùAlbumAggiunti() {
		albumRepository.save(a);
		albumRepository.save(b);
		albumRepository.save(c);
		assertEquals(3,((List<Album>)albumRepository.findAll()).size());
	}
	
	@Test
	public void testRimuoviAlbum() {
		albumRepository.save(a);
		albumRepository.save(b);
		albumRepository.delete(a);
		assertEquals(1,((List<Album>)albumRepository.findAll()).size());
		assertSame(b, ((List<Album>)albumRepository.findAll()).get(0));
	}
	
	//testing di un'operazione cascade
	
	@Test
	public void testNuovaFotoInseritaAncoraNonCreata() {
		List<Fotografia> fotoAlbum;
		fotoAlbum= new ArrayList<Fotografia>();
		fotoAlbum.add(f1);
		this.a.setFotografie(fotoAlbum);
		albumRepository.save(a);
		assertSame(a, ((List<Album>)albumRepository.findAll()).get(0));
		assertSame(f1,((List<Fotografia>)fotografiaRepository.findAll()).get(0));
	}
	
	//test dell firma definita nella Repository
	
	@Test
	public void testAlbumPerNome() {
		albumRepository.save(a);
		albumRepository.save(b);
		albumRepository.save(c);
		albumRepository.save(d);
		List<Album> lista= new ArrayList<Album>();
		lista.add(b);
		lista.add(d);
		int i=0;
		for(Album al: lista) {
		assertSame(al, albumRepository.findByNome("Scapeland").get(i));
		i++;
		}
		
	}
}
