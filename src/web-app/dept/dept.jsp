<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<c:if test="${firstList==null}">
    <jsp:forward page="/department/lisAllDepartment?page=1"></jsp:forward>
</c:if>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>人事管理系统 ——部门管理</title>
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
	<script type="text/javascript">
		$(function(){
	 	   /** 获取上一次选中的部门数据 */
	 	   var boxs  = $("input[type='checkbox'][id^='box_']");
	 	   
	 	  /** 给全选按钮绑定点击事件  */
	    	$("#checkAll").click(function(){
	    		// this是checkAll  this.checked是true
	    		// 所有数据行的选中状态与全选的状态一致
	    		boxs.attr("checked",this.checked);
	    	})
	    	
	 	  /** 给数据行绑定鼠标覆盖以及鼠标移开事件  */
	    	$("tr[id^='data_']").hover(function(){
	    		$(this).css("backgroundColor","#eeccff");
	    	},function(){
	    		$(this).css("backgroundColor","#ffffff");
	    	})
	    	
	    	
	 	   /** 删除员工绑定点击事件 */
	 	   $("#delete").click(function(){
	 		   /** 获取到用户选中的复选框  */
	 		   var checkedBoxs = boxs.filter(":checked");
	 		   if(checkedBoxs.length < 1){
	 			   $.ligerDialog.error("请选择一个需要删除的部门！");
	 		   }else{
	 			   /** 得到用户选中的所有的需要删除的ids */
	 			   var ids = checkedBoxs.map(function(){

	 				   return this.value;
	 			   })
	 			   
	 			   $.ligerDialog.confirm("确认要删除吗?","删除部门",function(r){
	 				   if(r){
						   window.location.href = "/department/addDepartment?dids="+ids.get();
	 				   }
	 			   });
	 		   }
	 	   })

            /** 根据关键字查询部门绑定点击事件 */
            $("#searchByKey").click(function(){
               var key =  $("#keyWord");
               var msg="";
               if ($.trim(key.val()) == ""){
                    msg = "输入为空，请重新输入！";
                   $.ligerDialog.error(msg);
                    key.focus();
                }else{
                   window.location.href = "${pageContext.request.contextPath}/department/searchDepartment?departmentName="+$(key).val();
                }
            })

            $("#pageRangeJugde").click(function(){
                var page_new = $("#inputPage").val();//获取本jsp变量的值
                var lastPage =${lastPage};//获取controller里面的变量的值
                var msg = "";

                if($.trim(page_new) == ""){
                    msg = "页数不能为空";
                    $.ligerDialog.error(msg);
                    page_new.focus();
                    return false;
                }else if(Number(page_new)>Number(lastPage)) {
                    msg = "访问页数不存在";
                    $.ligerDialog.error(msg);
                    page_new.focus()
                    return false;
                }else {
                    window.location.href = "${pageContext.request.contextPath}/department/lisAllDepartment?page="+Number(page_new);
                }
            })
	    })

	</script>
</head>


