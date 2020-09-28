<%@ page  contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>文件上传测试</h2>


<form action="/upload1" enctype="multipart/form-data" method="post">
    <input type="file" name="file"/>
    <input type="submit" value="上传">
</form>
<a href="/download">下载文件</a>
</body>
</html>
