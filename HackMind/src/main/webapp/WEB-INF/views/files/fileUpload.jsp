<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/8
  Time: 9:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"  pageEncoding="utf-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
<form action="/file/fileUpload" method="post" enctype="multipart/form-data">

    <input type="file" name="file"/>

    <input type="submit" value="开始上传">

</form>
</body>
</html>
