package jp.co.aforce.tool;

public class NullCheck {
	public static String getString(
			String last_name,
			String first_name,
			String sex,
			String birth_year,
			String birth_month,
			String birth_day,
			String job,
			String phone_number,
			String mail_address) throws Exception {

		if (last_name.equals("")) {
			return "姓";
		}

		if (first_name.equals("")) {
			return "名";
		}

		if (sex.equals("")) {
			return "性別";
		}

		if (birth_year.equals("")) {
			return "年";
		}

		if (birth_month.equals("")) {
			return "月";
		}

		if (birth_day.equals("")) {
			return "日";
		}

		if (job.equals("")) {
			return "職業";
		}

		if (phone_number.equals("")) {
			return "電話番号";
		}

		if (mail_address.equals("")) {
			return "メールアドレス";
		}

		return "";
	}
}
