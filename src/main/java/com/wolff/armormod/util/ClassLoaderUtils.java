package com.wolff.armormod.util;

import org.apache.commons.vfs2.FileObject;
import org.apache.commons.vfs2.FileSystemManager;
import org.apache.commons.vfs2.VFS;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Path;

public class ClassLoaderUtils
{
    private ClassLoaderUtils() {}

    /**
     * Loads a compiled Java class (.class file) from a given file path.
     * <p>
     * Examples:
     * <p>
     * - In File System "C:/parent/com/example/MyClass.class": <p>
     * ClassLoaderUtil.loadClass(Path.of("C://parent"), "com.example.MyClass");
     * <p>
     * - In JAR Archive "C:/archive.jar/com/example/MyClass.class": <p>
     * ClassLoaderUtil.loadClass(Path.of("C://archive.jar"), "com.example.MyClass");
     * <p>
     * - In ZIP Archive "C:/archive.zip/com/example/MyClass.class": <p>
     * ClassLoaderUtil.loadClass(Path.of("C://archive.zip"), "com.example.MyClass");
     *
     * @param parentPath    The parent path to the package root of the .class file.
     * @param className     The fully qualified name of the class (e.g., "com.example.MyClass").
     * @return The loaded {@link Class} object.
     * @throws IOException            If an I/O error occurs while accessing the file.
     * @throws ClassNotFoundException If the class cannot be found or loaded.
     */
    public static Class<?> loadClass(Path parentPath, String className) throws IOException, ClassNotFoundException
    {
        try (URLClassLoader classLoader = new URLClassLoader(new URL[] { parentPath.toUri().toURL() }))
        {
            return classLoader.loadClass(className);
        }
    }

    public static Class<?> loadAndModifyClass(Path parentPath, String className) throws IOException
    {
        // Load the class file into a byte array
        String relativeClassPath = className.replace('.', '/') + ".class";
        Path classPath = parentPath.resolve(relativeClassPath);

        //TODO: check for file system, zip
        //byte[] classData = Files.readAllBytes(classPath);
        byte[] classData = readFileBytesFromJar(parentPath, relativeClassPath);
        // Modify the class bytecode
        ClassReader classReader = new ClassReader(classData);
        ClassWriter classWriter = new ClassWriter(classReader, 0);

        // Use a custom ClassVisitor to modify the superclass
        ReferenceModifierClassVisitor classVisitor = new ReferenceModifierClassVisitor(classWriter, "net/minecraft/client/model/ModelBase", "com/wolff/armormod/client/model/IModelBase");

        // Apply the visitor to modify the class
        classReader.accept(classVisitor, 0);

        // Get the modified byte array
        byte[] modifiedClassData = classWriter.toByteArray();

        // Define the modified class using the custom class loader
        return new CustomClassLoader().defineClass(className, modifiedClassData);
    }

    // Custom ClassLoader to define classes
    private static class CustomClassLoader extends ClassLoader
    {
        public Class<?> defineClass(String name, byte[] b)
        {
            return super.defineClass(name, b, 0, b.length);
        }
    }

    public static byte[] readFileBytesFromJar(Path archivePath, String filePath) throws IOException
    {
        // Create a FileSystemManager
        FileSystemManager fsManager = VFS.getManager();

        // Open the JAR file as a virtual file system
        FileObject jarFile = fsManager.resolveFile("jar:file://" + archivePath.toUri().getPath());

        // Access the file inside the JAR
        FileObject fileInJarObject = jarFile.resolveFile(filePath);

        try (InputStream inputStream = fileInJarObject.getContent().getInputStream();
             ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream())
        {

            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) != -1)
            {
                byteArrayOutputStream.write(buffer, 0, length);
            }

            return byteArrayOutputStream.toByteArray();
        }
    }
}
