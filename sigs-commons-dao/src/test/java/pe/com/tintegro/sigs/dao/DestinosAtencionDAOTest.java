package pe.com.tintegro.sigs.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.sigs.config.ApplicationContextDAOConfig;
import pe.com.tintegro.sigs.dto.request.ObtenerComboDestinosAtencionRequest;
import pe.com.tintegro.sigs.dto.response.ObtenerComboDestinosAtencionResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes =
{ ApplicationContextDAOConfig.class })
public class DestinosAtencionDAOTest {

	@Autowired
	private DestinosAtencionDAO destinosAtencionDAO;
	
	
	@Test
	public void obtenerDestinosTest()
	{
		try
		{
			ObtenerComboDestinosAtencionRequest request = new ObtenerComboDestinosAtencionRequest();
			ObtenerComboDestinosAtencionResponse response = destinosAtencionDAO.obtenerDestinos(request);
			
			response.getListDestinos().forEach(a ->
			{
				System.out.print(a.getID());
				System.out.println(a.getValor());
			});

		}
		catch (Exception e)
		{
			// TODO: handle exception
			e.printStackTrace();
		}

	}
}
