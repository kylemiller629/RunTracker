<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<header>
    <h1>MileMarker</h1>

    <nav>
        <a href="home">Home</a>
        <a href="viewRuns">Runs</a>
        <a href="addRun.jsp">Add Run</a>
        <a href="viewGoals">My Goals</a>
        <a href="addGoal.jsp">Add Goal</a>
        <c:choose>
            <c:when test="${not empty sessionScope.userId}">
                <form action="${pageContext.request.contextPath}/logout" method="post">
                    <button type="submit">Log Out</button>
                </form>
            </c:when>
            <c:otherwise>
                <a href="logIn">Log In</a>
            </c:otherwise>
        </c:choose>
    </nav>
</header>

