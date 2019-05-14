package pe.com.tintegro.sigs.dao;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.sigs.config.ApplicationContextDAOConfig;
import pe.com.tintegro.sigs.dto.request.ObtieneActoMedicoPorCitaRequest;
import pe.com.tintegro.sigs.dto.response.ObtieneActoMedicoPorCitaResponse;

/**
 * @author Aldo Huamán
 *
 * 10 ene. 2018
 */
@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( classes = { ApplicationContextDAOConfig.class } )
public class ActoMedicoDAOTest
{
	@Autowired
	private ActoMedicoDAO actoMedicoDAO;
	
	public void obtenerActoMedicoPorCita()
	{
		ObtieneActoMedicoPorCitaRequest request = new ObtieneActoMedicoPorCitaRequest();
		ObtieneActoMedicoPorCitaResponse response = new ObtieneActoMedicoPorCitaResponse();
		request.setIdCita(1);//cambiar
		try
		{
			response = actoMedicoDAO.obtenerActoMedicoPorCita(request);
			if(response.getActoMedico() != null)
			{
				System.out.println(response.getActoMedico().toString());
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
