/**
 * 
 */
package pe.com.tintegro.sigs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pe.com.tintegro.sigs.entidad.GrupoOcupacional;
import pe.com.tintegro.sigs.entidad.TipoProfesional;
import pe.com.tintegro.sigs.entidad.general.Confirmacion;
import pe.com.tintegro.sigs.entidad.general.Item;

/**
 * @author Carlos
 *
 */
public interface GrupoOcupacionalMapper
{
	public List<Item> obtenerGrupoOcupacional(@Param("codigoIeds") String codigoIeds) throws Exception;
	
	//Insertar
		public Confirmacion insertarGrupoOcupacionalJ(
				@Param( "descripcionGrupoOcupacional" ) String descripcionGrupoOcupacional,
				@Param( "idTipoProfesional" ) Integer idTipoProfesional,
				@Param( "abreviatura" ) String abreviatura,
				@Param( "emitirReceta" ) Integer emitirReceta,
				@Param( "otorgarSolicitarExamen" ) Integer otorgarSolicitarExamen,
				@Param( "emitirCitt" ) Integer emitirCitt,
				@Param( "otorgarMateriales" ) Integer otorgarMateriales,
				@Param( "emitirReferencia" ) Integer emitirReferencia,
				@Param( "regularAntecedente" ) Integer regularAntecedente);
		
		//Obtener
		public List<GrupoOcupacional> obtenerGrupoOcupacionalJ(
				@Param( "descripcionGrupoOcupacional" ) String descripcionGrupoOcupacional,
				@Param( "idTipoProfesional") Integer idTipoProfesional,
				@Param( "nuPagina" ) Integer nuPagina,
				@Param( "nuRegisMostrar" ) Integer nuRegisMostrar);
		
		//Eliminar
		public Confirmacion eliminarGrupoOcupacionalJ(
				@Param( "idGrupoOcupacional" ) Integer idGrupoOcupacional);
		
		//Actualizar
		public Confirmacion actualizarGrupoOcupacionalJ(
				@Param( "idGrupoOcupacional") Integer idGrupoOcupacional,
				@Param( "descripcionGrupoOcupacional" ) String descripcionGrupoOcupacional,
				@Param( "idTipoProfesional" ) Integer idTipoProfesional,
				@Param( "abreviatura" ) String abreviatura,
				@Param( "emitirReceta" ) Integer emitirReceta,
				@Param( "otorgarSolicitarExamen" ) Integer otorgarSolicitarExamen,
				@Param( "emitirCitt" ) Integer emitirCitt,
				@Param( "otorgarMateriales" ) Integer otorgarMateriales,
				@Param( "emitirReferencia" ) Integer emitirReferencia,
				@Param( "regularAntecedente" ) Integer regularAntecedente);
		
		public List<TipoProfesional> obtenerTipoProfesionalJ() throws Exception;
		
		
}
