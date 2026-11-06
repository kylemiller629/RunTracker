
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header class="mm-navbar py-3 mb-4">

    <nav class="container d-flex align-items-center justify-content-between flex-wrap gap-3">

        <h1 class="m-0">
            <a href="home" class="mm-brand">MileMarker</a>
        </h1>

        <div class="d-flex align-items-center flex-wrap gap-3">

            <a href="home" class="mm-nav-link">Home</a>
            <a href="viewRuns" class="mm-nav-link">Runs</a>
            <a href="addRun.jsp" class="mm-nav-link">Add Run</a>
            <a href="viewGoals" class="mm-nav-link">My Goals</a>
            <a href="addGoal.jsp" class="mm-nav-link">Add Goal</a>

            <c:choose>
                <c:when test="${not empty sessionScope.userId}">
                    <form action="${pageContext.request.contextPath}/logout" method="post" class="m-0">
                        <button type="submit" class="btn btn-outline-light">
                            Log Out
                        </button>
                    </form>
                </c:when>

                <c:otherwise>
                    <a href="logIn" class="btn btn-primary">Log In</a>
                </c:otherwise>
            </c:choose>

        </div>

    </nav>

</header>

