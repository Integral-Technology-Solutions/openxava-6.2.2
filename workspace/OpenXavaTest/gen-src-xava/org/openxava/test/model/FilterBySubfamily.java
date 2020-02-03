
// File generated by OpenXava: Thu Dec 05 11:50:01 CET 2019
// Archivo generado por OpenXava: Thu Dec 05 11:50:01 CET 2019

// WARNING: NO EDIT
// OJO: NO EDITAR
// Component: FilterBySubfamily		Entity/Entidad

package org.openxava.test.model;

import java.util.*;
import java.math.*;
import java.rmi.RemoteException;
import org.openxava.component.MetaComponent;
import org.openxava.model.meta.MetaModel;
import org.openxava.util.*;

/**
 * 
 * @author MCarmen Gimeno
 */
public class FilterBySubfamily implements java.io.Serializable, org.openxava.test.model.IFilterBySubfamily {	

	// Constructor
	public FilterBySubfamily() {
		initMembers();
	} 

	private void initMembers() { 	
	} 
	
	// Properties/Propiedades 	
	/**
	 * 
	 * 
	 */
	public String getRangeDescription() { 		
		try {			
			org.openxava.test.calculators.RangeDescriptionCalculator rangeDescriptionCalculator= (org.openxava.test.calculators.RangeDescriptionCalculator)
				getMetaModel().getMetaProperty("rangeDescription").getMetaCalculator().createCalculator();  	
			
			rangeDescriptionCalculator.setSubfamilyNumberFrom(getSubfamily().getNumber());  	
			
			rangeDescriptionCalculator.setSubfamilyNumberTo(getSubfamilyTo().getNumber()); 
			return (String) rangeDescriptionCalculator.calculate();
		}
		catch (NullPointerException ex) {
			// Usually for multilevel property access with null references 
			return null; 			
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.calculate_value_error", "RangeDescription", "FilterBySubfamily", ex.getLocalizedMessage()));
		} 		
	}
	public void setRangeDescription(String newRangeDescription) {
		// for it is in value object
		// para que aparezca en los value objects
	} 

	// References/Referencias 

	private org.openxava.test.model.ISubfamily2 subfamilyTo; 	
	public org.openxava.test.model.ISubfamily2 getSubfamilyTo() {
		if (subfamilyTo != null) {
			// Because not-found='ignore' annul lazy initialization, we simulate it
			try {
				subfamilyTo.toString();
			}
			catch (Exception ex) {
				return null;
			}
		}	
		return subfamilyTo;
	}
	public void setSubfamilyTo(org.openxava.test.model.ISubfamily2 newSubfamily2) {
		if (newSubfamily2 != null && !(newSubfamily2 instanceof org.openxava.test.model.Subfamily2)) {
			throw new IllegalArgumentException(XavaResources.getString("ejb_to_pojo_illegal")); 
		}
		this.subfamilyTo = newSubfamily2; 
	} 

	private org.openxava.test.model.ISubfamily2 subfamily; 	
	public org.openxava.test.model.ISubfamily2 getSubfamily() {
		if (subfamily != null) {
			// Because not-found='ignore' annul lazy initialization, we simulate it
			try {
				subfamily.toString();
			}
			catch (Exception ex) {
				return null;
			}
		}	
		return subfamily;
	}
	public void setSubfamily(org.openxava.test.model.ISubfamily2 newSubfamily2) {
		if (newSubfamily2 != null && !(newSubfamily2 instanceof org.openxava.test.model.Subfamily2)) {
			throw new IllegalArgumentException(XavaResources.getString("ejb_to_pojo_illegal")); 
		}
		this.subfamily = newSubfamily2; 
	} 

	// Colecciones/Collections 

	// Methods/Metodos 	

	// User defined finders/Buscadores definidos por el usuario 	
 	public static FilterBySubfamily findBy() throws javax.ejb.ObjectNotFoundException {
		org.hibernate.Query query = org.openxava.hibernate.XHibernate.getSession().createQuery("from FilterBySubfamily as o"); 
		FilterBySubfamily r = (FilterBySubfamily) query.uniqueResult();
		if (r == null) {
			throw new javax.ejb.ObjectNotFoundException(XavaResources.getString("object_not_found", "FilterBySubfamily"));
		}
		return r; 
 	} 


	private static MetaModel metaModel;
	public MetaModel getMetaModel() throws XavaException {
		if (metaModel == null) {
			metaModel = MetaComponent.get("FilterBySubfamily").getMetaEntity(); 	
		}
		return metaModel;
	}
	
	public String toString() {		
		try {
			return getMetaModel().toString(this);
		}
		catch (XavaException ex) {
			System.err.println(XavaResources.getString("toString_warning", "FilterBySubfamily"));
			return super.toString();
		}		
	}

	public boolean equals(Object other) {		
		if (other == null) return false;
		return toString().equals(other.toString());
	}
	
	public int hashCode() {		
		return toString().hashCode();
	}
	
}