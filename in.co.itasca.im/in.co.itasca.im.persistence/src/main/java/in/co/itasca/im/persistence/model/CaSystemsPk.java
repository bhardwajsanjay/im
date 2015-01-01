package in.co.itasca.im.persistence.model;

import java.io.Serializable;

public class CaSystemsPk implements   Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private Integer tenantId;
private String systId;
/* (non-Javadoc)
 * @see java.lang.Object#hashCode()
 */
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((systId == null) ? 0 : systId.hashCode());
	result = prime * result + ((tenantId == null) ? 0 : tenantId.hashCode());
	return result;
}
/* (non-Javadoc)
 * @see java.lang.Object#equals(java.lang.Object)
 */
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	CaSystemsPk other = (CaSystemsPk) obj;
	if (systId == null) {
		if (other.systId != null)
			return false;
	} else if (!systId.equals(other.systId))
		return false;
	if (tenantId == null) {
		if (other.tenantId != null)
			return false;
	} else if (!tenantId.equals(other.tenantId))
		return false;
	return true;
}
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
/**
 * @return the systId
 */
public String getSystId() {
	return systId;
}
/**
 * @param systId the systId to set
 */
public void setSystId(String systId) {
	this.systId = systId;
}
}
