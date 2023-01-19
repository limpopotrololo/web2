package Servlets;

import Beans.Bean;
import Beans.ResultBean;
import Exeptions.InvalidData;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.lang.System.out;

@WebServlet(name = "AreaCheck", value = "/check")
public class AreaCheckServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        long computingTime = System.nanoTime();
        try {
            Double x = checkX(req.getParameter("x"));
            Double y = checkY(req.getParameter("y"));
            Double r = checkR(req.getParameter("r"));
            Boolean result = inRectangle(x, y, r) || inCircle(x, y, r) || inTriangle(x, y, r);
            computingTime = System.nanoTime() - computingTime;
            String stringComputingTime = String.format(" %,9.3f ms\n", computingTime/1_000_000.0);

            DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss z");
            String currentTime = dateFormat.format(new Date());

            ResultBean resultBean = (ResultBean) req.getSession().getAttribute("table");
            if (resultBean == null) resultBean = new ResultBean();

            Bean bean = new Bean(x,y,r,currentTime,stringComputingTime,result);
            resultBean.getResponse().add(bean);
            req.getSession().setAttribute("table",resultBean);

        } catch (InvalidData invalidData) {
            out.println(invalidData.getMessage());
        }

    }


    private double checkX(String x) throws InvalidData {
        Double dX = Double.parseDouble(x);
        try {
            if (!(dX >= -3 && dX <= 5)) throw new InvalidData("illegal x statement");
        } catch (NumberFormatException e) {
            throw new InvalidData("illegal x statement");
        }
        return dX;
    }

    private double checkY(String y) throws InvalidData {
        Double dY = Double.parseDouble(y);
        try {
            if (!(dY >= -3 && dY <= 5)) throw new InvalidData("illegal y statement");
        } catch (NumberFormatException e) {
            throw new InvalidData("illegal y statement");
        }
        return dY;
    }

    private double checkR(String r) throws InvalidData {
        Double dR = Double.parseDouble(r);
        try {
            if (!(dR >= 1 && dR <= 3)) throw new InvalidData("illegal r statement");
        } catch (NumberFormatException e) {
            throw new InvalidData("illegal r statement");
        }
        return dR;
    }

    private boolean inCircle(double x, double y, double r) {
        if (x >= -r / 2 && x <= 0 && y <= r / 2 && y >= 0 && (x * x + y * y <= (r / 2) * (r / 2))) return true;
        return false;
    }

    private boolean inTriangle(double x, double y, double r) {
        if (x >= -r / 2 && x <= 0 && y <= 0 && y >= -r && (y > -2 * x - 2)) return true;
        return false;
    }

    private boolean inRectangle(double x, double y, double r) {
        if (x >= 0 && x <= r / 2 && y >= 0 && y <= r) return true;
        return false;
    }
}
