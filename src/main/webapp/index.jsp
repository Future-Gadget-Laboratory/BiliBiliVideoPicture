<%--
  Created by IntelliJ IDEA.
  User: smallclover
  Date: 2017/9/4
  Time: 1:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>Bootstrap 101 Template</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-lg-6 col-md-offset-3">
            <form class="" role="form">
                <div class="form-group">
                    <label for="name">请输入视频地址</label>
                    <div class="input-group">
                        <input type="text" name="url" id="url" class="form-control" placeholder="Search For..."/>
                        <span class="input-group-btn">
                            <button type="button" name="submit" id="submit" class="btn btn-default"
                                    value="submit">Go!</button>
                        </span>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-6  col-md-offset-3">
            <a id="picUrl" href="#" rel="noreferrer">封面地址</a>
        </div>
    </div>
</div>
<script type="text/javascript">
    $("#submit").click(function () {
        $.ajax({
            type: "POST",
            url: "Analyze.action",
            data: {"url": $("#url").val()},//不用val()获取值会陷入死循环，具体表现为不断的发送请求
            success: function (msg) {
                $("#picUrl").attr("href", msg);
            }
        });
    });
</script>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery-3.2.1.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
</body>
</html>

