 

public class AccessControl implements Prototype{
	
	private final String controlLevel;
	private String access;
	private Date date;
	private Desc desc;
	
	public AccessControl(String controlLevel,String access, Date date, Desc desc){
		this.controlLevel = controlLevel;
		this.access = access;
		this.date = date;
		this.desc = desc;
	}
	
	@Override
	public AccessControl clone(){
		try {
			return (AccessControl) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String getControlLevel(){
		return controlLevel;
	}

	public String getAccess() {
		return access;
	}

	public Date getDate() {
		return date;
	}
	
	public void setAccess(String access) {
		this.access = access;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public void setDesc(Desc desc) {
		this.desc = desc;
	}
	public Desc getDesc() {
		return desc;
	}
}
