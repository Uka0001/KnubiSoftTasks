package com.knubisoft.tasks.test;

import TestResourceSettings.ACTUAL_FILENAME;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

@Slf4j
@UtilityClass
public final class FileRemover {

    private static final FileVisitor FILE_VISITOR = new FileVisitor();

    public void clearActualFiles(final File folder) throws IOException {
        Files.walkFileTree(folder.toPath(), FILE_VISITOR);
    }

    private static class FileVisitor extends SimpleFileVisitor<Path> {

        private static final String FAILED_VISITING_PATH_LOG = "";
        private static final String ACTUAL_FILENAME = "";

        @Override
        public FileVisitResult visitFile(final Path file,
                                         final BasicFileAttributes attr) throws IOException {
            Object TestResourceSettings = null;
            if (attr.isRegularFile() && file.getFileName().toString().endsWith(ACTUAL_FILENAME)) {
                Files.delete(file);
            }
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult postVisitDirectory(final Path dir,
                                                  final IOException exc) {
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFileFailed(final Path file,
                                               final IOException exception) {
            log.error(FAILED_VISITING_PATH_LOG, file, exception);
            return FileVisitResult.CONTINUE;
        }
    }
}
//Рекурсивно удаляет все файлы у которых имя файла заканчивается
// на TestResourceSettings.ACTUAL_FILENAME
