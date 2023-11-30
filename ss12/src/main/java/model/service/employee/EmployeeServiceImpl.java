package model.service.employee;

import model.entity.Employee;
import utils.ConnectDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements IEmployeeService{
    private final int LIMIT = 3;
    public int totalPage = 0;

    @Override
    public List<Employee> findAll(int noPage) {
        Connection c = null;
        List<Employee> employees = new ArrayList<>();
        c = ConnectDB.opC();
        try {
            CallableStatement st = c.prepareCall("CALL PAGI_CATE(?,?,?)");
            st.setInt(1, LIMIT);
            st.setInt(2, noPage);
            st.registerOutParameter(3, Types.INTEGER);
            ResultSet rs = st.executeQuery();
            this.totalPage = st.getInt(3);
            while (rs.next()){
                Employee employee = new Employee();
                employee.setId(rs.getInt("id"));
                employee.setAddress(rs.getString("address"));
                employee.setName(rs.getString("name"));
                employee.setPhone(rs.getString("phone"));
                employee.setBirthday(rs.getDate("birthday"));
                employee.setSalary(rs.getDouble("salary"));
                employee.setSex(rs.getBoolean("sex"));
                employees.add(employee);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return employees;
    }

    public static void main(String[] args) {

    }
    @Override
    public void cOrU(Integer integer) {

    }

    @Override
    public void delete(Integer integer) {

    }

    @Override
    public Employee findById(Integer integer) {
        return null;
    }

    @Override
    public List<Employee> findByName(String eName) {
        return null;
    }
}
