package com.knubisoft.tasks.practical.orm.release1v3;

import java.util.List;

public interface DataReadWriteSource<ReadType> {
    ReadType getContent();
}