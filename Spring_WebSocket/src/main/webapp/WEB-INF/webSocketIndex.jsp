<%--
  Created by IntelliJ IDEA.
  User: PZH
  Date: 2018/04/23
  Time: 10:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Welcome<br/><input id="text" type="text"/>
<button onclick="send()">发送消息</button>
<hr/>
<button onclick="closeWebSocket()">关闭WebSocket连接</button>
<hr/>
<div id="message"></div>
</body>
<script type="text/javascript" src='js/jquery-1.11.3.min.js'></script>
<script type="text/javascript" src='js/webSocket.js'></script>
</html>
