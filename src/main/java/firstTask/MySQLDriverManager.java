package firstTask;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLDriverManager {
    private static final Logger logger = LogManager.getLogger(MySQLDriverManager.class);

    private final String url = "jdbc:mysql://localhost:3306/tmshwservlet";
    private final String username = "root";
    private final String password = "1111";

    public MySQLDriverManager() {
        init();
    }

    private void init() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        } catch (Exception ex) {
            logger.error("Ошибка загрузки драйвера");
        }
    }

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String sqlQuery = "SELECT * FROM students";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {
                Student student = new Student();
                student.setName(resultSet.getString("name"));
                student.setAge(resultSet.getInt("age"));
                student.setSex(resultSet.getString("sex"));
                student.setCourse(resultSet.getInt("course"));
                students.add(student);
            }
        } catch (SQLException ex) {
            logger.error("Ошибка с подключением к базе данных");
        }
        return students;
    }

    public void addStudent(Student student) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String sqlQuery = "INSERT INTO students(name, age, sex, course) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setInt(2, student.getAge());
            preparedStatement.setString(3, student.getSex());
            preparedStatement.setInt(4, student.getCourse());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            logger.error("Ошибка при добавлении студента в базу данных");
        }
    }
}