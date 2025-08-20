package jdbcmvc.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jdbcmvc.dao.PersonDao;
import jdbcmvc.model.Person;
import jdbcmvc.util.ConnectionUtil;

public class PersonDaoImpl implements PersonDao {
	
	@Override
	public List<Person> listPerson() throws Exception {
		String sql = " select * from person order by pid desc ";
		Connection conn = ConnectionUtil.getConnectionUtil().getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		List<Person> personList = new ArrayList<Person>();
		while(rs.next()) {
			personList.add(new Person(rs.getInt("pid"),rs.getString("pname"),rs.getInt("page")));
		}
		ConnectionUtil.getConnectionUtil().close(conn, rs, pstmt);
		return personList;
	}

	@Override
	public Person getPerson(int pid) throws Exception {
		String sql = " select * from person where pid=? ";
		Connection conn = ConnectionUtil.getConnectionUtil().getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, pid);
		ResultSet rs = pstmt.executeQuery();
		Person person = null;
		if(rs.next()) {
			person = new Person(rs.getInt("pid"), rs.getString("pname"), rs.getInt("page"));
		}
		ConnectionUtil.getConnectionUtil().close(conn, rs, pstmt);
		return person;
	}

	@Override
	public int writePerson(Person person) throws Exception {
		String sql = " insert into person values(seq_person.nextval, ?, ?) ";
		Connection conn = ConnectionUtil.getConnectionUtil().getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, person.getPname());
		pstmt.setInt(2, person.getPage());
		int result = pstmt.executeUpdate();
		if(conn!=null) conn.commit();
		ConnectionUtil.getConnectionUtil().close(conn, null, pstmt);
		return result;
	}

	@Override
	public int updatePerson(Person person) throws Exception {
		String sql = " update person set pname=?, page=? where pid=? ";
		Connection conn = ConnectionUtil.getConnectionUtil().getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, person.getPname());
		pstmt.setInt(2, person.getPage());
		pstmt.setInt(3, person.getPid());
		int result = pstmt.executeUpdate();
		if(conn!=null) conn.commit();
		ConnectionUtil.getConnectionUtil().close(conn, null, pstmt);
		return result;
	}

	@Override
	public int deletePerson(int pid) throws Exception {
		String sql = " delete from person where pid=? ";
		Connection conn = ConnectionUtil.getConnectionUtil().getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, pid);
		int result = pstmt.executeUpdate();
		if(conn!=null) conn.commit();
		ConnectionUtil.getConnectionUtil().close(conn, null, pstmt);
		return result;
	}

	@Override
	public int countPerson() throws Exception {
		String sql = " select * from person ";
		Connection conn = ConnectionUtil.getConnectionUtil().getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		int result = pstmt.executeUpdate();
		ConnectionUtil.getConnectionUtil().close(conn, null, pstmt);
		return result;
	}

}
