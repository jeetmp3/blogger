package me.blogger.admin.utils;

import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Jitendra Singh.
 */
public final class DateUtils {

	private DateUtils() {}

	private final static String DEFAULT_DATE_FORMAT = "dd MMM yy";

	public static String formatDate(LocalDateTime dateTime) {
		return formatDate(dateTime, DEFAULT_DATE_FORMAT);
	}

	public static String formatDate(LocalDateTime dateTime, String pattern) {
		if(ObjectUtils.isEmpty(pattern)) {
			pattern = DEFAULT_DATE_FORMAT;
		}
		if(ObjectUtils.isEmpty(dateTime)) {
			return null;
		}
		return dateTime.format(DateTimeFormatter.ofPattern(pattern));
	}
}
