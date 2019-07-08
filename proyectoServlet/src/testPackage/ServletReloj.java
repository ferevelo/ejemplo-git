package testPackage;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.rpc.processor.modeler.j2ee.xml.string;

import sun.util.calendar.Gregorian;


@WebServlet("/reloj")
public class ServletReloj extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ServletReloj() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Calendar calendar= GregorianCalendar.getInstance();
		String formato=
				request.getParameter("formato");
		String hora;
		if("12".equals(formato))
		{
		
		 hora= String.format("%s:%s:%s  %s",
				calendar.get(Calendar.HOUR_OF_DAY),
				calendar.get(Calendar.MINUTE),
				calendar.get(Calendar.SECOND),
		calendar.get(Calendar.AM_PM) == 0 ? "AM": "PM");
		}
		else
		{
			 hora= String.format("%s:%s:%s",
						calendar.get(Calendar.HOUR_OF_DAY),
						calendar.get(Calendar.MINUTE),
						calendar.get(Calendar.SECOND));
		}
		response.getOutputStream().print(hora);
		response.getOutputStream().flush();
		//http://localhost:9092/servlet/reloj?formato=12
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