<body>
	<!-- 导航 -->
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
	  <tr><td height="10"></td></tr>
	  <tr>
	    <td width="15" height="32"><img src="../images/main_locleft.gif" width="15" height="32"></td>
		<td class="main_locbg font2"><img src="../images/pointer.gif">&nbsp;&nbsp;&nbsp;当前位置：部门管理 &gt; 部门查询</td>
		<td width="15" height="32"><img src="../images/main_locright.gif" width="15" height="32"></td>
	  </tr>
	</table>
	
	<table width="100%" height="90%" border="0" cellpadding="5" cellspacing="0" class="main_tabbor">
	  <!-- 查询区  -->
	  <tr valign="top">
	    <td height="30">
		  <table width="100%" border="0" cellpadding="0" cellspacing="10" class="main_tab">
		    <tr>
			  <td class="fftd">
			  	
				    <table width="100%" border="0" cellpadding="0" cellspacing="0">
					  <tr>
					    <td class="font3">
					    	部门名称：<input type="text" name="keyWord" id="keyWord">
                            <input id="searchByKey" type="button" value="搜索"/>
					    	<input id="delete" type="button" value="删除"/>
					    </td>
					  </tr>
					</table>
			
			  </td>
			</tr>
		  </table>
		</td>
	  </tr>
	  
	  <!-- 数据展示区 -->
	  <tr valign="top">
	    <td height="20">
		 <table width="100%" border="1" cellpadding="5" cellspacing="0" style="border:#c2c6cc 1px solid; border-collapse:collapse;">
		    <tbody><tr class="main_trbg_tit" align="center">
			  <td><input type="checkbox" name="checkAll" id="checkAll"></td>
			  <td>部门名称</td>
			  <td>详细信息</td>
			  	
			  <td align="center">操作</td>
			  
			</tr>
			<c:forEach items="${firstList}" var="dept">
				<tr id="data_0" align="center" class="main_trbg" style="background-color: rgb(255, 255, 255);">
					<td><input type="checkbox" id="box_0" value="${dept.did}"></td>
					 <td>${dept.dname}</td>
					  <td>${dept.detail}</td>
					  	
					 <td align="center" width="40px;"><a href="showUpdateDept.jsp?did=${dept.did}&dname=${dept.dname}&detail=${dept.detail}">
							<img title="修改" src="../images/update.gif"></a>
					  </td>
					  
				</tr>
			</c:forEach>

		  </tbody></table>
		</td>
	  </tr>

	  <!-- 分页标签 -->
	  <tr valign="top"><td align="center" class="font3">
		  <table width="100%" align="center" style="font-size:13px;" class="digg">
			  <tbody>
			  <tr>
				  <td style="COLOR: #0061de; MARGIN-RIGHT: 3px; PADDING-TOP: 2px; TEXT-DECORATION: none">
					  <c:if test="${currentPage!=1}">
						  <a href="${pageContext.request.contextPath}/department/lisAllDepartment?page=${currentPage-1}">上一页</a>
					  </c:if>
					  <c:forEach begin="1" end="${lastPage}" var="curr">
						  <c:if test="${currentPage==curr}">
							  <span class="current">${curr}</span>
						  </c:if>
						  <c:if test="${currentPage!=curr}">
							  <a href="${pageContext.request.contextPath}/department/lisAllDepartment?page=${curr}">${curr}</a>
						  </c:if>
					  </c:forEach>
					  <c:if test="${currentPage!=lastPage}">
						  <a href="${pageContext.request.contextPath}/department/lisAllDepartment?page=${currentPage+1}">下一页</a>
					  </c:if>
					  &nbsp;跳转到&nbsp;&nbsp;
<%--					  <form action="${pageContext.request.contextPath}/department/lisAllDepartment" name="jumpToCon">--%>
						  <input type="hidden" value="${lastPage}" name="lastPage">
						  <input style="text-align: center;BORDER-RIGHT: #aaaadd 1px solid; PADDING-RIGHT: 5px; BORDER-TOP: #aaaadd 1px solid; PADDING-LEFT: 5px; PADDING-BOTTOM: 2px; MARGIN: 2px; BORDER-LEFT: #aaaadd 1px solid; COLOR: #000099; PADDING-TOP: 2px; BORDER-BOTTOM: #aaaadd 1px solid; TEXT-DECORATION: none" type="text" size="2" name="inputPage" id="inputPage">&nbsp;
						  <input type="button" style="text-align: center;BORDER-RIGHT: #dedfde 1px solid; PADDING-RIGHT: 6px; BACKGROUND-POSITION: 50% bottom; BORDER-TOP: #dedfde 1px solid; PADDING-LEFT: 6px; PADDING-BOTTOM: 2px; BORDER-LEFT: #dedfde 1px solid; COLOR: #0061de; MARGIN-RIGHT: 3px; PADDING-TOP: 2px; BORDER-BOTTOM: #dedfde 1px solid; TEXT-DECORATION: none" value="确定" name="pager_jump_btn" id="pageRangeJugde">
<%--                      </form>--%>
				  </td>
			  </tr>
			  <tr align="center">
				  <td style="font-size:13px;">

				  </td>
			  </tr>
			  <tr>
				  <td style="COLOR: #0061de; MARGIN-RIGHT: 3px; PADDING-TOP: 2px; TEXT-DECORATION: none">总共<font color="red">${count}</font>条记录，当前显示${currentPage*10-9}-${currentPage*10}条记录
				  </td>
			  </tr>
			  </tbody>
		  </table>
	  </td></tr>
	</table>
	<div style="height:10px;"></div>
</body>
</html>