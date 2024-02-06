package it.aips.aaBootJpaHibernate.DTO;

public class AddressDto {

	private int id;
	private String lane1; 
	private String state;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLane1() {
		return lane1;
	}
	public void setLane1(String lane1) {
		this.lane1 = lane1;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
}
