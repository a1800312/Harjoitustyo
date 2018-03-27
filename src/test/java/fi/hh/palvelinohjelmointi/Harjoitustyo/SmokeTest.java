package fi.hh.palvelinohjelmointi.Harjoitustyo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.hh.palvelinohjelmointi.Harjoitustyo.web.HarjoitustyoController;
import fi.hh.palvelinohjelmointi.Harjoitustyo.web.UserDetailServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SmokeTest {
	
	@Autowired
	private HarjoitustyoController hControllers;
	
	@Autowired
	private UserDetailServiceImpl testUDSImplControllers;
	
	@Test
	public void contextOfHarjoitustyoControllerLoads() throws Exception {
		assertThat(hControllers).isNotNull();
	}
	
	@Test
	public void contextOfUserDetailServiceImplLoads() throws Exception {
		assertThat(testUDSImplControllers).isNotNull();
	}

}
