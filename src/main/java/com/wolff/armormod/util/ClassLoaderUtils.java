package com.wolff.armormod.util;

import com.ibm.icu.impl.ClassLoaderUtil;

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Path;

public class ClassLoaderUtils
{
    private ClassLoaderUtils() {}

    /**
     * Loads a compiled Java class (.class file) from a given file path.
     * Example: ClassLoaderUtil.loadClassFromFile("C:/path/to/classes/com/example/MyClass.class", "com.example.MyClass");
     *
     * @param classFilePath The absolute path to the .class file.
     * @param className     The fully qualified name of the class (e.g., "com.example.MyClass").
     * @return The loaded {@link Class} object.
     * @throws IOException            If an I/O error occurs while accessing the file.
     * @throws ClassNotFoundException If the class cannot be found or loaded.
     */
    public static Class<?> loadClassFromFile(Path classFilePath, String className) throws IOException, ClassNotFoundException
    {
        URL classUrl = classFilePath.getParent().toUri().toURL();
        try (URLClassLoader classLoader = new URLClassLoader(new URL[] {classUrl}, ClassLoaderUtil.class.getClassLoader()))
        {
            return classLoader.loadClass(className);
        }
    }
}
