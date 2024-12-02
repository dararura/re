<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="dao.MainDAO" %>
<%@ page import="dto.UserDTO" %>
<%@ page import="java.util.*" %>
<%@ include file="include/header.jsp"%>
<table>
<thead>
	<tr>
		<td>고객번호</td>
		<td>고객명</td>
		<td>고객생년월일</td>
		<td>성별</td>
		<td>전화번호</td>
		<td>지역</td>
	</tr>
</thead>
<tbody>
	<%
	MainDAO mainDAO=new MainDAO();
	List<UserDTO> list=mainDAO.getUserList();
	for(UserDTO userDTO:list){
	%>
	<tr>
		<td><%=userDTO.getP_no() %></td>
		<td><%=userDTO.getP_name() %></td>
		<td></td>
		<td><%=userDTO.getP_gender().equals("M")?"남":"여"%></td>
		<td><%=userDTO.getP_tel1()%>-<%=userDTO.getP_tel2()%>-<%=userDTO.getP_tel3() %></td>
		<td>
			<%switch(userDTO.getP_city()){
			case "10" : return "서울";
			}
			%>
			
		</td>
	</tr>
	<%} %>
</tbody>
</table>
<%@ include file="include/footer.jsp"%>