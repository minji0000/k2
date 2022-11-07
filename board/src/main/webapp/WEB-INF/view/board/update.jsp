<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> 글 수정하기 </title>
</head>
<body>

    <h2> 글을 작성해주세요.</h2>

    <form method="post" action="/board/update/${boardId}">
        제목 <input type="text" name = "title">
        <br>
        내용 <input type="text" name = "content">
        <br>
        <button type = "submit"> 글 수정하기 </button>
    </form>
</body>
</html>