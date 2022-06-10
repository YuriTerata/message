package jp.co.aforce.tool;

public class SQL {

	//入力された条件に一致する会員情報テーブルのデータ件数を取得する。
	public static final String SQL_KK01_S01 = "SELECT COUNT(*) FROM member_info WHERE last_name = ? AND first_name = ? AND sex = ? AND  birth_year = ? AND birth_month = ? AND birth_day = ? AND job = ? AND phone_number = ? AND mail_address = ?";

	//入力された値を会員情報テーブルに登録する。
	public static final String SQL_KK01_I01 = "INSERT INTO MEMBER_INFO values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

}
