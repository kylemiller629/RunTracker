<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header class="mm-navbar mb-4">

    <nav class="navbar navbar-expand-lg" data-bs-theme="dark">

        <div class="container">

            <a href="home" class="navbar-brand mm-brand">MileMarker</a>

            <button class="navbar-toggler" type="button"
                    data-bs-toggle="collapse"
                    data-bs-target="#mileMarkerNav"
                    aria-controls="mileMarkerNav"
                    aria-expanded="false"
                    aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="mileMarkerNav">

                <div class="navbar-nav ms-auto align-items-lg-center gap-lg-3">

                    <a href="home" class="nav-link mm-nav-link">Home</a>
                    <a href="viewRuns" class="nav-link mm-nav-link">Runs</a>
                    <a href="addRun.jsp" class="nav-link mm-nav-link">Add Run</a>
                    <a href="viewGoals" class="nav-link mm-nav-link">My Goals</a>
                    <a href="addGoal.jsp" class="nav-link mm-nav-link">Add Goal</a>

                    <c:choose>
                        <c:when test="${not empty sessionScope.userId}">
                            <form action="${pageContext.request.contextPath}/logout" method="post" class="m-0">
                                <button type="submit" class="btn btn-outline-light">Log Out</button>
                            </form>
                        </c:when>

                        <c:otherwise>
                            <a href="logIn" class="btn btn-primary">Log In</a>
                        </c:otherwise>
                    </c:choose>

                </div>
            </div>
        </div>
    </nav>
</header>

