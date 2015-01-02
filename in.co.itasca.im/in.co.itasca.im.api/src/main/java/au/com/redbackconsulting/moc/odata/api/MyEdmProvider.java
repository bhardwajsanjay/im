package au.com.redbackconsulting.moc.odata.api;

import java.util.ArrayList;
import java.util.List;

import org.apache.olingo.odata2.api.edm.EdmConcurrencyMode;
import org.apache.olingo.odata2.api.edm.EdmMultiplicity;
import org.apache.olingo.odata2.api.edm.EdmSimpleTypeKind;
import org.apache.olingo.odata2.api.edm.EdmTargetPath;
import org.apache.olingo.odata2.api.edm.FullQualifiedName;
import org.apache.olingo.odata2.api.edm.provider.Association;
import org.apache.olingo.odata2.api.edm.provider.AssociationEnd;
import org.apache.olingo.odata2.api.edm.provider.AssociationSet;
import org.apache.olingo.odata2.api.edm.provider.AssociationSetEnd;
import org.apache.olingo.odata2.api.edm.provider.ComplexProperty;
import org.apache.olingo.odata2.api.edm.provider.ComplexType;
import org.apache.olingo.odata2.api.edm.provider.CustomizableFeedMappings;
import org.apache.olingo.odata2.api.edm.provider.EdmProvider;
import org.apache.olingo.odata2.api.edm.provider.EntityContainer;
import org.apache.olingo.odata2.api.edm.provider.EntityContainerInfo;
import org.apache.olingo.odata2.api.edm.provider.EntitySet;
import org.apache.olingo.odata2.api.edm.provider.EntityType;
import org.apache.olingo.odata2.api.edm.provider.Facets;
import org.apache.olingo.odata2.api.edm.provider.Key;
import org.apache.olingo.odata2.api.edm.provider.NavigationProperty;
import org.apache.olingo.odata2.api.edm.provider.Property;
import org.apache.olingo.odata2.api.edm.provider.PropertyRef;
import org.apache.olingo.odata2.api.edm.provider.Schema;
import org.apache.olingo.odata2.api.edm.provider.SimpleProperty;
import org.apache.olingo.odata2.api.exception.ODataException;

import au.com.redbackconsulting.moc.odata.api.edmconstants.BaseEDM;
import au.com.redbackconsulting.moc.odata.api.edmconstants.CaSystemEDM;
import au.com.redbackconsulting.moc.odata.api.edmconstants.EntityTypeFactory;
 
public class MyEdmProvider extends EdmProvider {
	

	
 
