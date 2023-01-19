package Servlets;

import Beans.ResultBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.lang.System.out;

@WebServlet(name = "Controller", value = "/control")
public class ControllerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("x") != null && req.getParameter("y") != null && req.getParameter("r") != null) {
            out.println("hello");
            req.getServletContext().getNamedDispatcher("AreaCheck").forward(req, resp);
        } else if (req.getParameter("clear") != null){
            ResultBean resultBean = (ResultBean) req.getSession().getAttribute("table");
            if (resultBean == null) resultBean = new ResultBean();
            resultBean.getResponse().clear();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/index.jsp").forward(req,resp);
    }
}
