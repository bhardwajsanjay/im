package in.co.itasca.im.api.edmconstants;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.olingo.odata2.api.edm.EdmMultiplicity;
import org.apache.olingo.odata2.api.edm.EdmSimpleTypeKind;
import org.apache.olingo.odata2.api.edm.FullQualifiedName;
import org.apache.olingo.odata2.api.edm.provider.Association;
import org.apache.olingo.odata2.api.edm.provider.EntitySet;
import org.apache.olingo.odata2.api.edm.provider.EntityType;
import org.apache.olingo.odata2.api.edm.provider.Facets;
import org.apache.olingo.odata2.api.edm.provider.Key;
import org.apache.olingo.odata2.api.edm.provider.Property;
import org.apache.olingo.odata2.api.edm.provider.PropertyRef;
import org.apache.olingo.odata2.api.edm.provider.SimpleProperty;

abstract public class BaseEDM {
	
private FullQualifiedName fqn = null;
protected String entitySetName ;
	public BaseEDM(String namespace, String entityName, String entitySetName){
		fqn= new FullQualifiedName(namespace,	entityName);
		this.entitySetName=entitySetName;
	}
	

	public FullQualifiedName getFullQualifiedName( ){
		return fqn;
	
	}
	
	abstract public List<Property> getProperties() ;
	abstract public  List<PropertyRef> getKeys() ;
	
	public EntityType getEntityType( ){
		
		  FullQualifiedName ENTITY_TYPE_CASYSTEM =getFullQualifiedName( );
				
			//Properties
			
			  List<Property> properties = getProperties();
//			  properties.add(new SimpleProperty().setName(sysId).setType(EdmSimpleTypeKind.String).setFacets(new Facets().setNullable(false)));
//			  properties.add(new SimpleProperty().setName(tenantId).setType(EdmSimpleTypeKind.Int32).setFacets(new Facets().setNullable(false)));
//			  properties.add(new SimpleProperty().setName(sysDesc).setType(EdmSimpleTypeKind.String).setFacets(new Facets().setNullable(true)));
			  //Navigation  Properties
			  
			  //key
			  List<PropertyRef> keyProperties = getKeys();
//			  keyProperties.add(new PropertyRef().setName("sysId"));
//			  keyProperties.add(new PropertyRef().setName("tenantId"));
//				
			  Key key = new Key().setKeys(keyProperties);
			  
			  return new EntityType().setName(fqn.getName())
					  .setProperties(properties)
					  .setHasStream(true)
					  .setKey(key);
			  
		}
	
	
	
	abstract public Association getAssociation (  FullQualifiedName relatedEntity  );
	
	 public EntitySet getEntitySet(   ){
		 return new EntitySet().setName(entitySetName).setEntityType(getFullQualifiedName());
	 };
	
}
