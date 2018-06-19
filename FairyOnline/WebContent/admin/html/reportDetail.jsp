<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>举报详情</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" media="screen" href="${ctx}/admin/css/04.css" />
</head>
<body>
    <div class="container">
        <!-- 顶部标题栏 -->
        <div class="header">
            <!-- 标题栏左半部分 -->
            <div class="header-left-part">
                <h2>欢迎登陆FairyOline后台界面</h2>
            </div>
            <!-- 标题栏右半部分 -->
            <div class="header-right-part">
                <p>账号</p>
                <p>权限</p>删除
                <a href="login.html">
                    <button class="quit-btn">退出登录</button>
                </a>
            </div>
        </div>
    
        <!-- 表格部分 -->
        <div class="banner">
        <ul>
            
                <a href="manage.jsp"><li>管理用户/视频权限</li></a>
                <a href="exacourList.jsp"><li>审核课程</li></a>
                <a href="courcatList.jsp"><li>管理课程分类</li></a>
                <a href="teacherManage.jsp"><li>管理教师</li></a>
                <a href="dataManage.jsp"><li>管理数据</li></a>
                <a href="adminsManageAdmins.jsp"><li>管理管理账号</li></a>
        </ul>
        </div>
        <div class="left">
            <ul class="left-title">
                <li>被举报用户</li>
                <li>被澄清用户</li>
                <li>禁言用户</li>
                <li id="last">封号用户</li>
                <li>被举报课程</li>
            </ul>
        </div>
        <div class="right">
            <div class="right-top">
               <div class="fanhui">
                   <a href="location.href='javascript:history.go(-1);'"><button class="btn">返回</button></a>
               </div>
               <div class="title">
                    <p class="p">用户名：${ruser.rid.userLogin.userName}</p>
                    <p class="p">举报者：${ruser.uid.userLogin.userName}</p>
                    <p class="p">举报时间：${ruser.date}</p>
                    <p class="p">举报详情：${ruser.reason}</p>
                </div>
            </div>
            <div class="right-middle">
            <form action="${ctx}/admin/gag?aName=<%=session.getAttribute("admin")%>&&id=${ruser.rid}&&id1=${ruser.id}" enctype="multipart/form-data" method="post">
                <div class="deal">
                    <p class="p-size">处理方式:</p>
                </div>
                <div class="ban">
                
                    <div class="ban-first-tittle">
                        禁言：
                    </div>
                    <div class="ban-second-tittle">
                        禁言时间：
                    </div>
                    <div class="ban-last-tittle">
                        <input type="text" style="width: 80px;height: 25px" name="gagTime"/>&nbsp&nbsp天
                    </div>
                </div>
                <div class="reason">
                    <div class="reason-first">给予理由:</div>
                    <!--<div class="reason-second">
                    </div> -->
                    <input class="reason-second" type="text" name="gagReason"/>  
                </div>
                <div class="yes">
                    <button class="yes-btn">确认禁言</button>
                </div>
               </form> 
            </div>
            <div class="right-bottom">
            <form action="${ctx}/admin/title?aName=<%=session.getAttribute("admin")%>&&id=${ruser.rid}&&id1=${ruser.id}" enctype="multipart/form-data" method="post">
                <div class="right-bottom-first">
                    <div class="number-first">封号：</div>
                    <div class="number-second">给予理由:</div>
                    <input class="number-third" type="text" name="titleReason"/>
                    
                </div>
                <div class="right-bottom-second">
                    <button class="no-btn">确认封号</button>
                </div>
                </form>
                <div class="right-bottom-third">
                    <div class="clear-first">澄清：</div>
                    <div class="clear-second">
                        <button class="clear-button">确认澄清</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
