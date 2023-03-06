<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../includes/head.jsp"/>
<body>
<jsp:include page="../includes/header.jsp"/>
<jsp:include page="../includes/nav.jsp"/>
LIST PAGE
<a href="../index">index</a>
<ul>
<c:forEach items="${paychecks}" var="paycheck">
    <li>${paycheck.paycheckName}</li>
</c:forEach>
</ul>
<p>This</p>
</body>
<jsp:include page="../includes/footer.jsp"/>