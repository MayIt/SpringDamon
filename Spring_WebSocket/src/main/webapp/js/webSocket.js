var ws="";
$(function() {
    console.log("abc");
    $.ajax({url:"http://localhost:8080/login/4",success:function(result){
        console.log(result);
         ws = new WebSocket("ws://localhost:8080/myHandler")
        ws.onopen = function () {
            console.log("onpen");
            ws.send("{}");
            setMessageInnerHTML("WebSocket连接成功");

        }

        ws.onclose = function () {
            console.log("onclose");
        }

        ws.onmessage = function (msg) {
            console.log(msg.data);
            setMessageInnerHTML(msg.data);
        }
    }});
});

//连接发生错误的回调方法
ws.onerror = function () {
    setMessageInnerHTML("WebSocket连接发生错误");
};

//连接成功建立的回调方法
ws.onopen = function () {
    setMessageInnerHTML("WebSocket连接成功");
}

//接收到消息的回调方法
ws.onmessage = function (event) {
    setMessageInnerHTML(event.data);
}

//连接关闭的回调方法
ws.onclose = function () {
    setMessageInnerHTML("WebSocket连接关闭");
}

//监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
ws.onbeforeunload = function () {
    closeWebSocket();
}

//将消息显示在网页上
function setMessageInnerHTML(innerHTML) {
    document.getElementById('message').innerHTML += innerHTML + '<br/>';
}

//关闭WebSocket连接
function closeWebSocket() {
    ws.close();
}

//发送消息
function send() {
    var message = document.getElementById('text').value;
    ws.send(message);
}