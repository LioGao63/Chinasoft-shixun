<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	<title>人事管理系统——添加员工</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache" />
	<meta http-equiv="cache-control" content="no-cache" />
	<meta http-equiv="expires" content="0" />    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
	<meta http-equiv="description" content="This is my page" />
	<link href="../css/css.css" type="text/css" rel="stylesheet" />
	<link rel="stylesheet" type="text/css" href="../js/ligerUI/skins/Aqua/css/ligerui-dialog.css"/>
	<link href="../js/ligerUI/skins/ligerui-icons.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="../js/jquery-1.11.0.js"></script>
    <script type="text/javascript" src="../js/jquery-migrate-1.2.1.js"></script>
	<script src="../js/ligerUI/js/core/base.js" type="text/javascript"></script>
	<script src="../js/ligerUI/js/plugins/ligerDrag.js" type="text/javascript"></script> 
	<script src="../js/ligerUI/js/plugins/ligerDialog.js" type="text/javascript"></script>
	<script src="../js/ligerUI/js/plugins/ligerResizable.js" type="text/javascript"></script>
	<link href="../css/pager.css" type="text/css" rel="stylesheet" />
	<script language="javascript" type="text/javascript" src="../js/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript">
	
	 
	    function submit(){
	    	/** 员工表单提交 */
			//$("#employeeForm").submit(function(){
				var name = $("#name");
				var cardId = $("#cardId");
				var education = $("#education");
				var email = $("#email");
				var phone = $("#phone");
				var tel = $("#tel");
				var party = $("#party");
				var qqNum = $("#qqNum");
				var address = $("#address");
				var postCode = $("#postCode");
				var birthday = $("#birthday");
				var race = $("#race");
				var speciality = $("#speciality");
				var hobby = $("#hobby");
				var msg = "";
				if ($.trim(name.val()) == ""){
					msg = "姓名不能为空！";
					name.focus();
				}else if ($.trim(cardId.val()) == ""){
					msg = "身份证号码不能为空！";
					cardId.focus();
				}else if (!/^[1-9]\d{16}[0-9A-Za-z]$/.test($.trim(cardId.val()))){
					msg = "身份证号码格式不正确！";
					cardId.focus();
				}else if ($.trim(education.val()) == ""){
					msg = "学历不能为空！";
					education.focus();
				}else if ($.trim(email.val()) == ""){
					msg = "邮箱不能为空！";
					email.focus();
				}else if (!/^\w+@\w{2,3}\.\w{2,6}$/.test($.trim(email.val()))){
					msg = "邮箱格式不正确！";
					email.focus();
				}else if ($.trim(phone.val()) == ""){
					msg = "手机号码不能为空！";
					phone.focus();
				}else if (!/^1[3|5|8]\d{9}$/.test($.trim(phone.val()))){
					msg = "手机号码格式不正确！";
					phone.focus();
				}else if ($.trim(tel.val()) == ""){
					msg = "电话号码不能为空！";
					tel.focus();
				}else if (!/^0\d{2,3}-?\d{7,8}$/.test($.trim(tel.val()))){
					msg = "电话号码格式不正确！";
					tel.focus();
				}else if ($.trim(party.val()) == ""){
					msg = "政治面貌不能为空！";
					party.focus();
				}else if ($.trim(qqNum.val()) == ""){
					msg = "QQ号码不能为空！";
					qqNum.focus();
				}else if (!/^\d{6,}$/.test($.trim(qqNum.val()))){
					msg = "QQ号码格式不正确！";
					qqNum.focus();
				}else if ($.trim(address.val()) == ""){
					msg = "地址不能为空！";
					address.focus();
				}else if ($.trim(postCode.val()) == ""){
					msg = "邮政编码不能为空！";
					postCode.focus();
				}else if (!/^[1-9]\d{5}$/.test($.trim(postCode.val()))){
					msg = "邮政编码格式不正确！";
					postCode.focus();
				}else if ($.trim(birthday.val()) == ""){
					msg = "出生日期不能为空！";
					birthday.focus();
				}else if (!birthday.val()){
// 					!/^\d{4}-\d{2}-\d{2}$/.test($.trim(birthday.val()))
					msg = "出生日期格式不正确！";
					birthday.focus();
				}else if ($.trim(race.val()) == ""){
					msg = "民族不能为空！";
					race.focus();
				}else if ($.trim(speciality.val()) == ""){
					msg = "专业不能为空！";
					speciality.focus();
				}else if ($.trim(hobby.val()) == ""){
					msg = "爱好不能为空！";
					hobby.focus();
				}
				if (msg != ""){
					$.ligerDialog.error(msg);
					return false;
				}else{
					return true;
				}
				//$("#employeeForm").submit();
			//});
	    }
		

	</script>
