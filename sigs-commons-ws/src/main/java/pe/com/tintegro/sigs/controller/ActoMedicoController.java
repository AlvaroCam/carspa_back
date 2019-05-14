package pe.com.tintegro.sigs.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import pe.com.tintegro.sigs.constants.ResponseEstado;
import pe.com.tintegro.sigs.dto.request.ObtieneActoMedicoPorCitaRequest;
import pe.com.tintegro.sigs.dto.response.ObtieneActoMedicoPorCitaResponse;
import pe.com.tintegro.sigs.dto.response.ObtienePersonaDatosPorCitaResponse;
import pe.com.tintegro.sigs.helpers.RequestHelper;
import pe.com.tintegro.sigs.helpers.ResponseHelper;
import pe.com.tintegro.sigs.properties.APIProperties;
import pe.com.tintegro.sigs.service.ActoMedicoService;

/**
 * @author Aldo Huamán
 *
 *         10 ene. 2018
 */
@RestController
@RequestMapping("/actoMedicos")
@Api("actoMedicos")
public class ActoMedicoController
{
	@Autowired
	private ActoMedicoService actoMedicoService;

	private static final Logger LOG = Logger.getLogger(PersonaController.class);

	@Autowired
	private HttpServletRequest servletRequest;

	@Autowired
	private APIProperties apiProperties;

	@RequestMapping( value="/Cita", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE ) 
	@ResponseStatus( value = HttpStatus.OK )
	@ApiOperation( value = "Obtiene datos de acto medico", notes = "Obtiene datos de acto Medico", response = ObtieneActoMedicoPorCitaResponse.class )
	public ObtieneActoMedicoPorCitaResponse obtenerActoMedicoPorCita(@RequestHeader("codUsuario") String codUsuario,
			@RequestHeader("idIPRESS") String idIPRESS, @RequestHeader("token") String token,
			@RequestParam("idCita") int idCita)
	{
		ObtieneActoMedicoPorCitaResponse response = new ObtieneActoMedicoPorCitaResponse();
		ObtieneActoMedicoPorCitaRequest request = new ObtieneActoMedicoPorCitaRequest();
		request.setIdCita(idCita);
		try
		{
			response = actoMedicoService.obtenerActoMedicoPorCita(RequestHelper.agregarHeaders(servletRequest, request));
		} catch (Exception e)
		{
			String codigoError = ResponseHelper.obtenerCodigoErrorPorFecha(apiProperties.getNombre());
			response.setEstado(ResponseEstado.ERROR_APLICACION);
			response.setMensaje("Ocurrió un error al obtener los datos de Acto Medico");
			response.setCodigoError(codigoError);
			LOG.error(codigoError, e);
		}
		return response;
	}
}
