<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<%@ include file="/common/common.jsp" %>
    <title>支付页面</title>
</head>
<%
	String result = (String)request.getAttribute("sHtmlText");
	out.println(result);
 %>
<body>

</body>
</html>
