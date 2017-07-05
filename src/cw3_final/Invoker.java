package cw3_final;

import java.util.ArrayList;
import java.util.List;

public class Invoker {
	
	private List<Request> requestList = new ArrayList<Request>(); 

	   public void takerequest(Request request){
	      requestList.add(request);		
	   }

	   public void placerequests(){
	   
	      for (Request request : requestList) {
	         request.execute();
	      }
	      requestList.clear();
	   }

}
