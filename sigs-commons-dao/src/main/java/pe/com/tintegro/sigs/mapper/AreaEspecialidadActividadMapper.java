package pe.com.tintegro.sigs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pe.com.tintegro.sigs.entidad.AreaEspecialidadActividad;
import pe.com.tintegro.sigs.entidad.general.Confirmacion;

public interface AreaEspecialidadActividadMapper {
	
	public List<AreaEspecialidadActividad> obtenerAreaEspecialidadActividad(@Param("idIPRESS") String idIPRESS,
																			@Param("idArea")Integer idArea,
																			@Param("idEspecialidad")Integer idEspecialidad,
																			@Param("idActividad")Integer idActividad,
																			@Param("nuPagina")Integer nuPagina,
																			@Param("nuRegisMostrar")Integer nuRegisMostrar)throws Exception;
	
	public Confirmacion insertarAreaEspecialidadActividad(@Param("idIPRESS") String idIPRESS,
														  @Param("idArea") Integer idArea,
														  @Param("idEspecialidad") Integer idEspecialidad,
														  @Param("idActividad") Integer idActividad,
														  @Param("actMedica") Integer actMedica,
														  @Param("pacienteHora") Integer pacienteHora,
														  @Param("ambiente") Integer ambiente,
														  @Param("cCitasVoluntarias") Integer cCitasVoluntarias,
														  @Param("cRecitas") Integer cRecitas,
														  @Param("cInterconsultas") Integer cInterconsultas,
														  @Param("cCitarReferido") Integer cCitarReferido,
														  @Param("cCitasDias") Integer cCitasDias,
														  @Param("tCuposNuevos") Integer tCuposNuevos,
														  @Param("tCuposAdicionales") Integer tCuposAdicionales,
														  @Param("dAdeLiberaCupos") Integer dAdeLiberaCupos,
														  @Param("idFormImpre") Integer idFormImpre,
														  @Param("prioVolu")Integer prioVolu,
														  @Param("prioRecita")Integer prioRecita,
														  @Param("prioInter")Integer prioInter,
														  @Param("prioReferidos")Integer prioReferidos,
														  @Param("prioDias")Integer prioDias,
														  @Param("flgAmb")Integer flgAmb)throws Exception;
	
	public Confirmacion actualizarAreaEspecialidadActividad(@Param("idIPRESS") String idIPRESS,
															@Param("idArea") Integer idArea,
															@Param("idEspecialidad") Integer idEspecialidad,
															@Param("idActividad") Integer idActividad,
															@Param("actMedica") Integer actMedica,
															@Param("pacienteHora") Integer pacienteHora,
															@Param("ambiente") Integer ambiente,
															@Param("cCitasVoluntarias") Integer cCitasVoluntarias,
															@Param("cRecitas") Integer cRecitas,
															@Param("cInterconsultas") Integer cInterconsultas,
															@Param("cCitarReferido") Integer cCitarReferido,
															@Param("cCitasDias") Integer cCitasDias,
															@Param("tCuposNuevos") Integer tCuposNuevos,
															@Param("tCuposAdicionales") Integer tCuposAdicionales,
															@Param("dAdeLiberaCupos") Integer dAdeLiberaCupos,
															@Param("idFormImpre") Integer idFormImpre,
															@Param("prioVolu")Integer prioVolu,
															@Param("prioRecita")Integer prioRecita,
															@Param("prioInter")Integer prioInter,
															@Param("prioReferidos")Integer prioReferidos,
															@Param("prioDias")Integer prioDias,
															@Param("flgAmb")Integer flgAmb)throws Exception;
	
	public Confirmacion eliminarAreaEspecialidadActividad(@Param("idIPRESS") String idIPRESS,
														  @Param("idArea") Integer idArea,
														  @Param("idEspecialidad") Integer idEspecialidad,
														  @Param("idActividad") Integer idActividad)throws Exception;

}
