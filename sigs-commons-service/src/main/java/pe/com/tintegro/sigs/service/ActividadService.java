/**
 * 
 */
package pe.com.tintegro.sigs.service;

import pe.com.tintegro.sigs.dto.request.ActualizarActividadRequest;
import pe.com.tintegro.sigs.dto.request.EliminarActividadRequest;
import pe.com.tintegro.sigs.dto.request.EliminarSubActividadRequest;
import pe.com.tintegro.sigs.dto.request.InsertarActividadRequest;
import pe.com.tintegro.sigs.dto.request.InsertarSubActvidadesRequest;
import pe.com.tintegro.sigs.dto.request.ObtenerActividadDescripcionRequest;
import pe.com.tintegro.sigs.dto.request.ObtenerActividadesConsultaAmbulatoriaRequest;
import pe.com.tintegro.sigs.dto.request.ObtenerSubActividadesRequest;
import pe.com.tintegro.sigs.dto.request.ObtieneActividadRequest;
import pe.com.tintegro.sigs.dto.request.ObtieneActividadesRequest;
import pe.com.tintegro.sigs.dto.request.ObtieneSubActividadRequest;
import pe.com.tintegro.sigs.dto.request.ObtieneSubActividadesRequest;
import pe.com.tintegro.sigs.dto.response.ActualizarActividadResponse;
import pe.com.tintegro.sigs.dto.response.EliminarActividadResponse;
import pe.com.tintegro.sigs.dto.response.EliminarSubActividadResponse;
import pe.com.tintegro.sigs.dto.response.InsertarActividadResponse;
import pe.com.tintegro.sigs.dto.response.InsertarSubActividadesResponse;
import pe.com.tintegro.sigs.dto.response.ObtenerActividadDescripcionResponse;
import pe.com.tintegro.sigs.dto.response.ObtenerActividadesConsultaAmbulatoriaResponse;
import pe.com.tintegro.sigs.dto.response.ObtenerSubActividadResponse;
import pe.com.tintegro.sigs.dto.response.ObtieneActividadResponse;
import pe.com.tintegro.sigs.dto.response.ObtieneActividadesResponse;
import pe.com.tintegro.sigs.dto.response.ObtieneSubActividadResponse;
import pe.com.tintegro.sigs.dto.response.ObtieneSubActividadesResponse;

/**
 * @author daniel - 12 set. 2017
 *
 */
public interface ActividadService
{
	public ObtieneActividadesResponse obtenerActividades(ObtieneActividadesRequest request) throws Exception;
	
	public ObtenerActividadesConsultaAmbulatoriaResponse obtenerActividadesConsultaAmbulatoria(ObtenerActividadesConsultaAmbulatoriaRequest request) throws Exception;

	public ObtieneActividadResponse obtenerActividad(ObtieneActividadRequest request) throws Exception;

	public ObtieneSubActividadesResponse obtenerSubActividades(ObtieneSubActividadesRequest request) throws Exception;

	public ObtieneSubActividadResponse obtenerSubActividad(ObtieneSubActividadRequest request) throws Exception;

	public InsertarActividadResponse insertarActividad (InsertarActividadRequest request) throws Exception;
	
	public ObtenerActividadDescripcionResponse obtenerActividadDescripcion(ObtenerActividadDescripcionRequest request) throws Exception;
	
	public EliminarActividadResponse eliminarActividad (EliminarActividadRequest request) throws Exception;
	
	//ObtenerSubActividadesBARRETO;
		public ObtenerSubActividadResponse obtenerSubActividadd(ObtenerSubActividadesRequest request)throws Exception;
	//IngresarSubActividadesBARRETO;
		public InsertarSubActividadesResponse insertarSubActividad(InsertarSubActvidadesRequest request)throws Exception;
	//EliminarSubActividadesBARRETO;
		public EliminarSubActividadResponse eliminarSubActividad (EliminarSubActividadRequest request)throws Exception;
    //EditarActividad
		public ActualizarActividadResponse actualizarActividad(ActualizarActividadRequest request)throws Exception;
	

}
