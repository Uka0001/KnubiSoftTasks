package com.knubisoft.testtasks;

import com.google.common.base.CaseFormat;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;

public class MainClass2 {

    /*public Map<String, Object> toDatabaseFieldsMap(E e)
            throws IllegalAccessException {

        Map<String, Object> params = new LinkedHashMap();
        Field[] var3 = e.getClass().getDeclaredFields();
        int var4 = var3.length;

        for (int i = 0; i < var4; ++i) {
            Field each = var3[i];
            if (!each.isSynthetic()) {
                each.setAccessible(true);
                this.fillMapWithParams(e, params, each);
            }
        }
        return params;
    }

    private void fillMapWithParams(E e, Map<String, Object> params,
                                   Field each) throws IllegalAccessException {

        String databaseColumnName = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, each.getName());
        if (this.isSimpleDatabaseColumnName(databaseColumnName)) {
            params.put(databaseColumnName, this.unpackField(each.get(e)));
        } else {
            if (databaseColumnName.contains("_")) {
                throw new RuntimeException();
            }
            params.put(databaseColumnName, this.unpackField(each.get(e)));
        }
    }*/
}
