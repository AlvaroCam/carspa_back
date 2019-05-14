package pe.com.tintegro.sigs.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.sigs.config.ApplicationContextDAOConfig;
import pe.com.tintegro.sigs.dto.request.ObtieneFechaRequest;
import pe.com.tintegro.sigs.dto.response.ObtieneFechaResponse;
import pe.com.tintegro.sigs.entidad.general.Item;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes ={ ApplicationContextDAOConfig.class })
public class FechaAnualDAOTest
{
	@Autowired
	private FechaAnualDAO fechaAnualDAO;
	@Test
	public void obtenerFechaAnual()
	{
		ObtieneFechaResponse response = new ObtieneFechaResponse();
		ObtieneFechaRequest request =new ObtieneFechaRequest();
		request.setInferiorFecha(2012);
		try {
			response = fechaAnualDAO.obtieneFecha(request);
			for (Item fechas : response.getLsFechaGeneradas()) {
				System.out.println("Año: " + fechas.getID());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
