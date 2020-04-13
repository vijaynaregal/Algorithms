package Midterm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Midterm.SurveyQuestion;
/**
 * Servlet implementation class AddQuestion
 */
@WebServlet("/AddQuestion")
public class AddQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	int idSeed = 1;  
    public AddQuestion() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init( ServletConfig config ) throws ServletException
    {
        super.init( config );

        // create some test data for display
        List<SurveyQuestion> entries = new ArrayList<SurveyQuestion>();
        

        // stored the data somewhere that can be accessed by this servlet
        // and other servlets.
        getServletContext().setAttribute( "surveyques", entries );
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<SurveyBuild> entries = (ArrayList<SurveyBuild>) getServletContext().getAttribute(
	            "survey" );
		
		String id  = entries.get(0).toStringId();
		request.setAttribute("entry",id );
		request.getRequestDispatcher( "/WEB-INF/AddQuestion.jsp" )
        .forward( request, response );
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String question = request.getParameter( "question" );
		String answerA = request.getParameter( "answerA" );
		String answerB = request.getParameter( "answerB" );
		String answerC = request.getParameter( "answerC" );
        System.out.println(question);
        

        if(question=="" ) {
        	response.sendRedirect( "AddQuestion" );
        }
        else {
        	SurveyQuestion entry = new SurveyQuestion(  question , answerA,
        		       answerB,
        		       answerC,idSeed++);

            
            @SuppressWarnings("unchecked")
			List<SurveyQuestion> entriesques = (List<SurveyQuestion>) getServletContext().getAttribute(
                "surveyques" );
            entriesques.add( entry );
            
            response.sendRedirect("./SurveyDetail");
        }
	}

}