</head>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr><td height="10"></td></tr>
  <tr>
    <td width="15" height="32"><img src="../images/main_locleft.gif" width="15" height="32"></td>
	<td class="main_locbg font2"><img src="../images/pointer.gif">&nbsp;&nbsp;&nbsp;当前位置：员工管理  &gt; 添加员工</td>
	<td width="15" height="32"><img src="../images/main_locright.gif" width="15" height="32"></td>
  </tr>
</table>
<table width="100%" height="90%" border="0" cellpadding="5" cellspacing="0" class="main_tabbor">
  <tbody><tr valign="top">
    <td>
    	 <form action="addEmployee" name="addEmployeeForm">
		 	<!-- 隐藏表单，flag表示添加标记 -->
    	 	<input type="hidden" name="flag" value="2">
		  <table width="100%" border="0" cellpadding="0" cellspacing="10" class="main_tab">
		    <tbody><tr><td class="font3 fftd">
		    	<table>
		    		<tbody><tr>
		    			<td class="font3 fftd">姓名：<input type="text" name="Ename" id="Ename" size="20"></td>
		    			<td class="font3 fftd">身份证号码：<input type="text" name="identity" id="identity" size="20"></td>
		    		</tr>
		    		<tr>
		    			<td class="font3 fftd">性别：
									<select name="sex" style="width:143px;">
					    			<option value="男">男</option>
					    			<option value="女">女</option>
					    		</select></td>
		    			<td class="font3 fftd">职&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;位：
		    			 <select name="pid" style="width:143px;">
								 <c:forEach items="${posList }" var="job">
									 <option value="${job.pId }">${job.pName }</option>
								 </c:forEach>
						 </select>
					    </td>
		    		</tr>
		    		<tr>
		    			<td class="font3 fftd">学历：<input name="record" id="record" size="20"></td>
		    			<td class="font3 fftd">邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱：<input name="email" id="email" size="20"></td>
		    		</tr>
		    		<tr>
		    			<td class="font3 fftd">手机：<input name="telphone" id="telphone" size="20"></td>
		    			<td class="font3 fftd">电&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;话：<input name="phone" id="phone" size="20"></td>
		    		</tr>
		    		
		    	</tbody></table>
		    </td></tr>
			<tr><td class="main_tdbor"></td></tr>
			
			<tr>
				<td class="font3 fftd">
					政治面貌：<input name="politic" id="politic" size="40">&nbsp;&nbsp;
					QQ&nbsp;&nbsp;号码：<input name="qq" id="qq" size="20">
				</td>
			</tr>
			<tr><td class="main_tdbor"></td></tr>
			
			<tr>
				<td class="font3 fftd">
					联系地址：<input name="address" id="address" size="40">&nbsp;&nbsp;
					邮政编码：<input name="postalcode" id="postalcode" size="20">
				</td>
			</tr>
			<tr><td class="main_tdbor"></td></tr>
			
			<tr>
				<td class="font3 fftd">
					出生日期：<input cssclass="Wdate" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'});" name="birthday" id="birthday" size="40">&nbsp;&nbsp;
					民&nbsp;&nbsp;&nbsp;&nbsp;族：<input name="nation" id="nation" size="20">
				</td>
			</tr>
			<tr><td class="main_tdbor"></td></tr>
			
			<tr>
				<td class="font3 fftd">
					所学专业：<input name="major" id="major" size="40">&nbsp;&nbsp;
					爱&nbsp;&nbsp;&nbsp;&nbsp;好：<input name="habby" id="habby" size="20">
				</td>
			</tr>
			<tr><td class="main_tdbor"></td></tr>
			
			<tr>
				<td class="font3 fftd">
					备&nbsp;&nbsp;&nbsp;&nbsp;注：<input name="note" id="note" size="40">
					&nbsp;&nbsp;所属部门：
					<select name="did" style="width:100px;">
						   
			    				<option value="1">技术部</option>
			    			
			    				<option value="2">运营部</option>
			    			
			    				<option value="3">财务部</option>
			    			
			    				<option value="5">总公办</option>
			    			
			    				<option value="6">市场部</option>
			    			
			    				<option value="7">教学部</option>
			    			
					</select>
				</td>
			</tr>
			<tr><td class="main_tdbor"></td></tr>
			
			<tr><td align="left" class="fftd">
			<input type="button" onclick="submit()" value="添加">&nbsp;&nbsp;<input type="reset" value="取消 "></td></tr>
		  </tbody></table>
		 </form>
	</td>
  </tr>
</tbody></table>
	</td>
  </tr>
</table>
<div style="height:10px;"></div>
</body>
</html>