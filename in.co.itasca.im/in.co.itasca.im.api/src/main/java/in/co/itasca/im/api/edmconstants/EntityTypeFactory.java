package au.com.redbackconsulting.moc.odata.api.edmconstants;

import org.apache.olingo.odata2.api.edm.provider.EntityType;

public class EntityTypeFactory {
	
	private String namespace =null;
	public  int entity_type_caSystem =1;
	public  int entity_type_HrHier =2;
	public  int entity_type_HrHierMap =3;
	public  int entity_type_HrObjectRel =4;
	public  int entity_type_HrObjectConstraints =5;
	public  int entity_type_HrObjects =6;
	public  int entity_type_HrObjectStatus =7;
	public  int entity_type_Hrp1000 = 8;
	public  int entity_type_Hrp1001 =9;
	public  int entity_type_HrRelations =10;
	public  int entity_type_Tenants =11;
	
	private EntityTypeFactory(String namespace){
		this.namespace=namespace;
	}
	
	public static EntityTypeFactory getInstance (String namespace){
		
		return new EntityTypeFactory(namespace);
	}

	public BaseEDM getEDM (int entity_name){
		
		switch (entity_name) {
		case 1:
			return new CaSystemEDM(this.namespace) ;
 
		case 2:
			return new HrHierEDM(this.namespace);
		case 3:
			return new HrHierMapEDM(this.namespace);
		case 4:
			return new HrObjectRelEDM(this.namespace);
		case 5:
			return new HrObjectsConstraintsEDM(this.namespace);
		case 6:
			return new HrObjectsEDM(this.namespace);
		case 7:
			return new HrObjectsStatusEDM(this.namespace);
		case 8:
			return new HRP1000EDM(this.namespace);
		case 9:
			return new HRP1001EDM(this.namespace);
		case 10:
			return new HrRelationsEDM(this.namespace);
		case 11:
			return new TenantsEDM(this.namespace);
 

		default:
			break;
		}
		return null;
	}
}
