package servlet;



import dao.TopicDaoImpl;
import model.Topic;
import org.json.JSONArray;
import service.TopicService;
import service.TopicServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "TopicServlet", urlPatterns = "ts")
public class TopicServlet extends HttpServlet {
    private TopicService topicService = new TopicServiceImpl(new TopicDaoImpl());
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
    private void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        String action = null;
        String address = null;
        if (address != null){
            request.getRequestDispatcher(address).forward(request, response);
        }else {
            response.sendRedirect("/");
            return;
        }
        if (action.equals("pendingTopics")){
            List<Topic>listPendingTopics=topicService.getPendingTopics();
            if (!listPendingTopics.isEmpty()) {
                JSONArray jsonArray=new JSONArray(listPendingTopics);
                response.getWriter().write(jsonArray.toString());


            }

        }
        if(action.equals("activeTopics")){
            List<Topic>listActiveTopics=topicService.getActiveTopics();
            if(!listActiveTopics.isEmpty()){
                JSONArray jsonArray=new JSONArray(listActiveTopics);
                response.getWriter().write(jsonArray.toString());
            }

        }




    }
}
