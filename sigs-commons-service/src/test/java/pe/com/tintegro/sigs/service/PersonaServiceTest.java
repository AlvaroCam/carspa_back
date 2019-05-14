package pe.com.tintegro.sigs.service;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.sigs.config.ApplicationContextDAOConfig;
import pe.com.tintegro.sigs.dto.request.ObtenerDatosPersonaPorDocumentoIdentidadRequest;
import pe.com.tintegro.sigs.dto.request.ObtienePersonaDatosPorActoMedicoRequest;
import pe.com.tintegro.sigs.dto.request.ObtienePersonaDatosPorCitaRequest;
import pe.com.tintegro.sigs.dto.response.ObtenerDatosPersonaPorDocumentoIdentidadResponse;
import pe.com.tintegro.sigs.dto.response.ObtienePersonaDatosPorActoMedicoResponse;
import pe.com.tintegro.sigs.dto.response.ObtienePersonaDatosPorCitaResponse;

@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( classes = { ApplicationContextDAOConfig.class } )
public class PersonaServiceTest
{
	@Autowired
	private PersonaService personaService;
	
	@Test
	@Ignore
	public void obtenerPersonaDatosPorActoMedico()
	{
		ObtienePersonaDatosPorActoMedicoResponse response = new ObtienePersonaDatosPorActoMedicoResponse();
		ObtienePersonaDatosPorActoMedicoRequest request = new ObtienePersonaDatosPorActoMedicoRequest();
		request.setIdActoMedico(2);
		request.setIdIPRESS( "gONZnF9vN/bocT+JhfnMGw==" );
		try
		{
			response = personaService.obtenerPersonaDatosPorActoMedico(request);
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
		request.setIdCita("tXznA/keOsQ=");
		request.setIdIPRESS( "gONZnF9vN/bocT+JhfnMGw==" );
		try
		{
			response = personaService.obtenerPersonaDatosPorCita(request);
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void obtenerDatosPersonaDocumentoIdentidadTest () {
		ObtenerDatosPersonaPorDocumentoIdentidadResponse response = new ObtenerDatosPersonaPorDocumentoIdentidadResponse();
		ObtenerDatosPersonaPorDocumentoIdentidadRequest request = new ObtenerDatosPersonaPorDocumentoIdentidadRequest();
		request.setNuDocumento("85858585");
		request.setIdIPRESS("gONZnF9vN/bocT+JhfnMGw==");
		try {
			response =  personaService.obtenerDatosPersonaPorDocumento(request);
			System.out.println(response.getDatosPersona().getApellidoPaterno());
			if(response.getDatosPersona() != null) {
				System.out.println("entre");
				System.out.println(response.getDatosPersona().toString());
			}else {
				System.out.println("NO VINO NADA");
			}
		} catch (Exception e) {
			e.getStackTrace();
			System.out.println(e.getCause());
		}
	}
}
