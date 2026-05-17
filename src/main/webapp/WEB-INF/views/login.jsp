<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Đăng nhập</title>

<style>
body { font-family: Arial, sans-serif; background:#f5f7fb; }
.login-box { width:360px; margin:100px auto; background:#fff; padding:20px; border-radius:6px; box-shadow:0 2px 8px rgba(0,0,0,0.1); }
.error { color:#e74c3c; margin-bottom:10px; }
input { width:100%; padding:8px; margin-bottom:8px; border:1px solid #ccd6e0; border-radius:4px; }
.btn { padding:10px 16px; background:#3498db; color:#fff; border:none; border-radius:4px; cursor:pointer; }
</style>

<script>
function validateForm() {
    const u = document.getElementById('username').value.trim();
    const p = document.getElementById('password').value;

    if (!u || !p) {
        document.getElementById('clientErr').textContent = 'Vui lòng nhập username và mật khẩu';
        return false;
    }
    return true;
}
</script>

</head>

<body>

<div class="login-box">
    <h2>Đăng nhập</h2>

    <div id="clientErr" class="error"></div>

    <c:if test="${not empty error}">
        <div class="error">${error}</div>
    </c:if>

    <form method="post" action="${pageContext.request.contextPath}/login" onsubmit="return validateForm();">

        <input id="username" name="username" type="text" maxlength="50"
               placeholder="Tên đăng nhập" value="${param.username}">

        <input id="password" name="password" type="password"
               placeholder="Mật khẩu">

        <button type="submit" class="btn">Đăng nhập</button>

    </form>
</div>

</body>
</html>