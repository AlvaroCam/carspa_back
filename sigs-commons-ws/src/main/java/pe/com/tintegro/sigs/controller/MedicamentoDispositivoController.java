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
import pe.com.tintegro.sigs.dto.request.ObtieneMedicamentoDispositivoRequest;
import pe.com.tintegro.sigs.dto.response.ObtieneMedicamentoDispositivoResponse;
import pe.com.tintegro.sigs.helpers.RequestHelper;
import pe.com.tintegro.sigs.helpers.ResponseHelper;
import pe.com.tintegro.sigs.properties.APIProperties;
import pe.com.tintegro.sigs.service.MedicamentoDispositivoService;

/**
 * @author Aldo Huamán
 *
 *         12 ene. 2018
 */
@RestController
@RequestMapping("/medicamento-dispositivo")
@Api("medicamento-dispositivo")
public class MedicamentoDispositivoController
{
	private final Logger LOG = Logger.getLogger(MedicamentoDispositivoController.class);

	@Autowired
	private MedicamentoDispositivoService medicamentoDispositivoService;

	@Autowired
	private HttpServletRequest servletRequest;

	@Autowired
	private APIProperties apiProperties;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "obtener medicamento", notes = "Obtiene medicamentos autocompletado", response = ObtieneMedicamentoDispositivoResponse.class)
	public ObtieneMedicamentoDispositivoResponse obtenerMedicamentoDispMedicoProdSanitario(
			@RequestHeader("codUsuario") String codUsuario, @RequestHeader("idIPRESS") String idIPRESS,
			@RequestHeader("token") String token, @RequestParam("idAlmacen") Integer idAlmacen)
	{
		ObtieneMedicamentoDispositivoResponse response = new ObtieneMedicamentoDispositivoResponse();
		ObtieneMedicamentoDispositivoRequest request = new ObtieneMedicamentoDispositivoRequest();
		request.setIdAlmacen(idAlmacen);
		try
		{
			response = medicamentoDispositivoService
					.obtenerMedicamentoDispMedicoProdSanitario(RequestHelper.agregarHeaders(servletRequest, request));
		} catch (Exception e)
		{
			String codigoError = ResponseHelper.obtenerCodigoErrorPorFecha(apiProperties.getNombre());
			response.setEstado(ResponseEstado.ERROR_APLICACION);
			response.setMensaje("Error al obtener medicamento");
			response.setCodigoError(codigoError);
			LOG.error(codigoError, e);
		}

		return response;
	}
}
