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

import it.uniroma3.siw.Progetto_SIW_Silph.model.Fotografo;
import it.uniroma3.siw.Progetto_SIW_Silph.model.Album;
import it.uniroma3.siw.Progetto_SIW_Silph.repository.FotografoRepository;
import it.uniroma3.siw.Progetto_SIW_Silph.repository.AlbumRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class FotografoRepositoryTest {
	private Fotografo fo1;
	private Fotografo fo2;
	private Fotografo fo3;
	private Fotografo fo4;
	private Album a;

	@Autowired
	FotografoRepository fotografoRepository;

	@Autowired
	AlbumRepository albumRepository;


	@Before
	public void setUp() throws Exception {
		//attenzione, add & delete vengono gestite nel repository grazie all'id
		//si basti ricordare che noi estendiamo la classe CrudRepository<classe,id>
		fo1= new Fotografo();
		fo2= new Fotografo();
		fo3= new Fotografo();
		fo4= new Fotografo();
		fo1.setNome("Amarino");
		fo2.setNome("Emilio");
		fo3.setNome("Andrea");
		fo4.setNome("Emilio");

		a= new Album();
		a.setNome("Vacanze");
	}

	@Test
	public void testUnFotografoAggiunto() {
		fotografoRepository.save(fo1);
		assertEquals(1,((List<Fotografo>)fotografoRepository.findAll()).size());
		assertSame(fo1,((List<Fotografo>)fotografoRepository.findAll()).get(0));
	}

	@Test
	public void testNessunFotografoAggunto() {
		assertEquals(0,((List<Fotografo>)fotografoRepository.findAll()).size());
	}

	@Test
	public void testPiùfotografiAggiunti() {
		fotografoRepository.save(fo1);
		fotografoRepository.save(fo2);
		fotografoRepository.save(fo3);
		assertEquals(3,((List<Fotografo>)fotografoRepository.findAll()).size());
	}

	@Test
	public void testRimuoviFotografo() {
		fotografoRepository.save(fo1);
		fotografoRepository.save(fo2);
		fotografoRepository.delete(fo1);
		assertEquals(1,((List<Fotografo>)fotografoRepository.findAll()).size());
		assertSame(fo2, ((List<Fotografo>)fotografoRepository.findAll()).get(0));
	}

	//testing di un'operazione cascade

	@Test
	public void testNuovoAlbumInseritoAncoraNonCreato() {
		List<Album> albumFotografo;
		albumFotografo= new ArrayList<Album>();
		albumFotografo.add(a);
		this.fo1.setAlbums(albumFotografo);
		fotografoRepository.save(fo1);
		assertSame(fo1, ((List<Fotografo>)fotografoRepository.findAll()).get(0));
		assertSame(a,((List<Album>)albumRepository.findAll()).get(0));
	}

	//test della firma definita nella Repository

	@Test
	public void testFotografoPerNome() {
		fotografoRepository.save(fo1);
		fotografoRepository.save(fo2);
		fotografoRepository.save(fo3);
		fotografoRepository.save(fo4);
		List<Fotografo> lista= new ArrayList<Fotografo>();
		lista.add(fo2);
		lista.add(fo4);
		int i=0;
		for(Fotografo al: lista) {
			assertSame(al, fotografoRepository.findByNome("Emilio").get(i));
			i++;
		}

	}
}

