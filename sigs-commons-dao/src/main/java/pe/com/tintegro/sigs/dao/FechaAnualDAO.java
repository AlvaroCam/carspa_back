package pe.com.tintegro.sigs.dao;

import pe.com.tintegro.sigs.dto.request.ObtieneFechaRequest;
import pe.com.tintegro.sigs.dto.response.ObtieneFechaResponse;

public interface FechaAnualDAO
{
	ObtieneFechaResponse obtieneFecha(ObtieneFechaRequest request) throws Exception;
}
