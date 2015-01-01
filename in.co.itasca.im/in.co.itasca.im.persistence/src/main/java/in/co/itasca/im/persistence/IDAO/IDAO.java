package in.co.itasca.im.persistence.IDAO;
 

public interface  IDAO<E>     {
	
	 public  String getidFieldName();
	
    public void refresh(E object);
	
	  

}
