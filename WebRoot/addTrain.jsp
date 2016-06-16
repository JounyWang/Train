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
	<form action="addTrain">
		<table border="1px" align="center">

			<tr>
				<td colspan="2" align="center">添加列车</td>
			</tr>

			<tr>
				<td>车次</td>
				<td><input id="trainNo" name="trainNo" type="text"></td>
			</tr>
			<tr>
				<td>发车</td>
				<td><input id="startStation" name="startStation" type="text"></td>
			</tr>
			<tr>
				<td>到达</td>
				<td><input id="arrivalStation" name="arrivalStation"
					type="text"></td>
			</tr>
			<tr>
				<td>发时</td>
				<td><input id="startTime" name="startTime" type="text"></td>
			</tr>
			<tr>
				<td>到时</td>
				<td><input id="arrivalTime" name="arrivalTime" type="text"></td>
			</tr>
			<tr>
				<td>车型</td>
				<td><input id="type" name="type" type="text"></td>
			</tr>
			<tr>
				<td>运行时间（小时）</td>
				<td><input id="runtime" name="runtime" type="text"></td>
			</tr>
			<tr>
				<td>里程（公里）</td>
				<td><input id="mile" name="mile" type="text"></td>
			</tr>
			<tr>
				<td align="center"><input type="button" value="回到首页"
					onclick="location.href='trainList'"></td>

				<td align="center"><input type="submit" value="提交"></td>
			</tr>
		</table>

	</form>
</body>
</html>
