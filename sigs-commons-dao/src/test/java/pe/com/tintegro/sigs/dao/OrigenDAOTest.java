package pe.com.tintegro.sigs.dao;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.sigs.config.ApplicationContextDAOConfig;
import pe.com.tintegro.sigs.dto.request.ObtieneOrigenesRequest;
import pe.com.tintegro.sigs.dto.response.ObtieneOrigenesResponse;

@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( classes = { ApplicationContextDAOConfig.class } )
public class OrigenDAOTest 
{
	@Autowired
	private OrigenDAO origenDAO;
	
	@Test
	@Ignore
	public void obtenerOrigenDAO() 
	{
		ObtieneOrigenesResponse response = new ObtieneOrigenesResponse();
		ObtieneOrigenesRequest request = new ObtieneOrigenesRequest();
		request.setIdOrigen(null);
		try {
			response = origenDAO.obtenerOrigen(request);
			response.getOrigenList().forEach(origen -> {
				System.out.println(origen.getID());
				System.out.println(origen.getValor());
				System.out.println("-----------------------");
			});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
