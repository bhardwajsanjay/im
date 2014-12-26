package in.co.itasca.im.persistence.model;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Menu
 *
 */
@Entity

public class Menu implements Serializable {

	   
	@Id
	private Integer id;

	private String menuLabel;
	private String menuName;

	
	private static final long serialVersionUID = 1L;

	public Menu() {
		super();
	}   
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getMenuLabel() {
		return this.menuLabel;
	}

	public void setMenuLabel(String menuLabel) {
		this.menuLabel = menuLabel;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
   
	@OneToMany
	@JoinColumn(name="parentId")
	private List<Menu> subMenus;

	public List<Menu> getSubMenus() {
		return subMenus;
	}
	public void setSubMenus(List<Menu> subMenus) {
		this.subMenus = subMenus;
	}
}
