$('i').attr('onClick', "$('.message').transition('swing down');$('button').removeAttr('disabled');");
$("button").click(function () {
    $('.form').addClass('loading');
    $.ajax({
        type: "POST",
        url: "Analyze.action",
        data: {"url": $("input").val()}, // 不用val()获取值会陷入死循环，具体表现为不断的发送请求
        success: function (msg) {
            $('.header').html('成功');
            $('#picUrl').html('封面图');
            $('.form').removeClass('loading');  
            $('.message').removeClass('error');
            $('.message').addClass('info');              
            $("#picUrl").attr("href", msg);
            $('.message').transition('swing down');
            $('button').attr('disabled', 'disabled');
        },
        error: function(e) {
            $('.header').html('发生错误');
            $('#picUrl').html('请检查网络连接');
            $('.form').removeClass('loading');  
            $('.message').removeClass('info');
            $('.message').addClass('error');
            $('.message').transition('swing down');
            $('button').attr('disabled', 'disabled');
        }
    });
});