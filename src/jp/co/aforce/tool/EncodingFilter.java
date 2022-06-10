package jp.co.aforce.tool;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

//文字エンコーディングとMIMEタイプを設定するフィルタ
//"/*"でwebアプリケーション全体に適用
@WebFilter(urlPatterns = { "/*" })
public class EncodingFilter implements Filter {

	@Override
	public void doFilter(
			ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
//		System.out.println("フィルタの前処理");

		chain.doFilter(request, response);
//		System.out.println("フィルタの後処理");
	}

	public void init(FilterConfig filterConfig) {
	}

	public void destroy() {
	}
}
