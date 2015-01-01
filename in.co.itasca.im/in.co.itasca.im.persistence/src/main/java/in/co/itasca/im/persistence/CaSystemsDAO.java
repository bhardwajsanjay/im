package in.co.itasca.im.persistence;
 
 

import in.co.itasca.im.persistence.manager.PersistenceManager;
import in.co.itasca.im.persistence.model.CaSystems;
import in.co.itasca.im.persistence.model.CaSystemsPk;

public class CaSystemsDAO extends BasicDAO<CaSystems> {
	
	public CaSystemsDAO(){
		
		 super(PersistenceManager.getInstance().getEntityManagerProvider());

	}

	
	public 	 CaSystems  getPK (CaSystemsPk pk){
		return null;
		
	}
	 
	@Override
	public String getidFieldName() {
		// TODO Auto-generated method stub
		return null;
	}

 
	 

}
