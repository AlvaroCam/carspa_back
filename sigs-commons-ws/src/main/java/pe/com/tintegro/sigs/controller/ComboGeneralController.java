package pe.com.tintegro.sigs.controller;

import javax.servlet.http.HttpServletRequest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

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

import pe.com.tintegro.sigs.constants.ResponseEstado;
import pe.com.tintegro.sigs.dto.request.ObtenerComboGeneralRequest;
import pe.com.tintegro.sigs.dto.request.ObtenerComboTipoDocumentoIdentidadRequest;
import pe.com.tintegro.sigs.dto.response.ObtenerComboGeneralResponse;
import pe.com.tintegro.sigs.dto.response.ObtenerComboTipoDocumentoIdentidadResponse;
import pe.com.tintegro.sigs.helpers.RequestHelper;
import pe.com.tintegro.sigs.helpers.ResponseHelper;
import pe.com.tintegro.sigs.properties.APIProperties;
import pe.com.tintegro.sigs.service.ComboGeneralService;


@RestController
@RequestMapping("/comboGeneral")
@Api("comboGeneral")
public class ComboGeneralController
{
	private static final Logger LOG = Logger.getLogger(ExamenTipoController.class);
	@Autowired
	private ComboGeneralService comboGeneralService;
	@Autowired
	private HttpServletRequest servletRequest;
	@Autowired
	private APIProperties apiProperties;
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Obtener valores para combos", notes = "Obtener valores para combos segun su tipo", response = ObtenerComboGeneralResponse.class)
	public ObtenerComboGeneralResponse obtenerComboGeneral(@RequestHeader("codUsuario") String codUsuario, @RequestHeader("idIPRESS") String idIPRESS, @RequestHeader("token") String token,
			@RequestParam(value = "codigoGrupo", required = false) String idGrupoOpcion)
	{
		ObtenerComboGeneralResponse response = new ObtenerComboGeneralResponse();
		ObtenerComboGeneralRequest request = new ObtenerComboGeneralRequest();
		request.setIdGrupoOpcion(idGrupoOpcion);
		try
		{
			response = comboGeneralService.obtenerComboGeneral(RequestHelper.agregarHeaders(servletRequest, request));
		}
		catch (Exception e)
		{
			String codigoError = ResponseHelper.obtenerCodigoErrorPorFecha(apiProperties.getNombre());
			response.setEstado(ResponseEstado.ERROR_APLICACION);
			response.setMensaje("Hubo un error al obtener los elementos del combo");
			response.setCodigoError(codigoError);
			LOG.error(codigoError, e);
		}
		return response;
	}
	
	@RequestMapping(value="combo-tipo-documento",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Obtener valores para combo de tipo de documento", notes = "Obtener valores para combo de tipo de documento", response = ObtenerComboTipoDocumentoIdentidadResponse.class)
	public ObtenerComboTipoDocumentoIdentidadResponse obtenerComboTipoDocumento(@RequestHeader("codUsuario") String codUsuario, @RequestHeader("idIPRESS") String idIPRESS, @RequestHeader("token") String token){
		ObtenerComboTipoDocumentoIdentidadResponse response = new ObtenerComboTipoDocumentoIdentidadResponse();
		ObtenerComboTipoDocumentoIdentidadRequest request = new ObtenerComboTipoDocumentoIdentidadRequest();
		try
		{
			response = comboGeneralService.obtenerComboTipoDocumento(RequestHelper.agregarHeaders(servletRequest, request));
		}
		catch (Exception e)
		{
			String codigoError = ResponseHelper.obtenerCodigoErrorPorFecha(apiProperties.getNombre());
			response.setEstado(ResponseEstado.ERROR_APLICACION);
			response.setMensaje("Hubo un error al obtener los elementos del combo");
			response.setCodigoError(codigoError);
			LOG.error(codigoError, e);
		}
		return response;
	}
}
