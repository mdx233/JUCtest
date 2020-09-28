<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" +
            request.getServerName() + ":" + request.getServerPort() +
            request.getContextPath() + "/";
%>
<html>
<head>
    <title>Title</title>
    <base href="<%=basePath%>" />
</head>
<body>

    <p>文件上传器</p>
    <form action="upload" enctype="multipart/form-data" method="post">
        文件：<input type="file" name="file"> <br/>
        <input type="submit" value="提交请求">
    </form>


</body>
</html>
