package dog.club.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dog.club.domain.BoardContent;
import dog.club.domain.ChatContent;
import dog.club.domain.DogVO;
import dog.club.persistence.BoardConDAO;
import dog.club.persistence.ChatConDAO;
import dog.club.persistence.DogDAO;

/**
 * Servlet implementation class DogServlet
 */
@WebServlet(description="강아지 커뮤니티 서블릿", urlPatterns= {"/DogServlet"})
public class DogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DogServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().append("(GET)Served at: ").append(request.getContextPath());

		PrintWriter out = response.getWriter();
		
		String cmd="";
		String contno="";
		cmd=request.getParameter("key");
		contno=request.getParameter("contno");
		
		
		if(cmd.equals("main")) {
			response.sendRedirect("main.jsp");
		}
		//등록된 회원들의 강아지 정보 리스트
		else if(cmd.equals("list")) {
			DogDAO dogDAO=new DogDAO();
			List<DogVO> clientvoList = dogDAO.getClientList();
			request.setAttribute("clientList", clientvoList);
			RequestDispatcher view = request.getRequestDispatcher("client_list.jsp");
			view.forward(request, response);
		}
		//방명록
		else if(cmd.equals("chat")) {
			response.sendRedirect("chat.jsp");
		}
		
		//개꿀팁메뉴
		else if(cmd.equals("tip")) {
			response.sendRedirect("tip.jsp");
		}
		else if(cmd.equals("notice")) {
			response.sendRedirect("notice.jsp");
		}
		else if(cmd.equals("notice_view")) {
			if(contno!=null) {
				request.setAttribute("contno", contno);
				RequestDispatcher view = request.getRequestDispatcher("notice_view.jsp");
				view.forward(request, response);
			}
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
		String contno="";
		cmd=request.getParameter("key");
		contno=request.getParameter("contno");
		
		
		//방명록등록
		if(cmd.equals("chat")) {
			HttpSession session = request.getSession();
			DogVO client=(DogVO)session.getAttribute("loginclient");

			Date today = new Date();
			SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");

			ChatContent chatContent=new ChatContent();
			ChatConDAO chatDAO=new ChatConDAO();
			
			chatContent.setId(client.getId());
			chatContent.setDate(date.format(today));
			chatContent.setContent(request.getParameter("content"));
			
			String temp="JOIN NOT OK";
			if(chatDAO.add(chatContent))temp="JOIN OK";

			request.setAttribute("result", temp);
			
			RequestDispatcher view = request.getRequestDispatcher("chat.jsp");
			view.forward(request, response);
		}
		
		
		
		doGet(request, response);
	}

}
