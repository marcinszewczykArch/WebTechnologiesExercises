package pl.javastart.mvc.currencycalc;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;

@WebServlet("/convert")
public class ExchangeController extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(validateParameters(request)){
            successDispatch(request, response);
        } else {
            errorDispatch(request, response);
        }
    }

    private void errorDispatch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("error.jsp").forward(request, response);

    }

    private boolean validateParameters(HttpServletRequest request) {
        String exchangeParam = request.getParameter("exchange");
            if (exchangeParam == null || "".equals(exchangeParam)) {
                request.setAttribute("message", "Typ wymiany nie został określony");
                return false;
                } else {
                    ExchangeType[] values = ExchangeType.values();
                    for (ExchangeType value : values) {
                        boolean invalidExchangeType = Arrays.stream(values)
                                .map(Enum::toString)
                                .noneMatch(exchangeType -> exchangeType.equals(exchangeParam));
                        if (invalidExchangeType) {
                            request.setAttribute("message", "Nieznany typ wymiany: " + exchangeParam);
                            return false;
                        }
                    }
                }

        String value = request.getParameter("value");
            if (value == null || "".equals(value)) {
                request.setAttribute("message", "Kwota nie została określona");
                return false;
            } else if (!value.matches("-?\\d+(\\.\\d+)?")) {
                //-? - może być z minusem
                //d+ - co najmniej jedna cyfra
                //()? - w nawiasie grupa, znak zapytania oznacza, że jest opcjonalna
                request.setAttribute("message", "Nieprawidłowy numer");
                return false;
            }

        return true;
        }

    private void successDispatch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String valueString = request.getParameter("value");
        BigDecimal value = new BigDecimal(valueString);
        String exchangeString = request.getParameter("exchange");
        ExchangeType exchangeType = ExchangeType.valueOf(exchangeString);
        ExchangeResult exchangeResult = ExchangeCalculator.exchange(value, exchangeType);

        request.setAttribute("result", exchangeResult);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/result.jsp");
        requestDispatcher.forward(request, response);
    }
}
