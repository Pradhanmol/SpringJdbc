package org.SprinJdbc.dao;

import org.SprinJdbc.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Component("studentDao")
public class StudentDaoImpl implements StudentDao{
    private JdbcTemplate jdbcTemplate;
    private  Student id;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insert(Student student) {
        //insert query
        String query = "insert into springJdbc.student(id,name,city,pincode) values(?,?,?,?)";
        int r = this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity(),student.getPincode());
        return r;
    }

    @Override
    public int change(Student student) {
        String query = "update student set name = ?, city = ? where id = ?";
        int r = this.jdbcTemplate.update(query,student.getName(),student.getCity(),student.getId());
        return r;
    }

    @Override
    public int delete(Student student) {
        String query = "delete from student where id =?";
        int r = this.jdbcTemplate.update(query,student.getId());
        return r;
    }

    @Override
    public Student getStudent(int id) {
        //select query
        String query = "select * from student where id = ?";
        // student get the data throgh row mapper class
        /*RowMapper<Student> rowMapper = new RowMapperImpl();
        *//*Student student = this.jdbcTemplate.queryForObject(query, rowMapper, id);*/
        // student get the data without row mapper class it means annonyomus class
        Student student = this.jdbcTemplate.queryForObject(query, new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                Student student = new Student();
                student.setId(rs.getInt(1));
                student.setName(rs.getString(2));
                student.setCity(rs.getString(3));
                student.setPincode(rs.getInt(4));
                return student;
            }
        }, id);
        return student;
    }

    @Override
    public List<Student> getAllStudent() {
        String query = "select * from student";
        List<Student> students = this.jdbcTemplate.query(query,new RowMapperImpl());
        return students;
    }


}
