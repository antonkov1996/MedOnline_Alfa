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
        <p>${classification.description}</p>
    </c:forEach>

</div>
<jsp:include page="_footer.jsp"></jsp:include>

</body>
</html>
