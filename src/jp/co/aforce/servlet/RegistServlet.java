package jp.co.aforce.servlet;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.dao.MemberDAO;
import jp.co.aforce.tool.Message;
import jp.co.aforce.tool.NullCheck;

@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		MemberDAO dao = new MemberDAO();

		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		int day = calendar.get(Calendar.DATE);
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);

		String member_id = "A" + year + month + day + hour + minute + second;
		String last_name = request.getParameter("last_name");
		String first_name = request.getParameter("first_name");
		String sex = request.getParameter("sex");
		String birth_year = request.getParameter("birth_year");
		String birth_month = request.getParameter("birth_month");
		String birth_day = request.getParameter("birth_day");
		String job = request.getParameter("job");
		String phone_number = request.getParameter("phone_number");
		String mail_address = request.getParameter("mail_address");

		String str = "";
		try {
			str = NullCheck.getString(last_name, first_name, sex, birth_year, birth_month, birth_day, job, phone_number, mail_address);
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		if (!str.equals("")) {
			request.setAttribute("error", str + Message.W_CCM0001);
			request.getRequestDispatcher("/views/regist.jsp")
					.forward(request, response);
		} else {

			try {
				int birth_yearint = Integer.parseInt(birth_year);
				int birth_monthint = Integer.parseInt(birth_month);
				int birth_dayint = Integer.parseInt(birth_day);

				int count = dao.exist(last_name, first_name, sex, birth_yearint, birth_monthint, birth_dayint, job, phone_number, mail_address);
				if (count != 0) {
					//重複
					request.setAttribute("error", Message.E_WKK0001);
					request.getRequestDispatcher("/views/regist.jsp")
							.forward(request, response);

				} else {
					int line = dao.insert(member_id, last_name, first_name, sex, birth_yearint, birth_monthint, birth_dayint, job, phone_number, mail_address);

					if (line != 0) {
						//登録成功
						request.setAttribute("success", Message.I_WKK0001);
						request.getRequestDispatcher("/views/regist.jsp")
								.forward(request, response);

					} else {
						request.setAttribute("error", Message.E_WKK0002);
						request.getRequestDispatcher("/views/regist.jsp")
								.forward(request, response);
					}
				}
			} catch (Exception e) {
				request.setAttribute("error", Message.E_WKK0002);
				request.getRequestDispatcher("/views/regist.jsp")
						.forward(request, response);
				e.printStackTrace();
			}

		}
	}

}
