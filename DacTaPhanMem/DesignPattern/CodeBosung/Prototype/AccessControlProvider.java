 

import java.util.HashMap;
import java.util.Map;

public class AccessControlProvider {

	private static Map<String, AccessControl>map = new HashMap<String, AccessControl>();
	
	static{
		
		System.out.println("Fetching data from external resources and creating access control objects...");
		map.put("USER", new AccessControl("USER","DO_WORK", new Date(11, 30, 2021), new Desc("Employer")));
		map.put("ADMIN", new AccessControl("ADMIN","ADD/REMOVE USERS", new Date(11, 30, 2021), new Desc("Adminstrator")));
		map.put("MANAGER", new AccessControl("MANAGER","GENERATE/READ REPORTS", new Date(11, 30, 2021),new Desc("Manager")));
		map.put("VP", new AccessControl("VP","MODIFY REPORTS", new Date(11, 30, 2021), new Desc("Boss")));
	}
	
	public static AccessControl getAccessControlObject(String controlLevel){
		AccessControl ac = null;
		ac = map.get(controlLevel);
		if(ac!=null){
			return ac.clone();
		}
		return null;
	}
}
