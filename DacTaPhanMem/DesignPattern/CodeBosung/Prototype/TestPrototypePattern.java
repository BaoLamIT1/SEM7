 

public class TestPrototypePattern {

	public static void main(String[] args) {
		AccessControl userAccessControl = AccessControlProvider.getAccessControlObject("USER");
		User userA = new User("User A", "USER Level", userAccessControl);
		
		System.out.println("************************************");
		System.out.println(userA);
		
		userAccessControl = AccessControlProvider.getAccessControlObject("USER");
		User userB = new User("User B", "USER Level", userAccessControl);
		System.out.println("Changing access control of: "+userB.getUserName());
		userB.getAccessControl().setAccess("READ REPORTS");
		userB.getAccessControl().setDate(new Date(12, 1, 2021));
		Desc desc = userB.getAccessControl().getDesc();
		desc.setDescription("Assistant");
		userB.getAccessControl().setDesc(desc);
		System.out.println(userB);
		
		System.out.println("************************************");
		System.out.println(userA);
		
		System.out.println("************************************");
		AccessControl managerAccessControl = AccessControlProvider.getAccessControlObject("MANAGER");
		User user = new User("User C", "MANAGER Level", managerAccessControl);
		System.out.println(user);
	}
}
