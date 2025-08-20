package jdbcmvc.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbcmvc.dao.PersonDao;
import jdbcmvc.model.Person;
import jdbcmvc.util.ConnectionUtil;

public class PersonDaoImpl implements PersonDao {
	
	@Override
	public List<Person> listPerson() throws Exception {
		Object[] objArr = getPreparedStatement(" select * from person order by pid desc ");
		ResultSet rs = ((PreparedStatement)objArr[1]).executeQuery();
		List<Person> personList = new ArrayList<Person>();
		while(rs.next()) {
			personList.add(new Person(rs.getInt("pid"),rs.getString("pname"),rs.getInt("page")));
		}
		ConnectionUtil.close((Connection)objArr[0], rs, (Statement)objArr[1]);
		return personList;
	}

	@Override
	public Person getPerson(int pid) throws Exception {
		Object[] objArr = getPreparedStatement(" select * from person where pid=? ");
		PreparedStatement pstmt = (PreparedStatement)objArr[1];
		pstmt.setInt(1, pid);
		ResultSet rs = pstmt.executeQuery();
		Person person = null;
		if(rs.next()) {
			person = new Person(rs.getInt("pid"), rs.getString("pname"), rs.getInt("page"));
		}
		ConnectionUtil.close((Connection)objArr[0], rs, pstmt);
		return person;
	}

	@Override
	public int writePerson(Person person) throws Exception {
		Object[] objArr = getPreparedStatement(" insert into person values(seq_person.nextval, ?, ?) ");
		PreparedStatement pstmt = (PreparedStatement)objArr[1];
		pstmt.setString(1, person.getPname());
		pstmt.setInt(2, person.getPage());
		int result = pstmt.executeUpdate();
		ConnectionUtil.close((Connection)objArr[0], null, pstmt);
		return result;
	}

	@Override
	public int updatePerson(Person person) throws Exception {
		Object[] objArr = getPreparedStatement(" update person set pname=?, page=? where pid=? ");
		PreparedStatement pstmt = (PreparedStatement)objArr[1];
		pstmt.setString(1, person.getPname());
		pstmt.setInt(2, person.getPage());
		pstmt.setInt(3, person.getPid());
		int result = pstmt.executeUpdate();
		ConnectionUtil.close((Connection)objArr[0], null, pstmt);
		return result;
	}

	@Override
	public int deletePerson(int pid) throws Exception {
		Object[] objArr = getPreparedStatement(" delete from person where pid=? ");
		PreparedStatement pstmt = (PreparedStatement)objArr[1];
		pstmt.setInt(1, pid);
		int result = pstmt.executeUpdate();
		ConnectionUtil.close((Connection)objArr[0], null, pstmt);
		return result;
	}

	@Override
	public int countPerson() throws Exception {
		Object[] objArr = getPreparedStatement(" select * from person ");
		PreparedStatement pstmt = (PreparedStatement)objArr[1];
		int result = pstmt.executeUpdate();
		ConnectionUtil.close((Connection)objArr[0], null, pstmt);
		return result;
	}
	
	private Object[] getPreparedStatement(String sql) throws Exception {
		Connection conn = ConnectionUtil.getConnectionUtil().getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		return new Object[] {conn, pstmt};
	}

}
