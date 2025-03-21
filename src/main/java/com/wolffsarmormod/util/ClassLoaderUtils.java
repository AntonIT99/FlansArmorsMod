package com.wolffsarmormod.util;

import com.wolffsarmormod.IContentProvider;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Map;

public class ClassLoaderUtils
{
    private ClassLoaderUtils() {}

    public static final CustomClassLoader CLASS_LOADER = new CustomClassLoader();

    private static final Map<String, String> minecraftMethodMappings = Map.ofEntries(
        Map.entry("func_78784_a", "setTextureOffset"),
        Map.entry("func_78785_a", "render"),
        Map.entry("func_78786_a", "addBox"),
        Map.entry("func_78787_b", "setTextureSize"),
        Map.entry("func_78788_d", "compileDisplayList"),
        Map.entry("func_78789_a", "addBox"),
        Map.entry("func_78790_a", "addBox"),
        Map.entry("func_78791_b", "renderWithRotation"),
        Map.entry("func_78792_a", "addChild"),
        Map.entry("func_78793_a", "setRotationPoint"),
        Map.entry("func_78794_c", "postRender")
    );

    private static final Map<String, String> minecraftFieldMappings = Map.ofEntries(
        Map.entry("field_78782_b", "textureOffsetY"),
        Map.entry("field_78783_a", "textureOffsetX"),
        Map.entry("field_78795_f", "rotateAngleX"),
        Map.entry("field_78796_g", "rotateAngleY"),
        Map.entry("field_78797_d", "rotationPointY"),
        Map.entry("field_78798_e", "rotationPointZ"),
        Map.entry("field_78799_b", "textureHeight"),
        Map.entry("field_78800_c", "rotationPointX"),
        Map.entry("field_78801_a", "textureWidth"),
        Map.entry("field_78802_n", "boxName"),
        Map.entry("field_78803_o", "textureOffsetX"),
        Map.entry("field_78804_l", "cubeList"),
        Map.entry("field_78805_m", "childModels"),
        Map.entry("field_78806_j", "showModel"),
        Map.entry("field_78807_k", "isHidden"),
        Map.entry("field_78808_h", "rotateAngleZ"),
        Map.entry("field_78809_i", "mirror"),
        Map.entry("field_78810_s", "baseModel"),
        Map.entry("field_78811_r", "displayList"),
        Map.entry("field_78812_q", "compiled"),
        Map.entry("field_78813_p", "textureOffsetY"),
        Map.entry("field_82906_o", "offsetX,0"),
        Map.entry("field_82907_q", "offsetZ,0"),
        Map.entry("field_82908_p", "offsetY,0")
    );

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

    public static Class<?> loadAndModifyClass(IContentProvider contentProvider, String className) throws IOException
    {
        String relativeClassPath = className.replace('.', '/') + ".class";

        byte[] classData;

        if (contentProvider.isDirectory())
        {
            classData = Files.readAllBytes(contentProvider.path().resolve(relativeClassPath));
        }
        else if (contentProvider.isArchive())
        {
            classData = readFileBytesFromArchive(contentProvider.path(), relativeClassPath);
        }
        else
        {
            throw new IllegalArgumentException(contentProvider.path() + " is not an existing directory or JAR/ZIP file.");
        }

        ClassReader classReader = new ClassReader(classData);
        ClassWriter classWriter = new ClassWriter(classReader, 0);

        ReferenceModifierClassVisitor classVisitor = new ReferenceModifierClassVisitor(classWriter,
                "net/minecraft/client/model/ModelBase",
                "com/wolffsarmormod/client/model/IModelBase",
                minecraftMethodMappings, minecraftFieldMappings);

        classReader.accept(classVisitor, 0);

        byte[] modifiedClassData = classWriter.toByteArray();

        //TODO: Use default class loader and add locations to the classpath
        return CLASS_LOADER.defineClass(className, modifiedClassData);
    }

    // Custom ClassLoader to define classes
    private static class CustomClassLoader extends ClassLoader
    {
        public Class<?> defineClass(String name, byte[] b)
        {
            return super.defineClass(name, b, 0, b.length);
        }
    }

    private static byte[] readFileBytesFromArchive(Path archivePath, String filePath) throws IOException
    {
        try (FileSystem fs = FileSystems.newFileSystem(archivePath))
        {
            Path fileInArchive = fs.getPath(filePath);

            try (InputStream inputStream = Files.newInputStream(fileInArchive, StandardOpenOption.READ))
            {
                return inputStream.readAllBytes();
            }
        }
    }
}
