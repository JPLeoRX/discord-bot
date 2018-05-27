package io.github.jpleorx.discordbot.utils;

import java.io.File;

public class FileUtils {
    public static File loadFile(String filepath) {
        ClassLoader classLoader = FileUtils.class.getClassLoader();
        return new File(classLoader.getResource(filepath).getFile());
    }
}