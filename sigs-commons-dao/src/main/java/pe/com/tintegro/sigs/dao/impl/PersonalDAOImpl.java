/**
 * 
 */
package pe.com.tintegro.sigs.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.com.tintegro.sigs.dao.PersonalDAO;
import pe.com.tintegro.sigs.entidad.Personal;
import pe.com.tintegro.sigs.mapper.PersonalMapper;

/**
 * @author daniel - 18 set. 2017
 *
 */
@Repository( "personalDAO" )
@Transactional
public class PersonalDAOImpl implements PersonalDAO
{
	@Autowired
	private PersonalMapper personalMapper;

	@Override
	public List<Personal> obtenerPersonales(String idIPRESS, Integer idArea, Integer idEspecialidad, Integer idActividad, Integer idSubActividad, String idPersonal) throws Exception
	{
		return personalMapper.obtenerPersonales(idIPRESS, idArea, idEspecialidad, idActividad, idSubActividad, idPersonal );
	}
}
