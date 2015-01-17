package au.com.redbackconsulting.moc.odata.api.edmconstants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.olingo.odata2.api.annotation.edm.FunctionImport.Multiplicity;
import org.apache.olingo.odata2.api.edm.EdmMultiplicity;
import org.apache.olingo.odata2.api.edm.EdmSimpleTypeKind;
import org.apache.olingo.odata2.api.edm.FullQualifiedName;
import org.apache.olingo.odata2.api.edm.provider.Association;
import org.apache.olingo.odata2.api.edm.provider.AssociationEnd;
import org.apache.olingo.odata2.api.edm.provider.EntitySet;
import org.apache.olingo.odata2.api.edm.provider.EntityType;
import org.apache.olingo.odata2.api.edm.provider.Facets;
import org.apache.olingo.odata2.api.edm.provider.Key;
import org.apache.olingo.odata2.api.edm.provider.Property;
import org.apache.olingo.odata2.api.edm.provider.PropertyRef;
import org.apache.olingo.odata2.api.edm.provider.SimpleProperty;


public class CaSystemEDM extends BaseEDM {
	public static String ENTITY_TYPE_NAME ="CaSystem";
	public static String ENTITY_SET_NAME="CaSystems";
	public static String SYSID ="sysId";
	public static String TENANTID="tenantId";
	public static String SYSDESC="sysDesc";
	public static String ASSOCIATION_CASYSTEM_TENANT;
	public static String ROLE_1_2 = "CaSystem_to_Tenant";
	public static String ROLE_2_1 = "Tenant_CaSystems";
	
	
	
	public CaSystemEDM(String nameSpace){
		super(nameSpace, ENTITY_TYPE_NAME, ENTITY_SET_NAME);
	//	entitySetName=CaSystemEDM.ENTITY_SET_NAME;
		
		
	}


	@Override
	public List<Property> getProperties() {
		List<Property> properties = new ArrayList<Property>();
		  properties.add(new SimpleProperty().setName(CaSystemEDM.SYSID).setType(EdmSimpleTypeKind.String).setFacets(new Facets().setNullable(false)));
		  properties.add(new SimpleProperty().setName(CaSystemEDM.TENANTID).setType(EdmSimpleTypeKind.Int32).setFacets(new Facets().setNullable(false)));
		  properties.add(new SimpleProperty().setName(CaSystemEDM.SYSDESC).setType(EdmSimpleTypeKind.String).setFacets(new Facets().setNullable(true)));
		  return properties;
	}


	@Override
	public List<PropertyRef> getKeys() {
		List<PropertyRef> keyProperties = new ArrayList<PropertyRef>();
		 keyProperties.add(new PropertyRef().setName(CaSystemEDM.SYSID));
		  keyProperties.add(new PropertyRef().setName(CaSystemEDM.TENANTID));
		return keyProperties;
	}


	@Override
	public Association getAssociation(  FullQualifiedName relatedEntity ) {
		if(relatedEntity.getName().equals(CaSystemEDM.ENTITY_TYPE_NAME)){
			    return new Association().setName(CaSystemEDM.ASSOCIATION_CASYSTEM_TENANT)
			        .setEnd1(new AssociationEnd().setType(getFullQualifiedName()).setRole(CaSystemEDM.ROLE_1_2).setMultiplicity(EdmMultiplicity.MANY))
			        .setEnd2(new AssociationEnd().setType(relatedEntity).setRole(CaSystemEDM.ROLE_2_1).setMultiplicity(EdmMultiplicity.ONE));
		}
		return null;
	 
	}


	
 
	
	
//	public  static	Map<String, Object> getEDMData(  CaSystems entity){
//		Map<String, Object> data = new HashMap<String, Object>();
//		
//		if(entity!=null)
//		{
//
//		data.put(CaSystemEDM.sysId, entity.getSystId());
//		data.put(CaSystemEDM.tenantId, entity.getTenantId());
//		data.put(CaSystemEDM.sysDesc,entity.getSystDesc() );
//		return data;
//		}
//		else
//			return null;
//	}

	
	
	
	 
	

}
