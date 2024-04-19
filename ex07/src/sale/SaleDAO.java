package sale;

import java.sql.*;
import java.util.ArrayList;

import product.Database;

public class SaleDAO {
	Connection con = Database.CON;
	
	// 매출등록
	public void insert(SaleVO vo) {
		String sql = "INSERT INTO sale VALUES(SEQ_SALE.NEXTVAL, ?, ?, ?, ?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getCode());
			pstmt.setString(2, vo.getSale_date());
			pstmt.setInt(3, vo.getCnt());
			pstmt.setInt(4, vo.getPrice());
			pstmt.execute();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("매출등록 : " + e.toString());
		}
	}
	
	// 매출현황
	public ArrayList<SaleVO> list() {
		ArrayList<SaleVO> array = new ArrayList<SaleVO>();
		String sql = "SELECT * FROM view_sales";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				SaleVO vo = new SaleVO();
				vo.setSale_date(rs.getString("sale_date"));
				vo.setCode(rs.getString("code"));
				vo.setName(rs.getString("name"));
				vo.setCnt(rs.getInt("total_sum"));
				vo.setPrice(rs.getInt("total"));
				array.add(vo);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("매출현황 : " + e.toString());
		}
		return array;
	}
}
