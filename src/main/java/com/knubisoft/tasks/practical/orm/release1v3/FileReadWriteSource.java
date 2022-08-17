package com.knubisoft.tasks.practical.orm.release1v3;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.nio.charset.StandardCharsets;

@RequiredArgsConstructor
@Getter
final class FileReadWriteSource implements DataReadWriteSource<String> {
    private final File source;

    @Override
    @SneakyThrows
    public String getContent() {
        return FileUtils.readFileToString(source, StandardCharsets.UTF_8);
    }
}