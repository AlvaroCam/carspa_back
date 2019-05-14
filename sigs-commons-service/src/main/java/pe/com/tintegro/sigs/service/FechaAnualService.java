package pe.com.tintegro.sigs.service;

import pe.com.tintegro.sigs.dto.request.ObtieneFechaRequest;
import pe.com.tintegro.sigs.dto.response.ObtieneFechaResponse;

public interface FechaAnualService
{
	ObtieneFechaResponse obtieneFecha (ObtieneFechaRequest request) throws Exception;
}
