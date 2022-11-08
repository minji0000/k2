<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> 글 상세보기</title>
</head>
<body>

<table>
    <tr>
        <th> 글 번호: ${boardId } </th>
    </tr>
    <tr>
        <th> 글 제목: ${b.title }  </th>
    </tr>
    <tr>
        <th> 작성자: ${nickname } </th>
    </tr>

    <tr>
       <th> 수정일: <fmt:formatDate value="${b.updatedDate.time }"
                        pattern="yy년 m월 dd일 HH시 mm분 ss초"/></th>
    </tr>
    <tr>
       <th> 작성일: <fmt:formatDate value="${b.writtenDate.time }"
                         pattern="yy년 m월 dd일 HH시 mm분 ss초"/></th>
    </tr>
    <tr>
        <th> ${b.content } </th>
    </tr>
</table>


<!--  == eq, ne != 같은 -->
<c:if test="${b.writerId eq logInId }">

    <a href="/board/update/${b.boardId}"> 수정하기 </a>
    <a href="/board/delete/${b.boardId}"> 삭제하기 </a>

</c:if>

<br/>
<a href="/board/selectAll"> 목록으로 </a>

</body>
</html>