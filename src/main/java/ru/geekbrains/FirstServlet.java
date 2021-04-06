package ru.geekbrains;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.data.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

@WebServlet(name = "FirstServlet", urlPatterns = "/first_servlet")
public class FirstServlet extends HttpServlet {

    private static Logger logger = LoggerFactory.getLogger(FirstServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("New Get request");
        resp.getWriter().printf("<html>");
        resp.getWriter().printf("<body>");
        resp.getWriter().printf("<h1>Product's table</h1>");
        resp.getWriter().printf("<table class='tab'>\n" +
                "    <tr>\n" +
                "        <th>Id</th>\n" +
                "        <th>Title</th>\n" +
                "        <th>Cost</th>\n" +
                "    </tr>\n");
        for (int i = 0; i < 10; i++) {
            Product pr = new Product((long) i, "Product " + i, (float) (Math.random() * 100) + 10);
            resp.getWriter().printf("<tr><td>%d</td><td>%s</td><td>%.2f</td></tr>", pr.getId(), pr.getTitle(), pr.getCost());
        }
        resp.getWriter().printf("</table></html></body>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Enter table with Product");

    }
}
