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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import pe.com.tintegro.sigs.constants.ResponseEstado;
import pe.com.tintegro.sigs.dto.request.ObtieneTipoDocumentoRequest;
import pe.com.tintegro.sigs.dto.response.ObtieneTipoDocumentoResponse;
import pe.com.tintegro.sigs.helpers.RequestHelper;
import pe.com.tintegro.sigs.helpers.ResponseHelper;
import pe.com.tintegro.sigs.properties.APIProperties;
import pe.com.tintegro.sigs.service.TipoDocumentoService;

@RestController
@RequestMapping("/tiposDocumentos")
@Api("Tipos de documentos")
public class TipoDocumentoController {
	
	@Autowired
	private TipoDocumentoService tipoDocumentoService;
	
	@Autowired
	private HttpServletRequest servletRequest;

	@Autowired
	private APIProperties APIProperties;
	
	
	private static final Logger LOG = Logger.getLogger(TipoDocumentoController.class);
	
	@RequestMapping(method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_UTF8_VALUE )
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Obtener tipo de documentos", notes = "Obtiene los tipos de documentos.", response = ObtieneTipoDocumentoRequest.class)
	public ObtieneTipoDocumentoResponse obtenerTipoDocumento(
			@RequestHeader ("codUsuario") String codUsuario,
			@RequestHeader ("idIPRESS") String idIPRESS,
			@RequestHeader ("token") String token){

			ObtieneTipoDocumentoRequest request = new ObtieneTipoDocumentoRequest();
			ObtieneTipoDocumentoResponse response = new ObtieneTipoDocumentoResponse();
			
			try {
				response = tipoDocumentoService.obtenerTipoDocumento(RequestHelper.agregarHeaders
						(servletRequest, request));
				response.setEstado(ResponseEstado.OK);
				response.setMensaje("Datos de tipo de documento correctamente.");
			} catch (Exception e) {
				String codigoError = ResponseHelper
						.obtenerCodigoErrorPorFecha(APIProperties.getNombre());
				response.setEstado(ResponseEstado.ERROR_APLICACION);
				response.setMensaje("Ocurrió un error al obtener los tipos de documentos.");
				response.setCodigoError(codigoError);
				LOG.error(codigoError, e);
			}
			return response;
	}

}
