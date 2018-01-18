# Android SQLite CRUD
CRUD SQLite for JAVA - ANDROID

## Implement
### Create
```
//CREATE DATABASE: db & TABLE: employee
        int db_version=1;
        String db_name="db";
        String db_sql_create="CREATE TABLE IF NOT EXISTS employee(\n" +
                "                idemployee INTEGER NOT NULL PRIMARY KEY,\n" +
                "                name VARCHAR(30) NOT NULL,\n" +
                "                salary DOUBLE NOT NULL,\n" +
                "                phone VARCHAR(15) NOT NULL\n" +
                "                ); ";
        String db_sql_delete="DROP TABLE IF EXISTS employee;";
        Context context=this;
        SQLiteCRUD sqLiteCRUD=new SQLiteCRUD(context,db_version,db_name,db_sql_create,db_sql_delete);
```

## Classes Hierarchy
Class Hierarchy:
```
+-----------------+
|SQLiteOpenHelper |
+-------+---------+
        |
+-------v---------+
|SQLiteConnection |
+-------+---------+
        |
+-------v---------+
|SQLiteCRUD       |
+-----------------+
```
# Authors
- [@G. Mizael Mtz Hdz](https://github.com/martinezmizael)
