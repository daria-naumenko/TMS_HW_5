package firstTask;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/student")
public class StudentServlet extends HttpServlet {

    private MySQLDriverManager studentInfo;

    @Override
    public void init() {
        studentInfo = new MySQLDriverManager();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        List<Student> students = studentInfo.getAllStudents();

        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        for (Student student : students) {
            writer.println("<p>" + student.toString() + "</p>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        String sex = req.getParameter("sex");
        int course = Integer.parseInt(req.getParameter("course"));

        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        student.setSex(sex);
        student.setCourse(course);

        resp.sendRedirect(req.getContextPath() + "/student");
    }
}
