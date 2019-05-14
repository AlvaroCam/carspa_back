package pe.com.tintegro.sigs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pe.com.tintegro.sigs.entidad.Persona;

public interface PersonaMapper
{
	public Persona obtenerPersonaDatosPorActoMedico(@Param("idActoMedico") int idActoMedico) throws Exception;

	public Persona obtenerPersonaDatosPorCita(@Param("idCita") int idCita) throws Exception;

	public Persona obtenerDatosPersonaPorDocumento(@Param("nuDocumento") String nuDocumento,
			@Param("idIPRESS") String idIPRESS) throws Exception;
	
	public List<Persona> obtenerIdPersona(@Param("idTipoDocumentoIdentidad") int idTipoDocumentoIdentidad, @Param("numeroDocumento") String numeroDocumento) throws Exception;
	
	public List<Persona> obtenerPersonaPorIdPersona(@Param("idPersona") String idPersona, @Param("idIPRESS") String idIPRESS) throws Exception;
}
