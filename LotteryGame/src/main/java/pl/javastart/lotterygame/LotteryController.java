package pl.javastart.lotterygame;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

import static java.lang.Integer.parseInt;

@WebServlet("/lottery")
public class LotteryController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        int n1 = parseInt(request.getParameter("n1"));
        int n2 = parseInt(request.getParameter("n2"));
        int n3 = parseInt(request.getParameter("n3"));
        int n4 = parseInt(request.getParameter("n4"));
        int n5 = parseInt(request.getParameter("n5"));
        int n6 = parseInt(request.getParameter("n6"));

        LotteryDrawing userInput = new LotteryDrawing(n1, n2, n3, n4, n5, n6);
        LotteryDrawing randomNumbers = LotteryDrawing.randomLotteryDrawing();
        LotteryResult lotteryResult = LotteryChecker.lotteryChecker(userInput, randomNumbers);

        request.setAttribute("result", lotteryResult);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/result.jsp");
        requestDispatcher.forward(request, response);

    }
}
