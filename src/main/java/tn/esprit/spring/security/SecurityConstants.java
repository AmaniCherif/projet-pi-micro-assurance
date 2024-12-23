package tn.esprit.spring.security;

public class SecurityConstants {
	public static final String CONTRACTOFFER = "/contractOffer/**";
	public static final String ACCOUNTING = "/accounting/**";
	public static final String SIGN_UP_URLS = "/users/**";
	 public static final String H2_URL = "h2-console/**";
	 public static final String SECRET = "SecretKeyToGenJWTs";
	 public static final String TOKEN_PREFIX = "Bearer ";
	 public static final String HEADER_STRING = "Authorization";
	 public static final long EXPIRATION_TIME = 300000_000; //300000 seconds
}
