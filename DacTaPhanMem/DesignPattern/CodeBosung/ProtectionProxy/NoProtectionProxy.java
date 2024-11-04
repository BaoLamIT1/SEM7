 

public class NoProtectionProxy {

	public static void main(String[] args) {
		ReportGenerator report = new ReportGenerator ();
		Owner owner = new Owner();
		//ReportGeneratorProxy reportGenerator = new ReportGeneratorProtectionProxy(report, owner);
		owner.setReportGenerator(report);
		Employee employee = new Employee();
		//reportGenerator = new ReportGeneratorProtectionProxy(report, employee);
		employee.setReportGenerator(report);
		System.out.println("For owner:");
		System.out.println(owner.generateDailyReport());
		System.out.println("For employee:");
		System.out.println(employee.generateDailyReport());
		
	}

}
