package pe.com.tintegro.sigs.helpers;

import javax.servlet.http.HttpServletRequest;

import pe.com.tintegro.sigs.dto.request.RequestBase;

public class RequestHelper
{
	public static <T extends RequestBase> T agregarHeaders(HttpServletRequest servletRequest, T request) throws Exception
	{
		request.setIdIPRESS( servletRequest.getHeader( "idIPRESS" ) );
		request.setCodUsuario( servletRequest.getHeader( "codUsuario" ) );

		return request;
	}
}
