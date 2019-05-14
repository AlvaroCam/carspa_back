package pe.com.tintegro.sigs.mapper;

import org.apache.ibatis.annotations.Param;

import pe.com.tintegro.sigs.entidad.ActoMedico;

public interface ActoMedicoMapper
{
	public ActoMedico obtenerActoMedicoPorCita(@Param("idCita") int idCita) throws Exception;
}	
