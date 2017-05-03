# weixin_api
微信公众号第三方开放平台API


## 初始化微信开放平台API服务
OpenApiConfig config = new OpenApiConfig();
OpenApi.getInstance().init(config);
    
## 开放平台事件解析
OpenEvent evt = OpenApi.getInstance().onEvent(WebContext.getRequest());

## 开放平台消息处理
UserMsg msg = OpenApi.getInstance().onMessage(WebContext.getRequest());

## 公众号API调用
String reply=MpApi.getInstance(msg.getAppid()).getReplyApi().buildReply(new ReplyText(msg, "欢迎使用"));
WebContext.getResponse().getWriter().print(reply);
