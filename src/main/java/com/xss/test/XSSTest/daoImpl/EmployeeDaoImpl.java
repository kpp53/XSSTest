package com.xss.test.XSSTest.daoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.xss.test.XSSTest.dao.EmployeeDao;
import com.xss.test.XSSTest.employee.Employee;

@Repository
public class EmployeeDaoImpl /*extends JdbcDaoSupport*/ implements EmployeeDao{
	
	/*@Autowired 
	DataSource dataSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}*/
	
	private List<Employee> employeeList;
	@PostConstruct
	private void initialize(){
		employeeList =  new ArrayList<>(); 
	}
	
	/*@Autowired(required=true)
	JdbcTemplate jdbcTemplate;*/
	
	@Override
	public void insertEmployee(Employee emp) {
		employeeList.add(emp);
		/*String sql = "INSERT INTO employee " +
				"(empId, empName) VALUES (?, ?)" ;
		jdbcTemplate.update(sql, new Object[]{
				emp.getEmpId(), emp.getEmpName()
		});*/
	}
	
	@Override
	public void insertEmployees(final List<Employee> employees) {
		employeeList.addAll(employees);
		/*String sql = "INSERT INTO employee " + "(empId, empName) VALUES (?, ?)";
		jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				Employee employee = employees.get(i);
				ps.setString(1, employee.getEmpId());
				ps.setString(2, employee.getEmpName());
			}
			
			public int getBatchSize() {
				return employees.size();
			}
		});*/
	}
	
	@Override
	public List<Employee> getAllEmployees(){
		/*String sql = "SELECT * FROM employee";
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		
		List<Employee> result = new ArrayList<Employee>();
		for(Map<String, Object> row:rows){
			Employee emp = new Employee();
			emp.setEmpId((String)row.get("empId"));
			emp.setEmpName((String)row.get("empName"));
			result.add(emp);
		}*/
		
		return employeeList;
	}

	@Override
	public Employee getEmployeeById(String empId) {
		/*String sql = "SELECT * FROM employee WHERE empId = ?";
		return (Employee)jdbcTemplate.queryForObject(sql, new Object[]{empId}, new RowMapper<Employee>(){
			@Override
			public Employee mapRow(ResultSet rs, int rwNumber) throws SQLException {
				Employee emp = new Employee();
				emp.setEmpId(rs.getString("empId"));
				emp.setEmpName(rs.getString("empName"));
				return emp;
			}
		});*/
		
		return  employeeList.stream().filter(p -> p.getEmpId().equalsIgnoreCase(empId)).findFirst().get();
		
	}
}