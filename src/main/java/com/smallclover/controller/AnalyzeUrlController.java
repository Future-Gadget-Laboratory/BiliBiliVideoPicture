package com.smallclover.controller;

import com.smallclover.function.GetPicture;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
/*        String regex = "/(\\w+):\\/\\/([^/:]+)(:\\d*)?([^# ]*)/";
        String[] arr = url.split(regex);
        String picUrl = GetPicture.getPictureByAvNum(arr[arr.length - 1]);*/
        //resp.sendRedirect(picUrl);//出现403禁止访问
        String picUrl = GetPicture.getPictureByAvNum(avNum);
        resp.setHeader("referer","");
        PrintWriter pw = resp.getWriter();
        pw.println(picUrl);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
