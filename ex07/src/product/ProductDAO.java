package product;

import java.sql.*;
import java.util.ArrayList;

public class ProductDAO implements ProductInter {
	Connection con = Database.CON;
	
	@Override
	public ArrayList<ProductVO> list() {
		// TODO Auto-generated method stub
		ArrayList<ProductVO> array = new ArrayList<>();
		String sql = "SELECT * FROM PRODUCT ORDER BY code";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductVO vo = new ProductVO();
				vo.setCode(rs.getString("code"));
				vo.setName(rs.getString("name"));
				vo.setPrice(rs.getInt("price"));
				array.add(vo);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("상품목록 : " + e.toString());
		}
		return array;
	}

	@Override
	public void insert(ProductVO vo) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO PRODUCT (code, name, price) values (?, ?, ?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getCode());
			pstmt.setString(2, vo.getName());
			pstmt.setInt(3, vo.getPrice());
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean delete(String code) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM PRODUCT WHERE code = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, code);
			pstmt.execute();
			System.out.println("\n✔ 삭제가 완료되었습니다.");
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("상품삭제 : " + e.toString());
			return false;
		}
	}

	@Override
	public void update(ProductVO vo) {
		// TODO Auto-generated method stub
		String sql = "UPDATE PRODUCT SET name = ?, price = ? WHERE code = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getPrice());
			pstmt.setString(3, vo.getCode());
			pstmt.execute();
			System.out.println("\n✔ 수정이 완료되었습니다.\n");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("상품수정 : " + e.toString());
		}
		
	}

	@Override
	public ProductVO read(String code) {
		// TODO Auto-generated method stub
		ProductVO vo = new ProductVO();
		String sql = "SELECT * FROM PRODUCT WHERE code = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, code);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				vo.setCode(rs.getString("code"));
				vo.setName(rs.getString("name"));
				vo.setPrice(rs.getInt("price"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("상품조회 : " + e.toString());
		}
		return vo;
	}

	@Override
	public String getCode() {
		// TODO Auto-generated method stub
		String code = "";
		String sql = "SELECT MAX(code)+1 AS code FROM PRODUCT";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				code = rs.getString("code");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("새로운 코드 : " + e.toString());
		}
		return code;
	}
}
