package me.blogger.admin.utils;

import org.springframework.util.ObjectUtils;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author Jitendra Singh.
 */
public final class DateUtils {

	private DateUtils() {}

	private final static String DEFAULT_DATE_FORMAT = "dd MMM yy";

	public static String formatDate(Date dateTime) {
		return formatDate(dateTime, DEFAULT_DATE_FORMAT);
	}

	public static String formatDate(Date dateTime, String pattern) {
		if(ObjectUtils.isEmpty(pattern)) {
			pattern = DEFAULT_DATE_FORMAT;
		}
		if(ObjectUtils.isEmpty(dateTime)) {
			return null;
		}
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		return simpleDateFormat.format(dateTime);
	}
}
