package pe.com.tintegro.sigs.service;

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
 *         10 ene. 2018
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationContextDAOConfig.class })
public class ActoMedicoServiceTest
{
	@Autowired
	private ActoMedicoService actoMedicoService;
	
	public void obtenerActoMedicoPorCita()
	{
		ObtieneActoMedicoPorCitaRequest request = new ObtieneActoMedicoPorCitaRequest();
		ObtieneActoMedicoPorCitaResponse response = new ObtieneActoMedicoPorCitaResponse();
		request.setIdCita(1);//cambiar
		try
		{
			response = actoMedicoService.obtenerActoMedicoPorCita(request);
			if(response.getActoMedico() != null)
			{
				System.out.println(response.getActoMedico().toString());
			}else
			{
				System.out.println("Nada");
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
