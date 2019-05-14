package pe.com.tintegro.sigs.dao;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.sigs.config.ApplicationContextDAOConfig;
import pe.com.tintegro.sigs.dto.request.ObtenerDatosPersonaPorDocumentoIdentidadRequest;
import pe.com.tintegro.sigs.dto.request.ObtieneIdPersonaRequest;
import pe.com.tintegro.sigs.dto.request.ObtienePersonaDatosPorActoMedicoRequest;
import pe.com.tintegro.sigs.dto.request.ObtienePersonaDatosPorCitaRequest;
import pe.com.tintegro.sigs.dto.request.ObtienePersonaPorIdPersonaRequest;
import pe.com.tintegro.sigs.dto.response.ObtenerDatosPersonaPorDocumentoIdentidadResponse;
import pe.com.tintegro.sigs.dto.response.ObtieneIdPersonaResponse;
import pe.com.tintegro.sigs.dto.response.ObtienePersonaDatosPorActoMedicoResponse;
import pe.com.tintegro.sigs.dto.response.ObtienePersonaDatosPorCitaResponse;
import pe.com.tintegro.sigs.dto.response.ObtienePersonaPorIdPersonaResponse;

@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( classes = { ApplicationContextDAOConfig.class } )
public class PersonaDAOTest
{
	@Autowired
	public PersonaDAO personaDAO;
	
	@Test
	@Ignore
	public void obtenerPersonaDatosPorActoMedico()
	{
		ObtienePersonaDatosPorActoMedicoRequest request = new ObtienePersonaDatosPorActoMedicoRequest();
		ObtienePersonaDatosPorActoMedicoResponse response = new ObtienePersonaDatosPorActoMedicoResponse();
		request.setIdActoMedico(2);
		try
		{
			response  = personaDAO.obtenerPersonaDatosPorActoMedico(request);
			System.out.println(response.getPersona().toString());
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Test
	@Ignore
	public void obtenerPersonaDatos()
	{
		ObtienePersonaDatosPorCitaRequest request = new ObtienePersonaDatosPorCitaRequest();
		ObtienePersonaDatosPorCitaResponse response = new ObtienePersonaDatosPorCitaResponse();
		request.setIdCita("140");
		try
		{
			response = personaDAO.obtenerPersonaDatosPorCita(request);
			if(response.getPersona() != null)
			{
				System.out.println("entre");
				System.out.println(response.getPersona().toString());
			}else
			{
				System.out.println("NO VINO NADA");
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Test
	@Ignore
	public void obtenerDatosPersonaDocumentoIdentidadTest() {
		ObtenerDatosPersonaPorDocumentoIdentidadResponse response = new ObtenerDatosPersonaPorDocumentoIdentidadResponse();
		ObtenerDatosPersonaPorDocumentoIdentidadRequest request = new ObtenerDatosPersonaPorDocumentoIdentidadRequest();
		request.setNuDocumento("85858585");
		request.setIdIPRESS("0000007733");
		try {
			response = personaDAO.obtenerDatosPersonaDocumentoIdentidad(request);
			System.out.println(response.getDatosPersona().getApellidoPaterno());
		} catch (Exception e) {
			e.getStackTrace();
			System.out.println(e.getCause());
		}
	}
	
	@Test
	@Ignore
	public void obtenerIdPersona()
	{
		ObtieneIdPersonaRequest request=  new ObtieneIdPersonaRequest();
		ObtieneIdPersonaResponse response = new ObtieneIdPersonaResponse();
		request.setIdTipoDocumentoIdentidad(1);
		request.setNumeroDocumento("85858585");
		try
		{
			response = personaDAO.obtenerIdPersona(request);
			System.out.println(response.getPersonaList().toString());
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void obtenerPersonaPorIdPersona()
	{
		ObtienePersonaPorIdPersonaRequest request=  new ObtienePersonaPorIdPersonaRequest();
		ObtienePersonaPorIdPersonaResponse response = new ObtienePersonaPorIdPersonaResponse();
		request.setCodUsuario(null);
		request.setIdIPRESS("0000007733");
		request.setIdPersona("18585858500");
		try
		{
			response = personaDAO.obtenerPersonaPorIdPersona(request);
			System.out.println(response.getPersonaList().get(0).getCobertura().getDescripcionCobertura());
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
