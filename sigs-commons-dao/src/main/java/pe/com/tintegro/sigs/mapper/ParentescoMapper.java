/**
 * 
 */
package pe.com.tintegro.sigs.mapper;

import java.util.List;

import pe.com.tintegro.sigs.entidad.general.Item;

/**
 * @author FReyes
 *
 */
public interface ParentescoMapper 
{
	public List<Item> obtenerParentesco() throws Exception;
}