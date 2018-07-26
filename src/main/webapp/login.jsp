<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="login.css" />
<style>
	
	</style>
</head>
<body>

	
	<div id="title">
	欢迎登录NBA Store后台管理系统
	</div>
	<div id="title2">

	</div>
		
		<div class="sign_in_all">
			<div class="sign_in">
			
			<div class="sign_in_title">
				<h2 class="sign_in_title_txt">欢迎登录NBA Store.</h2> 
			</div>
			<div class="sign_in_content">
			<form action="login.do" method="get">
				<div class="sign_in_content1">
				<p class="p1">已注册用户</p>	
				<p class="p2">已有NBA球迷圈帐号，请使用注册手机号码登录</p>
				<p class="p3">	首次登录即可获得9折优惠券</p>
				
				<div class="phone_number"><!--<label class="control_label">-->
				
					<span > * 账号</span> 
					<!--<span class="NBA_number">(NBA帐号)</span>-->    </label>   
					<input type="text" class="biaodan" name="username"/> </div>	
					<div class="phone_number" >
						<span> * 密码</span>
						<input type="password" class="biaodan" name="password"/> 
					</div>	
				
				<div class="form_group">
					 <a href="#" ><span class="forget_password"> 忘记密码</span></a>
					 <input type="checkbox" class="fuxuan" /><span class="form_group_txt">记住用户名</span>
				</div>	
				<div class="ok">	
					<a href="frame.html"> <input type="submit" value="登录" class="denglu" /></a>
					</div>
				<div class="sign_in_other_choose">
					<p class="p2">您还可以用以下方式登录：</p>
					<div class="img_login_icon_qq" ></div>
					<div class="img_login_icon_weibo" ></div>
					<div class="img_login_icon_zhifubao" ></div>
				</div>
				</div>
				</form>	
				
			<div class="sign_in_content2">
				<div class="zhuce_title">
					<p class="p4">新用户注册(创建NBA球迷圈帐号)</p>
					<p class="p2">新用户首次注册，即可获得9折优惠券</p>
				</div>
				<form action="register.do" method="get" style="display: inline-block;">
				<div class="zhucebiaodan">
					<span>* 账号</span>
					<input type="text" class="biaodan" name="username" />
				</div>
				<br />
				<div class="zhucebiaodan">
					<span>* 验证码</span>
					<input type="text" class="biaodan" />
				</div><br />
				<div class="zhucebiaodan">
					<span>* 手机验证码</span>
					<input type="text" class="biaodan" />
				</div><br />
				<div class="zhucebiaodan">
					<span>* 密码</span>
				  <input type="password" class="biaodan"  name="password"    />
				</div><br />
				<div class="zhucebiaodan">
					<span>* 确认密码</span>
					<input type="password" class="biaodan" name="password"  />
				</div><br />
				<div class="zhucebiaodan">
					<input type="checkbox" class="fuxuan" />
					<span>我已阅读并遵守使用条款 、隐私政策 和  球迷圈条款</span> </div><br />
					<div class="ok">	
					<input type="submit" value="注册" class="denglu" />
					</div>
		</form>
			</div>
				
			</div>
			</div>
			</div>
		
	



</body>
</html>