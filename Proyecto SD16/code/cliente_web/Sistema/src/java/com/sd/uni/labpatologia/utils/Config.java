package com.sd.uni.labpatologia.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Config {
	private final static String URL = "url";
	private final static String CACHE_NAME = "cache.name";

	private static String _url = "";
	private static String _cache_name = "";
	
	static {
		try {
			final Properties config = new Properties();
			final FileInputStream in = new FileInputStream(
					"src/java/conf.properties");
			config.load(in);

			for (Object o : config.keySet()) {
				final String key = o.toString();
				final String value = config.getProperty(key);

				if (key.equalsIgnoreCase(URL)) {
					_url = value;
				} else if (key.equalsIgnoreCase(CACHE_NAME)) {
					_cache_name = value;
				}
			}

			in.close();
		} catch (FileNotFoundException e) {
			System.err.println(e);
		} catch (IOException e) {
			System.err.println(e);
		}
	}

	public static final String getUrl() {
		return _url;
	}

	public static final String getCacheName() {
		return _cache_name;
	}
}

