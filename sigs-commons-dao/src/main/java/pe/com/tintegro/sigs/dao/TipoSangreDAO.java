package pe.com.tintegro.sigs.dao;

import pe.com.tintegro.sigs.dto.request.ObtieneTipoSangreResquest;
import pe.com.tintegro.sigs.dto.response.ObtieneTipoSangreResponse;

public interface TipoSangreDAO {

		public ObtieneTipoSangreResponse obtenerTipoSangre (ObtieneTipoSangreResquest request)throws Exception;
}
