<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户信息管理中心</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.12.4.js"></script>
<script type="text/javascript" src="user_js/user.js"></script>
</head>
<body>
<!--Begin Header Begin-->
<div class="soubg">
	<div class="sou">
        <span class="fr">
        	<c:set var="users" value="${user}" scope="session"></c:set>
        	<span class="fl">
        	<c:if test="${not empty users}">
        		<c:if test="${not empty users.u_nc}">
        			欢迎您:<a href="${pageContext.request.contextPath}/user/user.jsp">${users.u_nc}</a>
        		</c:if>
        		<c:if test="${empty users.u_nc}">
        			欢迎您:<a href="${pageContext.request.contextPath}/user/user.jsp">${users.u_loginName}</a>
        		</c:if>	
        		&nbsp;<a href="../user.do?opr=outLogin">退出</a>
        	</c:if>
        	<c:if test="${empty users}">
        		你好，请<a href="../Login.html">登录</a>&nbsp; <a href="../Regist.html" style="color:#ff4e00;">免费注册</a>
        	</c:if>
        	&nbsp;|&nbsp;<a href="../Index.jsp">首页</a>&nbsp;|&nbsp;<a href="#">我的订单</a>&nbsp;|&nbsp;<a href="${pageContext.request.contextPath}/user/user.jsp">个人中心</a>&nbsp;|</span>
        	<span class="ss">
            	<div class="ss_list">
                	<a href="#">收藏夹</a>
                    <div class="ss_list_bg">
                    	<div class="s_city_t"></div>
                        <div class="ss_list_c">
                        	<ul>
                            	<li><a href="#">我的收藏夹</a></li>
                                <li><a href="#">我的收藏夹</a></li>
                            </ul>
                        </div>
                    </div>     
                </div>
                <div class="ss_list">
                	<a href="#">客户服务</a>
                    <div class="ss_list_bg">
                    	<div class="s_city_t"></div>
                        <div class="ss_list_c">
                        	<ul>
                            	<li><a href="#">客户服务</a></li>
                                <li><a href="#">客户服务</a></li>
                                <li><a href="#">客户服务</a></li>
                            </ul>
                        </div>
                    </div>    
                </div>
                <div class="ss_list">
                	<a href="#">网站导航</a>
                    <div class="ss_list_bg">
                    	<div class="s_city_t"></div>
                        <div class="ss_list_c">
                        	<ul>
                            	<li><a href="#">网站导航</a></li>
                                <li><a href="#">网站导航</a></li>
                            </ul>
                        </div>
                    </div>    
                </div>
            </span>
            <span class="fl">|&nbsp;关注我们：</span>
            <span class="s_sh"><a href="#" class="sh1">新浪</a><a href="#" class="sh2">微信</a></span>
            <span class="fr">|&nbsp;<a href="#">手机版&nbsp;<img src="images/s_tel.png" align="absmiddle" /></a></span>
        </span>
    </div>
</div>
<div class="m_top_bg">
    <div class="top">
        <div class="m_logo"><a href="Index.html"><!-- <img src="../images/titiyigou_logo.png" /> --></a></div>
        <div class="m_search">
            <form>
                <input type="text" value="" class="m_ipt" />
                <input type="submit" value="搜索" class="m_btn" />
            </form>                      
            <span class="fl"><a href="#">咖啡</a><a href="#">iphone 6S</a><a href="#">新鲜美食</a><a href="#">蛋糕</a><a href="#">日用品</a><a href="#">连衣裙</a></span>
        </div>
        <div class="i_car">
            <div class="car_t">购物车 [ <span>3</span> ]</div>
            <div class="car_bg">
                <!--Begin 购物车未登录 Begin-->
                <div class="un_login">还未登录！<a href="Login.html" style="color:#ff4e00;">马上登录</a> 查看购物车！</div>
                <!--End 购物车未登录 End-->
                <!--Begin 购物车已登录 Begin-->
                <ul class="cars">
                    <li>
                        <div class="img"><a href="#"><img src="images/car1.jpg" width="58" height="58" /></a></div>
                        <div class="name"><a href="#">法颂浪漫梦境50ML 香水女士持久清新淡香 送2ML小样3只</a></div>
                        <div class="price"><font color="#ff4e00">￥399</font> X1</div>
                    </li>
                    <li>
                        <div class="img"><a href="#"><img src="images/car2.jpg" width="58" height="58" /></a></div>
                        <div class="name"><a href="#">香奈儿（Chanel）邂逅活力淡香水50ml</a></div>
                        <div class="price"><font color="#ff4e00">￥399</font> X1</div>
                    </li>
                    <li>
                        <div class="img"><a href="#"><img src="images/car2.jpg" width="58" height="58" /></a></div>
                        <div class="name"><a href="#">香奈儿（Chanel）邂逅活力淡香水50ml</a></div>
                        <div class="price"><font color="#ff4e00">￥399</font> X1</div>
                    </li>
                </ul>
                <div class="price_sum">共计&nbsp; <font color="#ff4e00">￥</font><span>1058</span></div>
                <div class="price_a"><a href="#">去购物车结算</a></div>
                <!--End 购物车已登录 End-->
            </div>
        </div>
    </div>
