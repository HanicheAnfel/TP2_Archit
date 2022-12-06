import java.sql.*;
public interface Univ_Interface {
	public Universite GetById(int univid, IJournal journal)throws SQLException;

}
