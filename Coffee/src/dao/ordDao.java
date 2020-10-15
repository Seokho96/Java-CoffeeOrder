package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DBClose;
import db.DBConnection;

import dto.OrderDto;

public class ordDao {
	
	private String id;
	private String menu;
	private String syrup;
	private String shot;
	private String wheeping;
	private String size;
	private int cup;
	private int price;
	
	private static ordDao dao = null;
	
	String price2;
	int i = 1;
	public static ordDao getInstance() {
		if(dao == null) {
			dao = new ordDao();
		}
		return dao;
	}
	public String priceCheck(String cof_name) {
		
		String sql = "  SELECT COF_PRICE "
				+ " FROM COFFEEMENU "
				+ " WHERE COF_NAME =  ?  ";
	
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	
			
	try {
		conn = DBConnection.getConnection();	// db 정보
		
		psmt = conn.prepareStatement(sql);		// query 적용
		psmt.setString(1, cof_name);
		
		rs = psmt.executeQuery(); 				// db로부터 데이터를 취득
		
		if(rs.next()) {		// id 있음
			
			price2 = rs.getString("COF_PRICE");
					
		}		
	
	} catch (Exception e) {			
		e.printStackTrace();
	} finally {
		DBClose.close(psmt, conn, rs);			
	}

	return price2;
	}
	
	public List<OrderDto> getOrderlist() {
		
		
		
		String sql =
				" SELECT ID, COF_NAME, SYRUP, SHOT, WHEEPING, CO_SIZE, CUP, PRICE "
				+ " FROM ORDERLIST "
				+ " WHERE SEQ = ( SELECT CO_SEQ.NEXTVAL"+ 
				                 " FROM USER_SEQUENCES "+
				                 " WHERE SEQUENCE_NAME = 'CO_SEQ2' ) ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		List<OrderDto> list = new ArrayList<OrderDto>();		
		
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
		    
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString("ID");
				String menu = rs.getString("COF_NAME");
				String syrup = rs.getString("SYRUP");
				String shot = rs.getString("SHOT");
				String wheeping = rs.getString("WHEEPING");
				String size = rs.getString("CO_SIZE");
				String cup = rs.getString("CUP");
				String price = rs.getString("PRICE");
				
				list.add(new OrderDto(id, menu, syrup, size, shot, wheeping, Integer.parseInt(cup), Integer.parseInt(price)));
			}			
			
		} catch (Exception e) {			
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);			
		}
		
		return list;
	}
	
	
	public boolean orderList(OrderDto dto) {
		
		String sql = " INSERT INTO ORDERLIST(SEQ, ID, COF_NAME, SYRUP, SHOT, WHEEPING, CO_SIZE, CUP, PRICE, WDATE) "
				+ " VALUES(CO_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE) ";
	
		Connection conn = null;
		PreparedStatement psmt = null;
		
		System.out.println("sql:" + sql);
		
		int count = 0;
		
		try {
			conn = DBConnection.getConnection();
			
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getMenu());
			psmt.setString(3, dto.getSyrup());
			psmt.setString(4, dto.getShot());
			psmt.setString(5, dto.getWheeping());
			psmt.setString(6, dto.getSize());
			psmt.setInt(7, dto.getPrice());
			psmt.setInt(8, dto.getCup());
			
			
			
			this.menu = dto.getMenu();
			this.syrup = dto.getSyrup();
			this.price = dto.getPrice();
			this.size = dto.getSize();
			this.shot = dto.getShot();
			this.wheeping = dto.getWheeping();
			this.cup = dto.getCup();
			
			count = psmt.executeUpdate();
			
		} catch (Exception e) {			
			e.printStackTrace();
		} finally {		
			DBClose.close(psmt, conn, null);			
		}		
		
		return count>0?true:false;
	}
	
	public String toString() {
		return "                      " +menu + "\t\t            " + syrup + "\t                " +size  
				+ "\t                      " + shot  + "\t\t" + wheeping + "\t     " +cup + "\t" +price ; 
	}

	
}
