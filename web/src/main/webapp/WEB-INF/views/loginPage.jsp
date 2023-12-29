<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>This or That</title>
	<link href="resources/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
   <%
      request.setCharacterEncoding("UTF-8");
      String id = request.getParameter("id");
      String pw = request.getParameter("pw");
   %>
   <jsp:useBean id="mgr" class="poll.PollMgr"/>
   <%
      String msg = "";
      boolean in = false;
      if(!mgr.checkId(id)) msg = "유효한 사용자가 아닙니다.";
      else{
         if(mgr.checkUser(id, pw)) {
            msg = "로그인 성공";
            in = true;
            session.setAttribute("id", id);

         }
         else msg = "비밀번호가 틀렸습니다.";
      }
   %>
   <script>
      alert("<%=msg%>");
      <%
         if(!in){
      %>
         location.href="loginForm.jsp";
      <% } else{%>
         location.href="afterLogin.jsp";
      <%}%>
   </script>
   <%

   %>
</body>
</html>