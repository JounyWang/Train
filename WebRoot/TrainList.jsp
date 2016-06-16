<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script src="js/jquery.min.js"></script>
<script type="text/javascript">
	//复选框全选  	
	var formvalue = "selectFlag";
	var array = new Array(); //用于保存 选中的那一条数据的ID   
	function checkAll() {
		var roomids = document.getElementsByName("selectFlag");
		for (var j = 0; j < roomids.length; j++) {
			if (roomids.item(j).checked == false) {
				array.push(roomids.item(j).value);
				roomids.item(j).checked = true;
			}
		}

		if (confirm("确定删除当前页吗？")) {
			delAll(array);
		}
	}
	function delAll(array) {
		location.href = "delAll?array=" + array;

	}
	//复选框全不选  
	function uncheckAll() {
		var roomids = document.getElementsByName("selectFlag");
		for (var j = 0; j < roomids.length; j++) {
			if (roomids.item(j).checked == true) {
				roomids.item(j).checked = false;
			}
		}
	}
</script>
<script type="text/javascript">
	function checkDelete() {
		var msg = "确定要删除吗？";
		if (confirm(msg) == true) {
			return true;
		} else {
			return false;
		}
	}
	document.onkeydown = keyListener;
	function keyListener(e) {
		if (e.keyCode == 13) {
			search();
		}

	}

	function search() {
		var trainNumber = document.getElementById("trainNumber").value;
		location.href = "trainList?trainNumber=" + trainNumber + "";
	}

	function nextPage() {
		var url = "trainList?currentPage=" + "${pu.page.nextPage}";
		location.href = url;
	}
	function prePage() {
		var url = "trainList?currentPage=" + "${pu.page.prePage}";
		location.href = url;
	}
	function endPage() {
		var url = "trainList?currentPage=" + "${pu.page.endPage}";
		location.href = url;
	}
	function indexPage() {
		var url = "trainList";
		location.href = url;
	}
</script>
</head>
<body>
	<form action="" method="post">
		<br>
		<div align="center">
			<input type="button" value="首页" onclick="indexPage()"> <input
				type="button" value="上一页" onclick="prePage()"> <input
				type="button" value="下一页" onclick="nextPage()"> <input
				type="button" value="末页" onclick="endPage()"><input
				id="trainNumber" type="text" placeholder="输入车次"> <input
				type="button" value="搜索" onclick="search()"> <input
				type="button" value="新增" onclick="location.href = 'toAdd'">
			<input type="radio" name="selectFlag" id="selectFlag"
				onclick="checkAll()" />批量删除 <input type="radio" id="selectFlag"
				onclick="uncheckAll()" />取消全选
		</div>

		<br>
		<table border="1px" align="center">
			<tr align="center">
				<td>编号</td>
				<td>车次</td>
				<td>发车-到达</td>
				<td>发时-到时</td>
				<td>车型</td>
				<td>运行时间（小时）</td>
				<td><input type="checkbox" value=""></td>
				<td colspan="2">操作</td>

			</tr>
			<c:forEach items="${pu.list}" var="tra" varStatus="i">
				<tr align="center"
					<c:if test="${(i.index+1)%2==0}">style="background-color:#ccc"</c:if>>
					<td>${i.index+1}</td>
					<td>${tra.trainNo}</td>
					<td>${tra.startStation}-${tra.arrivalStation}</td>
					<td>${tra.startTime}-${tra.arrivalTime}</td>
					<td>${tra.type}</td>
					<td>${tra.runtime}</td>
					<td><input type="checkbox" id="selectFlag" name="selectFlag"
						value="${tra.trainNumber}"></td>
					<td><a href="find?trainNumber=${tra.trainNumber}">修改 / 详情</a></td>
					<td><a href="delTrain?trainNumber=${tra.trainNumber}"
						onclick="javascript:return checkDelete()">删除</a></td>
				</tr>
			</c:forEach>
		</table>


	</form>
	<div align="center">
		每页3条数据,共 <strong style="color: red">${recordNum}</strong> 条列车信息
	</div>
</body>
</html>
