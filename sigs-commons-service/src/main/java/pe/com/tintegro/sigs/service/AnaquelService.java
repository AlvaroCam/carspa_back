package pe.com.tintegro.sigs.service;

import pe.com.tintegro.sigs.dto.request.ActualizarAnaquelRequest;
import pe.com.tintegro.sigs.dto.response.ActualizarAnaquelResponse;

public interface AnaquelService {

	ActualizarAnaquelResponse actualizarAnaquel(ActualizarAnaquelRequest request) throws Exception;

}
