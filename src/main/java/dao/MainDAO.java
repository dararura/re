package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.UserDTO;

public class MainDAO {
	private Connection con;
	private ResultSet rs;
	private PreparedStatement pstmt;
	
	public MainDAO() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","TEST_USR","1234");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<UserDTO> getUserList(){
		List<UserDTO> list=new ArrayList<UserDTO>();
		String sql="SELECT * FROM tbl_cust_201004";
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				UserDTO userDTO=new UserDTO();
				userDTO.setP_no(rs.getString("p_no"));
				userDTO.setP_name(rs.getString("p_name"));
				userDTO.setP_birth(rs.getString("p_birth"));
				userDTO.setP_gender(rs.getString("p_gender"));
				userDTO.setP_tel1(rs.getString("p_tel1"));
				userDTO.setP_tel2(rs.getString("p_tel2"));
				userDTO.setP_tel3(rs.getString("p_tel3"));
				userDTO.setP_city(rs.getString("p_city"));
				list.add(userDTO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
