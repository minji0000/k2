<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> 게시판 </title>
</head>
<body>

 <div>
    <table>
        <thead>
            <tr>
                <th>글번호</th>
                <th>글제목</th>
                <th>작성자</th>
            </tr>
        </thead>
        <c:forEach items="${list}" var="b">
                    <tr>
                        <td>${b.boardId}</td>
                        <td onclick="location.href ='/board/showOne/${b.boardId}'">${b.title}</td>
                        <td>${nicknameMap[b.writerId]}</td>
                    </tr>
        </c:forEach>
    </table>

    <button onclick="location.href ='/board/write'">글 작성하기</button>

        <div class="row">
            <div class="col">
                <a href='/board/showAll/1'> [<<] </a>

                <c:forEach begin="1" end="5" var="pageNo">

                    <c:choose>
                        <c:when test="${pageNo ne currentPage }">
                            <a href="/board/showAll/${pageNo }">${pageNo }</a>
                        </c:when>

                        <c:when test="${pageNo > lastPageNo }">
                            <script>
                                alert("없는 페이지입니다.");
                                location.href="/board/showAll/${lastPageNo}"
                            </script>

                        </c:when>

                        <c:otherwise>
                            <b> ${pageNo }</b>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>

                <a href='/board/showAll/${lastPageNo }'> [>>] </a>
            </div>
        </div>




 </div>

</body>
</html>