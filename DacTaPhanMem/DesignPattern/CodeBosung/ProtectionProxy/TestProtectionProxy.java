 

public class TestProtectionProxy {

	public static void main(String[] args) {
		ReportGeneratorProxy report = new ReportGenerator ();
		Owner owner = new Owner();
		ReportGeneratorProxy reportGenerator = new ReportGeneratorProtectionProxy(report, owner);
		owner.setReportGenerator(reportGenerator);
		Employee employee = new Employee();
		reportGenerator = new ReportGeneratorProtectionProxy(report, employee);
		employee.setReportGenerator(reportGenerator);
		System.out.println("For owner:");
		System.out.println(owner.generateDailyReport());
		System.out.println("For employee:");
		System.out.println(employee.generateDailyReport());
		
	}

}
