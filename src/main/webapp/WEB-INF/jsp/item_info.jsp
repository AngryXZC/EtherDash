<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>我是内容页</h3>
	<input type="text" value="${item.item_id }">
	<input type="text" value="${item.item_name }">
	<input type="button" value="返回" onclick="window.location='${pageContext.request.contextPath}/item/allList.do'">
</body>
</html>