</div>
<!--End Header End--> 
<div class="i_bg bg_color">
    <!--Begin 用户中心 Begin -->
	<div class="m_content">
   		<div class="m_left">
        	<div class="left_n">管理中心</div>
            <div class="left_m">
            	<div class="left_m_t t_bg1">订单中心</div>
                <ul>
                	<li><a href="javascript:myorders1(${users.u_id})">我的订单</a></li>
                    <li><a onclick="douseraddress()">收货地址</a></li>
                    <li><a href="#">缺货登记</a></li>
                    <li><a href="#">跟踪订单</a></li>
                </ul>
            </div>
            <div class="left_m">
            	<div class="left_m_t t_bg2">会员中心</div>
                <ul>
                	<li><a onclick="aginreaduserpage()">用户信息</a></li>
                    <li><a href="Member_Collect.html">我的收藏</a></li>
                    <li><a href="Member_Msg.html">我的留言</a></li>
                    <li><a href="Member_Links.html">推广链接</a></li>
                    <li><a href="#">我的评论</a></li>
                </ul>
            </div>
            <div class="left_m">
            	<div class="left_m_t t_bg3">账户中心</div>
                <ul>
                	<li><a onclick="usersafe();">账户安全</a></li>
                    <li><a href="Member_Packet.html">我的红包</a></li>
                    <li><a href="Member_Money.html">资金管理</a></li>
                </ul>
            </div>
            <div class="left_m">
            	<div class="left_m_t t_bg4">分销中心</div>
                <ul>
                	<li><a href="Member_Member.html">我的会员</a></li>
                    <li><a href="Member_Results.html">我的业绩</a></li>
                    <li><a href="Member_Commission.html">我的佣金</a></li>
                    <li><a href="Member_Cash.html">申请提现</a></li>
                </ul>
            </div>
        </div>
		<div class="m_right">
        	<div class="m_des">
            	<table border="0" style="width:870px; line-height:22px;" cellspacing="0" cellpadding="0">
                  <tr valign="top">
                    <td width="115" id="ghpic"><img src="../user.show" width="90" height="90" id="showuserpic"/><p></p>
                    <form action="../uploadPic.do" method="post" id="uploadForm" enctype="multipart/form-data">
                    	<input type="hidden" name="picture" value="uploadpic">
                    	<input type="file" style="display:none;" id="upload" name="pic" onchange="show(this.files)">
                    	<input type="button" id="ghbutton" value="更换头像" style="margin-left:10px" onclick="changepic()">
                    </form>
                    <span style="color: red" id="noxzpic"></span>
                    </td>
                    <td>
                    	<div class="m_user">
                    	<c:if test="${not empty users.u_realName}">
                    		${users.u_realName}
                    	</c:if>
                    	<c:if test="${empty users.u_realName}">
                    		<c:if test="${not empty users.u_nc}">
                    		${users.u_nc}
                    	</c:if>
                    	<c:if test="${empty users.u_nc}">
                    		${users.u_loginName}
                    	</c:if>
                    	</c:if>
                    	</div>
                        <p>
                            等级：${u_limit.u_LimitName} <br />
                            <font color="#ff4e00">您的积分:${users.u_integral}</font><br />
                            <font color="#ff4e00"></font><br />
                            上一次登录时间: ${users.u_lastlogin_time}<br />
                            您还没有通过邮件认证 <a href="#" style="color:#ff4e00;">点此发送认证邮件</a>
                        </p>
                        <div class="m_notice">
                        	用户中心公告！
                        </div>
                    </td>
                    <td id="changepic"></td>
                  </tr>
                </table>	
            </div>
            
            <div class="mem_t">资产信息</div>
            <table border="0" class="mon_tab" style="width:870px; margin-bottom:20px;" cellspacing="0" cellpadding="0">
              <tr>
                <td width="33%">用户等级：<span style="color:#555555;">${u_limit.u_LimitName}</span></td>
                <td width="33%">消费金额：<span>￥200元</span></td>
                <td width="33%">返还积分：<span>99R</span></td>
              </tr>
              <tr>
                <td>账户余额：<span>￥200元</span></td></td>
                <td>红包个数：<span style="color:#555555;">3个</span></td></td>
                <td>红包价值：<span>￥50元</span></td></td>
              </tr>
              <tr>
                <td colspan="3">订单提醒：
                	<font style="font-family:'宋体';">待付款(<span>0</span>) &nbsp; &nbsp; &nbsp; &nbsp; 待收货(<span>2</span>) &nbsp; &nbsp; &nbsp; &nbsp; 待评论(<span>1</span>)</font>
                </td>
              </tr>
            </table>

            <div class="mem_t userInfo">用户基本信息</div>
            <table border="0" class="mon_tab updateUserInfo" style="width:870px; margin-bottom:20px;" cellspacing="0" cellpadding="0">
              <tr>
                <td width="40%">用户ID：<span style="color:#555555;">${users.show_u_id}</span></td>
                <td width="60%">用户姓名：<span style="color:#555555;">${users.u_realName}</span></td>
              </tr>
              <tr>
                <td>电&nbsp; &nbsp; 话：<span style="color:#555555;">${users.u_phone}</span></td>
                <td>邮&nbsp; &nbsp; 箱：<span style="color:#555555;">${users.u_email}</span></td>
              </tr>
              <tr>
                <td>身份证号：<span style="color:#555555;">${users.u_papers}</span></td>
                <td>注册时间：<span style="color:#555555;">${users.u_registration_time}</span></td>
              </tr>
              <tr>
                <td>用户住址：<span style="color:#555555;">${users.u_address}</span></td>
              </tr>
            </table>
            <input type="button" value="修改个人信息" style="margin-left:50px" onclick="updateUserInfo()" id="updateButton">
            
        </div>
    </div>
	<!--End 用户中心 End--> 
    <!--Begin Footer Begin -->
    <div class="b_btm_bg b_btm_c">
        <div class="b_btm">
            <table border="0" style="width:210px; height:62px; float:left; margin-left:75px; margin-top:30px;" cellspacing="0" cellpadding="0">
              <tr>
                <td width="72"><img src="../images/b1.png" width="62" height="62" /></td>
                <td><h2>正品保障</h2>正品行货  放心购买</td>
              </tr>
            </table>
			<table border="0" style="width:210px; height:62px; float:left; margin-left:75px; margin-top:30px;" cellspacing="0" cellpadding="0">
              <tr>
                <td width="72"><img src="../images/b2.png" width="62" height="62" /></td>
                <td><h2>满38包邮</h2>满38包邮 免运费</td>
              </tr>
            </table>
            <table border="0" style="width:210px; height:62px; float:left; margin-left:75px; margin-top:30px;" cellspacing="0" cellpadding="0">
              <tr>
                <td width="72"><img src="../images/b3.png" width="62" height="62" /></td>
                <td><h2>天天低价</h2>天天低价 畅选无忧</td>
              </tr>
            </table>
            <table border="0" style="width:210px; height:62px; float:left; margin-left:75px; margin-top:30px;" cellspacing="0" cellpadding="0">
              <tr>
                <td width="72"><img src="../images/b4.png" width="62" height="62" /></td>
                <td><h2>准时送达</h2>收货时间由你做主</td>
              </tr>
            </table>
        </div>
    </div>
    <div class="b_nav">
    	<dl>                                                                                            
        	<dt><a href="#">新手上路</a></dt>
            <dd><a href="#">售后流程</a></dd>
            <dd><a href="#">购物流程</a></dd>
            <dd><a href="#">订购方式</a></dd>
            <dd><a href="#">隐私声明</a></dd>
            <dd><a href="#">推荐分享说明</a></dd>
        </dl>
        <dl>
        	<dt><a href="#">配送与支付</a></dt>
            <dd><a href="#">货到付款区域</a></dd>
            <dd><a href="#">配送支付查询</a></dd>
            <dd><a href="#">支付方式说明</a></dd>
        </dl>
        <dl>
        	<dt><a href="#">会员中心</a></dt>
            <dd><a href="#">资金管理</a></dd>
            <dd><a href="#">我的收藏</a></dd>
            <dd><a href="#">我的订单</a></dd>
        </dl>
        <dl>
        	<dt><a href="#">服务保证</a></dt>
            <dd><a href="#">退换货原则</a></dd>
            <dd><a href="#">售后服务保证</a></dd>
            <dd><a href="#">产品质量保证</a></dd>
        </dl>
        <dl>
        	<dt><a href="#">联系我们</a></dt>
            <dd><a href="#">网站故障报告</a></dd>
            <dd><a href="#">购物咨询</a></dd>
            <dd><a href="#">投诉与建议</a></dd>
        </dl>
        <div class="b_tel_bg">
        	<a href="#" class="b_sh1">新浪微博</a>            
        	<a href="#" class="b_sh2">腾讯微博</a>
            <p>
            服务热线：<br />
            <span>400-123-4567</span>
            </p>
        </div>
        <div class="b_er">
            <div class="b_er_c"><img src="../images/er.gif" width="118" height="118" /></div>
            <img src="../images/ss.png" />
        </div>
    </div>    
    <div class="btmbg">
		<div class="btm">
        	备案/许可证编号：蜀ICP备12009302号-1-www.dingguagua.com   Copyright © 2015-2018 尤洪商城网 All Rights Reserved. 复制必究 , Technical Support: Dgg Group <br />
            <img src="../images/b_1.gif" width="98" height="33" /><img src="../images/b_2.gif" width="98" height="33" /><img src="../images/b_3.gif" width="98" height="33" /><img src="../images/b_4.gif" width="98" height="33" /><img src="../images/b_5.gif" width="98" height="33" /><img src="../images/b_6.gif" width="98" height="33" />
        </div>    	
    </div>
    <!--End Footer End -->    
</div>
</body>
</html>