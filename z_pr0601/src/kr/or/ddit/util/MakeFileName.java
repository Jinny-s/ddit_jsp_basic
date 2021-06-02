package kr.or.ddit.util;

import java.util.UUID;

public class MakeFileName {
	
	public static String toUUIDFileName(String fileName, String delimeter) {
		String uuid = UUID.randomUUID().toString().replace("-", "");
		return uuid + delimeter + fileName;
	}
	
	public static String parseFileNameFromUUID(String fileName, String delimeter) {
		String[] uuidFileName = fileName.split(delimeter);
		return uuidFileName[uuidFileName.length - 1];
	}
	
}
