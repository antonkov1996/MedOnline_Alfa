package medonline.utils;

import medonline.entities.Customer;

import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Connection;

public class MyUtils {
	public static final String ATT_NAME_CONNECTION = "ATTRIBUTE_FOR_CONNECTION";
	 
    private static final String ATT_NAME_USER_NAME = "ATTRIBUTE_FOR_STORE_USER_NAME_IN_COOKIE";
 
    // Сохранить Connection в attribute в request.
    // Данная информация хранения существует только во время запроса (request)
    // до тех пор, пока данные возвращаются приложению пользователя.
    public static void storeConnection(ServletRequest request, Connection conn) {
        request.setAttribute(ATT_NAME_CONNECTION, conn);
    }
 
    // Получить объект Connection сохраненный в attribute в request.
    public static Connection getStoredConnection(ServletRequest request) {
        Connection conn = (Connection) request.getAttribute(ATT_NAME_CONNECTION);
        return conn;
    }
 
    // Сохранить информацию пользователя, который вошел в систему (login) в Session.
    public static void storeLoginedCustomer(HttpSession session, Customer customer) {
        // В JSP можно получить доступ через ${loginedUser}
        session.setAttribute("customer", customer);
    }
 
    // Получить информацию пользователя, сохраненная в Session.
    public static Customer getLoginedCustomer(HttpSession session) {
        Customer customer = (Customer) session.getAttribute("customer");
        return customer;
    }
 
    // Сохранить информацию пользователя в Cookie.
    public static void storeCustomerCookie(HttpServletResponse response, Customer customer) {
        System.out.println("Store customer cookie");
        Cookie cookieCustomer = new Cookie(ATT_NAME_USER_NAME, customer.getEmail());
        // 1 день (Конвертированный в секунды)
        cookieCustomer.setMaxAge(24 * 60 * 60);
        response.addCookie(cookieCustomer);
    }
 
    public static String getCustomerInCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (ATT_NAME_USER_NAME.equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }
 
    // Удалить Cookie пользователя
    public static void deleteCustomerCookie(HttpServletResponse response) {
        Cookie cookieCustomer = new Cookie(ATT_NAME_USER_NAME, null);
        // 0 секунд. (Данный Cookie будет сразу недействителен)
        cookieCustomer.setMaxAge(0);
        response.addCookie(cookieCustomer);
    }
}