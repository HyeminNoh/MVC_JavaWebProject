package dog.club.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dog.club.domain.DogVO;
import dog.club.persistence.DogDAO;

/**
 * Servlet implementation class ProfileService
 */
@WebServlet("/ProfileService")
public class ProfileService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileService() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().append("(GET)Served at: ").append(request.getContextPath());

		PrintWriter out = response.getWriter();
		
		String cmd="";
		cmd=request.getParameter("key");
		
		//로그인 회원 프로필 조회
				
		if(cmd.equals("profile")) {
					response.sendRedirect("profile.jsp");
				}
				//로그인 회원 프로필 수정
				else if(cmd.equals("edit")) {
					response.sendRedirect("profile_edit.jsp");
				}
				//회원 탈퇴
				else if(cmd.equals("secession")) {
					HttpSession session = request.getSession();
					DogVO dogVO=(DogVO)session.getAttribute("loginclient");
					DogDAO dogDAO=new DogDAO();
					
					String temp="DELETE NOT OK";
					if(dogDAO.delete(dogVO))temp="DELETE OK";
					
					if(session!=null) {
						session.invalidate();
					}
					
					request.setAttribute("result", temp);
					
					RequestDispatcher view = request.getRequestDispatcher("secession_result.html");
					
					view.forward(request, response);
				}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().append("(POST)Served at: ").append(request.getContextPath());
		
		String cmd="";
		cmd=request.getParameter("key");
		
		//프로필 수정
		if(cmd.equals("edit")) {
				HttpSession session = request.getSession();
				DogVO previous = (DogVO)session.getAttribute("loginclient");
				DogVO update=new DogVO();
				DogDAO dogDAO=new DogDAO();
				
				update.setUsername(request.getParameter("username"));
				update.setId(request.getParameter("id"));
				update.setPassword(request.getParameter("password"));
				update.setDogname(request.getParameter("dogname"));
				update.setDogage(Integer.parseInt(request.getParameter("dogage")));
				update.setDogsex(request.getParameter("dogsex"));
				update.setDogtype(request.getParameter("dogtype"));
				
				String temp="UPDATE NOT OK";
				if(dogDAO.update(previous,update))temp="UPDATE OK";
				
				request.setAttribute("result", temp);
				session.setAttribute("loginclient",update);
				
				RequestDispatcher view = request.getRequestDispatcher("profile.jsp");
				view.forward(request, response);
				}
				
		doGet(request, response);
	}

}