	  private static final String NAMESPACE = "au.com.redbackconsulting.odata2.ODataMoc";
      private static final String ENTITY_CONTAINER = "ODataMOCEntityContainer";

 
	@Override
	public List<Schema> getSchemas() throws ODataException {
		 
		List<Schema> schemas = new ArrayList<Schema>();
		Schema schema = new Schema();
		schema.setNamespace(NAMESPACE);
		List<EntityType> entityTypes = new ArrayList<EntityType>();
		EntityTypeFactory entityFactory = EntityTypeFactory.getInstance(NAMESPACE);
		BaseEDM caSystemEDM = entityFactory.getEDM(entityFactory.entity_type_caSystem);
		entityTypes.add(caSystemEDM.getEntityType());

		BaseEDM hrHierEDM = entityFactory.getEDM(entityFactory.entity_type_HrHier);
		entityTypes.add(hrHierEDM.getEntityType());
		
		BaseEDM hrHierMapEDM = entityFactory.getEDM(entityFactory.entity_type_HrHierMap);
		entityTypes.add(hrHierMapEDM.getEntityType());
		
		BaseEDM hrObjectConstraintsEDM = entityFactory.getEDM(entityFactory.entity_type_HrObjectConstraints);
		entityTypes.add(hrObjectConstraintsEDM.getEntityType());
		
		BaseEDM hrObjectsRelEDM = entityFactory.getEDM(entityFactory.entity_type_HrObjectRel); 
		entityTypes.add(hrObjectsRelEDM.getEntityType());
		
		BaseEDM hrObjectsEDM = entityFactory.getEDM(entityFactory.entity_type_HrObjects);
		entityTypes.add(hrObjectsEDM.getEntityType());
		
		BaseEDM hrObjectsStutusEDM = entityFactory.getEDM(entityFactory.entity_type_HrObjectStatus);
		entityTypes.add(hrObjectsStutusEDM.getEntityType());
		
		BaseEDM hrP1000EDM = entityFactory.getEDM(entityFactory.entity_type_Hrp1000);
		entityTypes.add(hrP1000EDM.getEntityType());
		
		BaseEDM hrP1001EDM= entityFactory.getEDM(entityFactory.entity_type_Hrp1001); 
		entityTypes.add(hrP1001EDM.getEntityType());
		
		BaseEDM hrRelationsEDM= entityFactory.getEDM(entityFactory.entity_type_HrRelations);
		entityTypes.add(hrRelationsEDM.getEntityType());
		
		BaseEDM tenantEDM = entityFactory.getEDM(entityFactory.entity_type_Tenants);
		entityTypes.add(tenantEDM.getEntityType());
		schema.setEntityTypes(entityTypes);


//		List<ComplexType> complexTypes = new ArrayList<ComplexType>();
//		complexTypes.add(getComplexType(COMPLEX_TYPE));
//		schema.setComplexTypes(complexTypes);

//		List<Association> associations = new ArrayList<Association>();
//		associations.add(caSystemEDM.getAssociation(tenantEDM.getFullQualifiedName()));
//		schema.setAssociations(associations);
//		
//		associations.add(e)

		List<EntityContainer> entityContainers = new ArrayList<EntityContainer>();
		EntityContainer entityContainer = new EntityContainer();
		entityContainer.setName(ENTITY_CONTAINER).setDefaultEntityContainer(true);

		List<EntitySet> entitySets = new ArrayList<EntitySet>();
		
		entitySets.add(caSystemEDM.getEntitySet( ));
//		entitySets.add(hrHierEDM.getEntitySet());
//		entitySets.add(hrHierMapEDM.getEntitySet());
//		entitySets.add(hrObjectsRelEDM.getEntitySet());
//		entitySets.add(hrObjectConstraintsEDM.getEntitySet());
//		entitySets.add(hrObjectsEDM.getEntitySet());
//		entitySets.add(hrObjectsStutusEDM.getEntitySet());
//		entitySets.add(hrP1000EDM.getEntitySet());
//		entitySets.add(hrP1001EDM.getEntitySet() );
//		entitySets.add(hrRelationsEDM.getEntitySet());
		entitySets.add(tenantEDM.getEntitySet( ));
		entityContainer.setEntitySets(entitySets);

//		List<AssociationSet> associationSets = new ArrayList<AssociationSet>();
//		associationSets.add(getAssociationSet(ENTITY_CONTAINER, ASSOCIATION_CAR_MANUFACTURER, ENTITY_SET_NAME_MANUFACTURERS, ROLE_1_2));
//		entityContainer.setAssociationSets(associationSets);

		entityContainers.add(entityContainer);
		schema.setEntityContainers(entityContainers);

		schemas.add(schema);

		return schemas;
	}

	
//	@Override
//	  public EntityType getEntityType(FullQualifiedName edmFQName) throws ODataException {
//	if (NAMESPACE.equals(edmFQName.getNamespace())) {

//	  if (ENTITY_TYPE_1_1.getName().equals(edmFQName.getName())) {
//
//	    //Properties
//	    List<Property> properties = new ArrayList<Property>();
//	    properties.add(new SimpleProperty().setName("Id").setType(EdmSimpleTypeKind.Int32).setFacets(new Facets().setNullable(false)));
//	    properties.add(new SimpleProperty().setName("Model").setType(EdmSimpleTypeKind.String).setFacets(new Facets().setNullable(false).setMaxLength(100).setDefaultValue("Hugo"))
//	        .setCustomizableFeedMappings(new CustomizableFeedMappings().setFcTargetPath(EdmTargetPath.SYNDICATION_TITLE)));
//	    properties.add(new SimpleProperty().setName("ManufacturerId").setType(EdmSimpleTypeKind.Int32));
//	    properties.add(new SimpleProperty().setName("Price").setType(EdmSimpleTypeKind.Decimal));
//	    properties.add(new SimpleProperty().setName("Currency").setType(EdmSimpleTypeKind.String).setFacets(new Facets().setMaxLength(3)));
//	    properties.add(new SimpleProperty().setName("ModelYear").setType(EdmSimpleTypeKind.String).setFacets(new Facets().setMaxLength(4)));
//	    properties.add(new SimpleProperty().setName("Updated").setType(EdmSimpleTypeKind.DateTime)
//	        .setFacets(new Facets().setNullable(false).setConcurrencyMode(EdmConcurrencyMode.Fixed))
//	        .setCustomizableFeedMappings(new CustomizableFeedMappings().setFcTargetPath(EdmTargetPath.SYNDICATION_UPDATED)));
//	    properties.add(new SimpleProperty().setName("ImagePath").setType(EdmSimpleTypeKind.String));
//
//	    //Navigation Properties
//	    List<NavigationProperty> navigationProperties = new ArrayList<NavigationProperty>();
//	    navigationProperties.add(new NavigationProperty().setName("Manufacturer")
//	        .setRelationship(ASSOCIATION_CAR_MANUFACTURER).setFromRole(ROLE_1_1).setToRole(ROLE_1_2));
//
//	    //Key
//	    List<PropertyRef> keyProperties = new ArrayList<PropertyRef>();
//	    keyProperties.add(new PropertyRef().setName("Id"));
//	    Key key = new Key().setKeys(keyProperties);
//
//	    return new EntityType().setName(ENTITY_TYPE_1_1.getName())
//	        .setProperties(properties)
//	        .setKey(key)
//	        .setNavigationProperties(navigationProperties);
//
//	  } else 
//		  
//		  if (ENTITY_TYPE_1_2.getName().equals(edmFQName.getName())) {
//
//	    //Properties
//	    List<Property> properties = new ArrayList<Property>();
//	    properties.add(new SimpleProperty().setName("Id").setType(EdmSimpleTypeKind.Int32).setFacets(new Facets().setNullable(false)));
//	    properties.add(new SimpleProperty().setName("Name").setType(EdmSimpleTypeKind.String).setFacets(new Facets().setNullable(false).setMaxLength(100))
//	        .setCustomizableFeedMappings(new CustomizableFeedMappings().setFcTargetPath(EdmTargetPath.SYNDICATION_TITLE)));
//	    properties.add(new ComplexProperty().setName("Address").setType(new FullQualifiedName(NAMESPACE, "Address")));
//	    properties.add(new SimpleProperty().setName("Updated").setType(EdmSimpleTypeKind.DateTime)
//	        .setFacets(new Facets().setNullable(false).setConcurrencyMode(EdmConcurrencyMode.Fixed))
//	        .setCustomizableFeedMappings(new CustomizableFeedMappings().setFcTargetPath(EdmTargetPath.SYNDICATION_UPDATED)));
//
//	    //Navigation Properties
//	    List<NavigationProperty> navigationProperties = new ArrayList<NavigationProperty>();
//	    navigationProperties.add(new NavigationProperty().setName("Cars")
//	        .setRelationship(ASSOCIATION_CAR_MANUFACTURER).setFromRole(ROLE_1_2).setToRole(ROLE_1_1));
//
//	    //Key
//	    List<PropertyRef> keyProperties = new ArrayList<PropertyRef>();
//	    keyProperties.add(new PropertyRef().setName("Id"));
//	    Key key = new Key().setKeys(keyProperties);
//
//	    return new EntityType().setName(ENTITY_TYPE_1_2.getName())
//	        .setProperties(properties)
//	        .setHasStream(true)
//	        .setKey(key)
//	        .setNavigationProperties(navigationProperties);
//	  } else 
//		  
//		  
//		  if (CaSystemEDM.ENTITY_TYPE_NAME.equals(edmFQName.getName())){
//		  //Properties
//		  List<Property> properties = new ArrayList<Property>();
//		  properties.add(new SimpleProperty().setName("sysId").setType(EdmSimpleTypeKind.String).setFacets(new Facets().setNullable(false)));
//		  properties.add(new SimpleProperty().setName("tenantId").setType(EdmSimpleTypeKind.Int32).setFacets(new Facets().setNullable(false)));
//		  properties.add(new SimpleProperty().setName("sysDesc").setType(EdmSimpleTypeKind.String).setFacets(new Facets().setNullable(true)));
//		  //Navigation  Properties
//		  
//		  //key
//		  List<PropertyRef> keyProperties = new ArrayList<PropertyRef>();
//		  keyProperties.add(new PropertyRef().setName("sysId"));
//		  keyProperties.add(new PropertyRef().setName("tenantId"));
//			
//		  Key key = new Key().setKeys(keyProperties);
//		  
//		  return new EntityType().setName(ENTITY_TYPE_CASYSTEM.getName())
//				  .setProperties(properties)
//				  .setHasStream(true)
//				  .setKey(key);
//		  
//		  
//	  }
//	}
//
//	return null;
//	}
	
//	public ComplexType getComplexType(FullQualifiedName edmFQName) throws ODataException {
//		if (NAMESPACE.equals(edmFQName.getNamespace())) {
//		  if (COMPLEX_TYPE.getName().equals(edmFQName.getName())) {
//		    List<Property> properties = new ArrayList<Property>();
//		    properties.add(new SimpleProperty().setName("Street").setType(EdmSimpleTypeKind.String));
//		    properties.add(new SimpleProperty().setName("City").setType(EdmSimpleTypeKind.String));
//		    properties.add(new SimpleProperty().setName("ZipCode").setType(EdmSimpleTypeKind.String));
//		    properties.add(new SimpleProperty().setName("Country").setType(EdmSimpleTypeKind.String));
//		    return new ComplexType().setName(COMPLEX_TYPE.getName()).setProperties(properties);
//		  }
//		}
//
//		return null;
//
//		}
//	
//	public Association getAssociation(FullQualifiedName edmFQName) throws ODataException {
//		if (NAMESPACE.equals(edmFQName.getNamespace())) {
//		  if (ASSOCIATION_CAR_MANUFACTURER.getName().equals(edmFQName.getName())) {
//		    return new Association().setName(ASSOCIATION_CAR_MANUFACTURER.getName())
//		        .setEnd1(new AssociationEnd().setType(ENTITY_TYPE_1_1).setRole(ROLE_1_1).setMultiplicity(EdmMultiplicity.MANY))
//		        .setEnd2(new AssociationEnd().setType(ENTITY_TYPE_1_2).setRole(ROLE_1_2).setMultiplicity(EdmMultiplicity.ONE));
//		  }
//		}
//		return null;
//		}
	
//	public EntityContainerInfo getEntityContainerInfo(String name) throws ODataException {
//		if (name == null || "ODataCarsEntityContainer".equals(name)) {
//		  return new EntityContainerInfo().setName("ODataCarsEntityContainer").setDefaultEntityContainer(true);
//		}
//
//		return null;
//		}
	
//	public EntitySet getEntitySet(String entityContainer, String name) throws ODataException {
//		if (ENTITY_CONTAINER.equals(entityContainer)) {
////		  if (ENTITY_SET_NAME_CARS.equals(name)) {
//		    return new EntitySet().setName(name).setEntityType(ENTITY_TYPE_1_1);
//		  } else if (ENTITY_SET_NAME_MANUFACTURERS.equals(name)) {
//		    return new EntitySet().setName(name).setEntityType(ENTITY_TYPE_1_2);
//		  } else 
//			  
//			  if (ENTITY_SET_NAME_CASYSTEMS.equals(name)){
//			  return new EntitySet().setName(name).setEntityType(ENTITY_TYPE_CASYSTEM);
//		  }
//		}
//		return null;
//		}
	
//	public AssociationSet getAssociationSet(String entityContainer, FullQualifiedName association, String sourceEntitySetName, String sourceEntitySetRole) throws ODataException {
//		if (ENTITY_CONTAINER.equals(entityContainer)) {
//		  if (ASSOCIATION_CAR_MANUFACTURER.equals(association)) {
//		    return new AssociationSet().setName(ASSOCIATION_SET)
//		        .setAssociation(ASSOCIATION_CAR_MANUFACTURER)
//		        .setEnd1(new AssociationSetEnd().setRole(ROLE_1_2).setEntitySet(ENTITY_SET_NAME_MANUFACTURERS))
//		        .setEnd2(new AssociationSetEnd().setRole(ROLE_1_1).setEntitySet(ENTITY_SET_NAME_CARS));
//		  }
//		}
//		return null;
//		}
//	
}
