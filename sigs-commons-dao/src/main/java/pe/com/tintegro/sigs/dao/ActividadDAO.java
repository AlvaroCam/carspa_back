/**
 * 
 */
package pe.com.tintegro.sigs.dao;

import java.util.List;

import pe.com.tintegro.sigs.dto.request.ActualizarActividadRequest;
import pe.com.tintegro.sigs.dto.request.EliminarActividadRequest;
import pe.com.tintegro.sigs.dto.request.EliminarSubActividadRequest;
import pe.com.tintegro.sigs.dto.request.InsertarActividadRequest;
import pe.com.tintegro.sigs.dto.request.InsertarSubActvidadesRequest;
import pe.com.tintegro.sigs.dto.request.ObtenerActividadDescripcionRequest;
import pe.com.tintegro.sigs.dto.request.ObtenerSubActividadesRequest;
import pe.com.tintegro.sigs.dto.response.ActualizarActividadResponse;
import pe.com.tintegro.sigs.dto.response.EliminarActividadResponse;
import pe.com.tintegro.sigs.dto.response.EliminarSubActividadResponse;
import pe.com.tintegro.sigs.dto.response.InsertarActividadResponse;
import pe.com.tintegro.sigs.dto.response.InsertarSubActividadesResponse;
import pe.com.tintegro.sigs.dto.response.ObtenerActividadDescripcionResponse;
import pe.com.tintegro.sigs.dto.response.ObtenerSubActividadResponse;
import pe.com.tintegro.sigs.entidad.general.Item;

/**
 * @author daniel - 12 set
 *
 */
public interface ActividadDAO
{
	public List<Item> obtenerActividades( String idIPRESS, Integer idArea, Integer idEspecialidad, Integer idActividad ) throws Exception;
	
	public List<Item> obtenerActividadesConsultaAmbulatoria( String idIPRESS, Integer idArea, Integer idEspecialidad, Integer idActividad ) throws Exception;
	
	public List<Item> obtenerSubActividades( String idIPRESS, Integer idArea, Integer idEspecialidad, Integer idActividad, Integer idSubActividad ) throws Exception;

	public InsertarActividadResponse insertarActividad (InsertarActividadRequest request) throws Exception;
	
	public ObtenerActividadDescripcionResponse obtenerActividadDescripcion (ObtenerActividadDescripcionRequest request) throws Exception;
	
	public EliminarActividadResponse eliminarActividad (EliminarActividadRequest request) throws Exception;

	//ObtenerSubActividad;
    public ObtenerSubActividadResponse obtenerSubActividad (ObtenerSubActividadesRequest request) throws Exception;
	    
    //InsertarSubActividad;
	public InsertarSubActividadesResponse insertarSubActividad (InsertarSubActvidadesRequest request) throws Exception;

	//EliminarSubActividad;
	public EliminarSubActividadResponse eliminarSubActividad (EliminarSubActividadRequest request) throws Exception;
    //EditarActividad
	public ActualizarActividadResponse actualizarActividad(ActualizarActividadRequest request)throws Exception;




}
