package com.servlet;

import com.entity.T_user;
import com.service.T_userServe;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "T_userServlet",urlPatterns = "/T_userServlet")
public class T_userServlet extends HttpServlet {
        T_userServe t_userServe=new T_userServe();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       this.doWork(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doWork(request,response);
    }
    protected void doWork(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String type =(String) request.getParameter("type");

        switch (type){
            case "list":{
                List<T_user> t_users= t_userServe.getAllT_user();
                request.getSession().setAttribute("tus",t_users);

                response.sendRedirect("mangeUser.jsp");

            }
                break;
            case "add":{
                int result;
                String nicheng,truename,cardid,email,telphone,qq;
                nicheng = request.getParameter("nicheng");
                truename = request.getParameter("truename");
                cardid = request.getParameter("cardid");
                email = request.getParameter("email");
                telphone = request.getParameter("telephone");
                qq = request.getParameter("qq");
                T_user user = new T_user(nicheng,truename,cardid,email,telphone,qq);
                result=t_userServe.addT_user(user);
                if (result!=0)
                    response.sendRedirect("T_userServlet?type=list");


            }
            break;
            case "show":{
                int id;
                id = Integer.parseInt(request.getParameter("id"));
               T_user user = t_userServe.getT_user(id);
               request.getSession().setAttribute("user",user);
               response.sendRedirect("lookUserinfo.jsp");
            }
            break;
            case "del":{
                String idlist = request.getParameter("idlist");
                int result=t_userServe.DelT_user(idlist);
                if(result!=0)
                    response.sendRedirect("T_userServlet?type=list");
            }
            break;
            default:

        }
    }
}
