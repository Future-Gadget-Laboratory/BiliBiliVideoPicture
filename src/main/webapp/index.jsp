<%--
  Created by IntelliJ IDEA.
  User: smallclover
  Date: 2017/9/4
  Time: 1:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
</head>
<body>
<h2>传入需要解析的视频链接地址</h2>
<form>
    <input type="text" name="url" id="url"/>
    <input type="button" name="submit" id="submit" value="submit"/>
</form>
<div class="content" id="content">
    <img id="picUrl" src="#" alt="封面地址"/>
    <a id="picUrl2" href="#" rel="noreferrer">封面地址</a>
</div>
<script type="text/javascript">
    $("#submit").click(function () {
        $.ajax({
            type:"POST",
            url:"Analyze.action",
            data:{"url":$("#url").val()},//不用val()获取值会陷入死循环，具体表现为不断的发送请求
            success:function (msg) {
                $("#picUrl").attr("src", msg);
                $("#picUrl2").attr("href", msg);
            }
        });
    });
</script>
</body>
</html>

