package com.smallclover.controller;

import com.smallclover.function.GetPicture;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author smallclover
 * @create 2017-09-04
 * 接受解析前台传过来的b站视频连接
 */
@WebServlet("/Analyze.action")
public class AnalyzeUrlController extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String url = req.getParameter("url");
        String avNum = url.substring(url.indexOf("av"), url.length() - 1);
        String picUrl = GetPicture.getPictureByAvNum(avNum);
        //resp.sendRedirect(picUrl);//出现403禁止访问
        PrintWriter pw = resp.getWriter();
        pw.println("<strong>" + picUrl+ "</strong>");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
