package it.uniroma3.siw.Progetto_SIW_Silph.persistenzaTest;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import it.uniroma3.siw.Progetto_SIW_Silph.model.Album;
import it.uniroma3.siw.Progetto_SIW_Silph.repository.AlbumRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
public class AlbumRepositoryTest {
	private Album a;
	
	@Autowired
	AlbumRepository albumRepository;
	
	
	@Before
	public void setUp() throws Exception {
		a= new Album();
		a.setNome("Nevermind");
		albumRepository.save(a);
	}
	

	@Test
	public void testAggiungiUnAlbum() {
		assertEquals(1,((List<Album>)albumRepository.findAll()).size());
		
	}

}
