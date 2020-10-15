package dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DBClose;
import db.DBConnection;


public class OrderDto {
	
	private int seq;
	private String id;
	private String menu;
	private String syrup;
	private String shot;
	private String wheeping;
	private String size;
	private int cup;
	private int price;
	private String wdate;
	
	public OrderDto() {
		
	}
	public OrderDto(int seq, String id, String menu, String syrup, String shot, String wheeping, String size, int cup,
			int price, String wdate) {
		super();
		this.seq = seq;
		this.id = id;
		this.menu = menu;
		this.syrup = syrup;
		this.shot = shot;
		this.wheeping = wheeping;
		this.size = size;
		this.cup = cup;
		this.price = price;
		this.wdate = wdate;
	}
	


	public OrderDto(String id, String menu, String syrup, String size, String shot, String wheeping, int cup,
	int price) {

		super();
		this.id = id;
		this.menu = menu;
		this.syrup = syrup;
		this.size = size;
		this.shot = shot;
		this.wheeping = wheeping;
		this.cup = cup;
		this.price = price;
		//this.wdate = wdate;

	}
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public String getSyrup() {
		return syrup;
	}
	public void setSyrup(String syrup) {
		this.syrup = syrup;
	}
	public String getShot() {
		return shot;
	}
	public void setShot(String shot) {
		this.shot = shot;
	}
	public String getWheeping() {
		return wheeping;
	}
	public void setWheeping(String wheeping) {
		this.wheeping = wheeping;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public int getCup() {
		return cup;
	}
	public void setCup(int cup) {
		this.cup = cup;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getWdate() {
		return wdate;
	}
	public void setWdate(String wdate) {
		this.wdate = wdate;
	}
	@Override
	public String toString() {
		return "                      " +menu + "\t\t            " + syrup + "\t                " +size  
				+ "\t                      " + shot  + "\t\t" + wheeping + "\t     " +cup + "\t" +price ; 
	}
	
	
	
}




