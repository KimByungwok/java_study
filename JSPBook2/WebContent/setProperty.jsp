<%@ page contentType="text/html; charset=utf-8"%>

<html>
<head>
<title>Action Tag</title>
</head>
<body>
	<jsp:useBean id="person" class="ch04.com.dao.Person" scope="request"/>
	<jsp:setProperty name="person" property="id" value="20182005"/>
	<jsp:setProperty name="person" property="name" value="홍길동"/>
	
	
	<P>아이디 : <%out.println(person.getId()); %>
	<P>이름 : <%out.println(person.getName()); %>
	
</body>
</html>