package com.efun.pf.member.config.platform;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class PlatformsFactory {

	private static final Logger logger = Logger.getLogger(PlatformsFactory.class);
	public static final Map<String, Platforms> platformsMap = new HashMap<String, Platforms>();

	private static Platforms newInstance(String platform) {
		try {
			String packageName = PlatformsFactory.class.getPackage().getName();
			String className = packageName + "." + StringUtils.capitalize(platform) + "Platform";
			logger.info("create dept: " + className);
			Platforms platforms = (Platforms) Class.forName(className).newInstance();
			platformsMap.put(platform, platforms);
			return platforms;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}

	public static Platforms create(String platform) {
		Platforms platforms = platformsMap.get(platform);
		if (platforms == null) {
			platforms = newInstance(platform);
		}
		return platforms;
	}

}
