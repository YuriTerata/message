package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jp.co.aforce.tool.SQL;

public class MemberDAO extends DAO {

	//会員情報存在チェック
	public int exist(
			String last_name,
			String first_name,
			String sex,
			int birth_year,
			int birth_month,
			int birth_day,
			String job,
			String phone_number,
			String mail_address) throws Exception {

		int count = 0;

		try {

			Connection con = getConnection();

			String sql = SQL.SQL_KK01_S01;
			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, last_name);
			st.setString(2, first_name);
			st.setString(3, sex);
			st.setInt(4, birth_year);
			st.setInt(5, birth_month);
			st.setInt(6, birth_day);
			st.setString(7, job);
			st.setString(8, phone_number);
			st.setString(9, mail_address);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				count = rs.getInt("count(*)");
			}

			st.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return count;
	}

	//データベースへデータを登録するメソッド
	//KK-01-01
	public int insert(
			String member_id,
			String last_name,
			String first_name,
			String sex,
			int birth_year,
			int birth_month,
			int birth_day,
			String job,
			String phone_number,
			String mail_address) throws Exception {

		int count = 0;

		try {

			Connection con = getConnection();

			String sql = SQL.SQL_KK01_I01;
			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, member_id);
			st.setString(2, last_name);
			st.setString(3, first_name);
			st.setString(4, sex);
			st.setInt(5, birth_year);
			st.setInt(6, birth_month);
			st.setInt(7, birth_day);
			st.setString(8, job);
			st.setString(9, phone_number);
			st.setString(10, mail_address);
			count = st.executeUpdate();

			st.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;

	}

//	public int delete() {
//
//	}

}