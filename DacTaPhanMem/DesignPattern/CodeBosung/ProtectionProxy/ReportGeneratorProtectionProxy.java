 

import java.rmi.Naming;

//import com.javacodegeeks.patterns.proxypattern.remoteproxy.ReportGenerator;

public class ReportGeneratorProtectionProxy implements ReportGeneratorProxy{

    ReportGeneratorProxy reportGenerator;
    Staff staff;
    
    public ReportGeneratorProtectionProxy(ReportGeneratorProxy reportGenerator, Staff staff){
        this.reportGenerator = reportGenerator; 
        this.staff = staff;
    }
    public ReportGeneratorProtectionProxy(Staff staff){
        this.staff = staff;
    }

    @Override
    public String generateDailyReport()  {
        if(staff.isOwner()){   
                        try {
                return reportGenerator.generateDailyReport();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "";
        }
        else{
            return "Not Authorized to view report.";
        }
    }
}
