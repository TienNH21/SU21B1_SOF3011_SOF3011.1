package utils;

import org.mindrot.jbcrypt.BCrypt;

public class HashUtil {
	public static String hash(String origin)
	{
		String salt = BCrypt.gensalt(12);
		return BCrypt.hashpw(origin, salt);
	}

	public static boolean verify(String origin, String hashed)
	{
		return BCrypt.checkpw(origin, hashed);
	}
}
