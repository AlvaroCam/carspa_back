package pe.com.tintegro.sigs.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.sigs.config.ApplicationContextDAOConfig;
import pe.com.tintegro.sigs.dto.request.ObtieneExamenTiposRequest;
import pe.com.tintegro.sigs.dto.response.ObtieneExamenTiposResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes ={ ApplicationContextDAOConfig.class })
public class ExamenTipoDAOTest 
{
	@Autowired
	private ExamenTipoDAO examenTipoDAO;
	
	@Test
	public void obtenerExamenTipo()
	{
		ObtieneExamenTiposResponse response = new ObtieneExamenTiposResponse();
		ObtieneExamenTiposRequest request =new ObtieneExamenTiposRequest();
		request.setIdExamenTipo(null);
		try {
			response = examenTipoDAO.obtenerExamenTipos(request);
			response.getExamenTipoList().forEach(examenTipo -> {
				System.out.println(examenTipo.getID());
				System.out.println(examenTipo.getValor());
				System.out.println("-------------------");
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
