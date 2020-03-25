<%@ page import="java.util.List" %>
<%@ page import="com.entity.T_user" %><%--
  Created by IntelliJ IDEA.
  User: 北港
  Date: 2020/3/25
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>用户管理</title>
    <link rel="stylesheet" type="text/css" href="css/font.css">
    <style type="text/css">
        <!--
        .style1 {color: #FFFFFF}
        -->
    </style>
</head>
<%
    List<T_user> tus= (List<T_user>) session.getAttribute("tus");
%>

<body topmargin="0" leftmargin="0" bottommargin="0">


<form name="form1" method="post">
    <table width="600" border="0" align="center" cellpadding="0" cellspacing="0">

        <tr>
            <td height="20" bgcolor="#FFCF60"><div align="center" class="style1">用户管理</div></td>
        </tr>
        <tr>
            <td  bgcolor="#666666"><table width="600" border="0" align="center" cellpadding="0" cellspacing="1">
                <tr>
                    <td width="224" height="20" bgcolor="#FFFFFF"><div align="center">用户昵称</div></td>
                    <td width="93" bgcolor="#FFFFFF"><div align="center">用户状态</div></td>
                    <td width="79" bgcolor="#FFFFFF"><div align="center">删除</div></td>
                    <td width="75" bgcolor="#FFFFFF"><div align="center">查看信息</div></td>

                </tr>
                <% for (T_user user:tus){%>
                <tr>
                    <td height="20" bgcolor="#FFFFFF"><div align="center"><%=user.getName()%></div></td>
                    <td height="20" bgcolor="#FFFFFF"><div align="center">
                     <%=user.getState() ==0? "冻结" : "未被冻结" %>
                    </div></td>
                    <td height="20" bgcolor="#FFFFFF"><div align="center">
                        <input type="checkbox" name="43" value=<%=user.getId()%>></div></td>
                    <td height="20" bgcolor="#FFFFFF"><div align="center"><a href="T_userServlet?type=show&id=<%=user.getId()%>"><img src="images/button_select.png" width="14" height="13" border="0"></a></div></td>

                </tr>
                <% } %>
            </table></td>
        </tr>
    </table>
    <br>
    <table width="600" height="25" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>

            <td align="right">
                <input type="submit" value="删除选项" class="buttoncss" onclick="foo();return false">
            </td>
        </tr>

    </table>

</form>
<script type="text/javascript" src="js/h5.js"></script>
</body>
</html></html>
