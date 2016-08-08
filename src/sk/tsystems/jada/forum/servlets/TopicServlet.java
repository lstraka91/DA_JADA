package sk.tsystems.jada.forum.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sk.tsystems.jada.forum.entity.Commentary;
import sk.tsystems.jada.forum.entity.Topic;
import sk.tsystems.jada.forum.entity.services.CommentaryService;
import sk.tsystems.jada.forum.entity.services.TopicService;

/**
 * Servlet implementation class TopicServlet
 */
@WebServlet("/TopicServlet")
public class TopicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TopicServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		Topic topic = new Topic();
		
		CommentaryService cs = new CommentaryService();
		
		List<Commentary> comments = cs.selectAllComentByTopic(topic);
		out.println("<hr>");
		for (int i = 0; i < comments.size(); i++) {
			out.println(comments.get(i).getPerson().getPersonName() + comments.get(i).getCommentaryBody() + 
					comments.get(i).getCommentaryDate());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
