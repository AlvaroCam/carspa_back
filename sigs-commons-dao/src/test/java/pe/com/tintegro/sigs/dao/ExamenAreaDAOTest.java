package pe.com.tintegro.sigs.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.sigs.config.ApplicationContextDAOConfig;
import pe.com.tintegro.sigs.dto.request.ObtieneExamenAreasRequest;
import pe.com.tintegro.sigs.dto.response.ObtieneExamenAreasResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes ={ ApplicationContextDAOConfig.class })
public class ExamenAreaDAOTest 
{
	@Autowired
	private ExamenAreaDAO examenAreaDAO;
	
	@Test
	public void obtenerExamenAreas() 
	{
		ObtieneExamenAreasResponse response = new ObtieneExamenAreasResponse();
		ObtieneExamenAreasRequest request = new ObtieneExamenAreasRequest();
		request.setIdExamenArea(null);
		//request.setIdExamenTipo(1);
		try {
			response = examenAreaDAO.obtenerExamenAreas(request);
			response.getExamenAreaList().forEach(examenArea -> {
				System.out.println(examenArea.getID());
				System.out.println(examenArea.getValor());
				System.out.println("-------------------");
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
