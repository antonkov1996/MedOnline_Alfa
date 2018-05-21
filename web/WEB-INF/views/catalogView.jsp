<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 5/21/18
  Time: 6:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="_header.jsp"></jsp:include>
<jsp:include page="_menu.jsp"></jsp:include>
<div id="content">
    <c:forEach items="${classificationList}" var="classification">
        <%--TODO Add attribute to request ot session--%>
        <a href="/catalog/${classification.id_class}"><button><c:set var="id_class" value="${classification.id_class}" scope="session"></c:set>${classification.description}</button></a><br>
    </c:forEach>

    <<br>
</div>
<jsp:include page="_footer.jsp"></jsp:include>

</body>
</html>
