<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>


</head>

<body>
	<%
		//Train ttt = (Train) request.getAttribute("tt");
	%>
	<form action="DoUpdateServlet" method="post">
		<table border="1px" align="center">

			<tr>
				<td colspan="2" align="center">火车车次详情</td>
			</tr>

			<tr>
				<td>车次</td>
				<td><input type="text" id="" name="trainNo"
					value="${tt.trainNo}"></td>
			</tr>
			<tr>
				<td>发车</td>
				<td><input type="text" id="startStation" name="startStation"
					value="${tt.startStation}"></td>
			</tr>
			<tr>
				<td>到达</td>
				<td><input type="text" id="arrivalStation"
					name="arrivalStation" value="${tt.arrivalStation}"></td>
			</tr>
			<tr>
				<td>发时</td>
				<td><input type="text" id="startTime" name="startTime"
					value="${tt.startTime}"></td>
			</tr>
			<tr>
				<td>到时</td>
				<td><input type="text" id="arrivalTime" name="arrivalTime"
					value="${tt.arrivalTime}"></td>
			</tr>
			<tr>
				<td>车型</td>
				<td><input type="text" id="type" name="type" value="${tt.type}"></td>
			</tr>
			<tr>
				<td>运行时间（小时）</td>
				<td><input name="runtime" id="runtime" type="text"
					value="${tt.runtime}"></td>
			</tr>
			<tr>
				<td>里程（公里）</td>
				<td><input type="text" id="mile" name="mile" value="${tt.mile}"></td>
			</tr>
			<tr align="center">
				<td colspan="2"><input type="submit" value="确认修改"></td>
			</tr>
		</table>
	</form>
</body>
</html>
