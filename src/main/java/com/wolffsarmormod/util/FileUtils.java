package com.wolffsarmormod.util;

import com.wolffsarmormod.ArmorMod;
import com.wolffsarmormod.IContentProvider;
import org.apache.commons.io.FilenameUtils;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class FileUtils
{
    private FileUtils() {}

    public static DirectoryStream<Path> createDirectoryStream(IContentProvider provider, DirectoryStream.Filter<? super Path> filter) throws IOException
    {
        if (provider.isDirectory())
        {
            return Files.newDirectoryStream(provider.path(), filter);
        }
        else if (provider.isArchive())
        {
            FileSystem fs = FileSystems.newFileSystem(provider.path());
            return new AutoCloseableDirectoryStream(Files.newDirectoryStream(fs.getPath("/"), filter), fs);
        }
        throw new IllegalArgumentException("Content Pack must be either a directory or a ZIP/JAR-archive");
    }

    public static void extractArchive(Path archivePath, Path outputDir)
    {
        try (ZipInputStream zis = new ZipInputStream(Files.newInputStream(archivePath)))
        {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null)
            {
                Path outPath = outputDir.resolve(entry.getName());

                if (entry.isDirectory())
                {
                    Files.createDirectories(outPath);
                }
                else
                {
                    Files.createDirectories(outPath.getParent());
                    try (OutputStream os = Files.newOutputStream(outPath))
                    {
                        zis.transferTo(os);
                    }
                }
            }
        }
        catch (IOException e)
        {
            ArmorMod.log.error("Failed to extract archive for content pack {}", archivePath, e);
        }
    }

    public static void repackArchive(IContentProvider provider)
    {
        try
        {
            Files.deleteIfExists(provider.path());
            Path archivePath = provider.isJarFile() ? provider.path().getParent().resolve(FilenameUtils.getBaseName(provider.name()) + ".zip") : provider.path();
            Files.deleteIfExists(archivePath);

            URI uri = URI.create("jar:" + archivePath.toUri());
            try (FileSystem zipFs = FileSystems.newFileSystem(uri, Map.of("create", "true")))
            {
                try (Stream<Path> stream = Files.walk(provider.getExtractedPath()))
                {
                    stream.forEach(source ->
                    {
                        try
                        {
                            Path relativePath = provider.getExtractedPath().relativize(source);
                            Path zipEntry = zipFs.getPath("/").resolve(relativePath.toString());

                            if (Files.isDirectory(source))
                            {
                                Files.createDirectories(zipEntry);
                            }
                            else
                            {
                                Files.createDirectories(zipEntry.getParent());
                                Files.copy(source, zipEntry, StandardCopyOption.REPLACE_EXISTING);
                            }
                        }
                        catch (IOException e)
                        {
                            ArmorMod.log.error("Error repacking archive {}", provider.getExtractedPath(), e);
                        }
                    });
                }
            }

            deleteRecursively(provider.getExtractedPath());
        }
        catch (IOException e)
        {
            ArmorMod.log.error("Error repacking archive {}", provider.getExtractedPath(), e);
        }
    }

    public static void deleteRecursively(Path dir)
    {
        if (Files.notExists(dir)) return;

        try (Stream<Path> stream = Files.walk(dir))
        {
            stream.sorted(Comparator.reverseOrder())
            .forEach(path ->
            {
                try
                {
                    Files.delete(path);
                }
                catch (IOException e)
                {
                    ArmorMod.log.error("Failed to delete {}", path, e);
                }
            });
        }
        catch (IOException e)
        {
            ArmorMod.log.error("Failed to delete {}", dir, e);
        }
    }

    private record AutoCloseableDirectoryStream(DirectoryStream<Path> delegate, FileSystem fileSystem) implements DirectoryStream<Path>
    {
        @Override
        public void close() throws IOException
        {
            delegate.close();
            fileSystem.close();
        }

        @Override
        @NotNull
        public Iterator<Path> iterator()
        {
            return delegate.iterator();
        }
    }
}
