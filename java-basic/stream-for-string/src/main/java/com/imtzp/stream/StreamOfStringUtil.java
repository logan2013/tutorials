package com.imtzp.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamOfStringUtil {

	public static String join(String[] arrayOfString) {
		return Arrays.asList(arrayOfString).stream().collect(Collectors.joining(","));
	}

	public static String joinWithPrefixPostfix(String[] arrayOfString) {
		return Arrays.asList(arrayOfString).stream().collect(Collectors.joining(",", "[", "]"));
	}

	public static List<String> split(String str) {
		return Stream.of(str.split(",")).collect(Collectors.toList());
	}

	public static List<Character> splitToListOfChar(String str) {
		return str.chars().mapToObj(item -> (char) item).collect(Collectors.toList());
	}
	
}
