 


import java.util.Date;

public class ReportGenerator  implements ReportGeneratorProxy {

		protected ReportGenerator() {
	}

	@Override
	public String generateDailyReport() {
		StringBuilder sb = new StringBuilder();
		sb.append("********************Location X Daily Report********************");
		sb.append("\n Location ID: 012");
		sb.append("\n Today's Date: "+new Date());
		sb.append("\n Total Pizza Sell: 112");
		sb.append("\n Total Sale: $2534");
		sb.append("\n Net Profit: $1985");
		sb.append("\n ***************************************************************");
		return sb.toString();
	}
	

}
