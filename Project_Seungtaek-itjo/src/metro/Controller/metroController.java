package metro.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metro.biz.mBiz;
import metro.dto.mDto;

@WebServlet("/metroCon.do")
public class metroController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public metroController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String commend = request.getParameter("commend");
		
		mBiz biz = new mBiz();
		
		if(commend.equals("login")) {
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			
			mDto dto = null;
			
		} else if(commend.equals("join")) {
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	public void Dispatch(String url, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatch = request.getRequestDispatcher(url);
		dispatch.forward(request, response);
	}

}
