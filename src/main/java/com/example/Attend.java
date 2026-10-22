package com.example;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Attend extends HttpServlet {

    // 已签到学生列表（学号 + 姓名），存在内存里
    private List<String> attendees = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>Attendance</title></head><body>");
        out.println("<h2>课堂签到 Attendance</h2>");

        // 签到表单
        out.println("<form method='POST' action='/'>");
        out.println("学号 Student ID: <input name='sid' required> ");
        out.println("姓名 Name: <input name='name' required> ");
        out.println("<button type='submit'>签到 Sign In</button>");
        out.println("</form>");

        out.println("<h3>已签到名单 (" + attendees.size() + ")</h3><ol>");

        // ============================================================
        // 【问题3答案位置】下面这个 for 循环按 attendees 的原始顺序输出。
        // 如果要按学号排序，在这个 for 循环之前加一行：
        //     Collections.sort(attendees);
        // （学号是数字开头的字符串，String 自然排序就是按学号升序）
        // 需要在文件顶部 import: java.util.Collections;
        // ============================================================
        for (String a : attendees) {
            out.println("<li>" + a + "</li>");
        }

        out.println("</ol>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        String sid = request.getParameter("sid");
        String name = request.getParameter("name");

        if (sid != null && name != null && !sid.isBlank() && !name.isBlank()) {
            attendees.add(sid + " " + name);
        }

        // 签到后跳回主页，刷新列表
        response.sendRedirect("/");
    }
}
