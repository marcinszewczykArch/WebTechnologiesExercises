package pl.javastart.czat;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("")
public class MessageController extends HttpServlet {

    @Override
    public void init(){
        getServletContext().setAttribute("messages", new ArrayList<Message>());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Message message = createMessage(request);
        List<Message> messageList = (List<Message>)getServletContext().getAttribute("messages");
        messageList.add(message);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    private Message createMessage(HttpServletRequest request) {
        String sender = request.getParameter("sender");
        String content = request.getParameter("content");
        Message message = new Message(sender, content);
        return message;
    }
}
