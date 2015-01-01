package in.co.itasca.im.persistence.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: caSystems
 *
 */
@Entity

@IdClass( CaSystemsPk.class)
public class CaSystems implements IDBEntity{

	   
	
	
	@Id
	private String systId;
	@Id
	private Integer tenantId;
	
	private String systDesc;
	private static final long serialVersionUID = 1L;
//	@OneToMany(mappedBy = "caSystems")
//	private Collection<HrObjects> hrObjects;
	public CaSystems() {
		super();
	}   
	public String getSystId() {
		return this.systId;
	}

	public void setSystId(String systId) {
		this.systId = systId;
	}   
	public String getSystDesc() {
		return this.systDesc;
	}

	public void setSystDesc(String systDesc) {
		this.systDesc = systDesc;
	}
//	public Collection<HrObjects> getHrObjects() {
//	    return hrObjects;
//	}
//	public void setHrObjects(Collection<HrObjects> param) {
//	    this.hrObjects = param;
//	}
//   
	
	/**
	 * @return the tenantId
	 */
	public Integer getTenantId() {
		return tenantId;
	}
	/**
	 * @param tenantId the tenantId to set
	 */
	public void setTenantId(Integer tenantId) {
		this.tenantId = tenantId;
	}
}
