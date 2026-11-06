<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header class="bg-dark text-white py-3 mb-4">
    <div class="container">

        <nav class="d-flex align-items-center justify-content-between flex-wrap gap-3">

            <a href="home" class="text-white text-decoration-none fs-3 fw-bold">
                MileMarker
            </a>

            <div class="d-flex align-items-center flex-wrap gap-3">

                <a href="home" class="text-white text-decoration-none">Home</a>

                <c:if test="${not empty sessionScope.userId}">
                    <a href="viewRuns" class="text-white text-decoration-none">Runs</a>

                    <a href="addRun.jsp" class="text-white text-decoration-none">Add Run</a>

                    <a href="viewGoals" class="text-white text-decoration-none">My Goals</a>

                    <a href="addGoal.jsp" class="text-white text-decoration-none">Add Goal</a>
                </c:if>

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

    </div>
</header>

