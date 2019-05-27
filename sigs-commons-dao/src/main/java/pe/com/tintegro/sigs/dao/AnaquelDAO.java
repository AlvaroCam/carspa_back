package pe.com.tintegro.sigs.dao;

import pe.com.tintegro.sigs.dto.request.ActualizarAnaquelRequest;
import pe.com.tintegro.sigs.dto.response.ActualizarAnaquelResponse;

public interface AnaquelDAO {

	ActualizarAnaquelResponse actualizarAnaquel(ActualizarAnaquelRequest request) throws Exception;

}
