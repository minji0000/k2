<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원가입</title>
</head>
<body>
<center>
    <form method="post" action="/user/register">
      아이디 <input type ="text" name ="username">
      <br><br>
      비밀번호 <input type ="password" name ="password">
      <br><br>
      닉네임 <input type ="text" name ="nickname">
            <br><br>
      <button type="submit">회원가입</button>
    </form>

</center>
</body>
</html>