package com.gmmh.androidsqlitecrud;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;

import com.gmmh.androidsqlitecrud.Model.SQLiteCRUD;

import java.util.HashMap;
import java.util.Map;

/**
 * JavaDoc
 * @author      G. Mizael Mtz Hdz
 * @version     1.0.0   (current version number of program)
 * @since       1.0.0     (the version of the package this class was first added to)
 */
public class Main extends Activity {

    /**
     * Función onCreate
     * @param  savedInstanceState
     * @return void
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Example
        this.example();
    }
    public void example()
    {
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


        //INSERT
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "José José");
        map.put("salary", "1000");
        map.put("phone", "+1111111111");
        sqLiteCRUD.insert("employee",map);


        //SELECT
        Cursor cursor=sqLiteCRUD.select("employee",new HashMap<String, String>(),null,null);
        int count=0;
        if(cursor.moveToFirst())
        {
            do
            {
                String idemployee= cursor.getString(cursor.getColumnIndex("idemployee"));
                String name = cursor.getString(cursor.getColumnIndex("name"));
                Double salary = Double.parseDouble(cursor.getString(cursor.getColumnIndex("salary")));
                String phone = cursor.getString(cursor.getColumnIndex("phone"));

                System.out.println("ID: "+idemployee);
                System.out.println("NAME: "+name);
                System.out.println("SALARY: "+salary);
                System.out.println("PHONE: "+phone);

                count++;
            } while(cursor.moveToNext());
        }
        cursor.close();


        //UPDATE
        Map<String, String> mapUpdate = new HashMap<String, String>();
        mapUpdate.put("phone","+2222222222");
        Map<String, String> mapWhere = new HashMap<String, String>();
        mapWhere.put("idemployee","1");
        sqLiteCRUD.update("employee",mapUpdate,mapWhere);


        //SELECT
        cursor=sqLiteCRUD.select("employee",new HashMap<String, String>(),null,null);
        count=0;
        if(cursor.moveToFirst())
        {
            do
            {
                String idemployee= cursor.getString(cursor.getColumnIndex("idemployee"));
                String name = cursor.getString(cursor.getColumnIndex("name"));
                Double salary = Double.parseDouble(cursor.getString(cursor.getColumnIndex("salary")));
                String phone = cursor.getString(cursor.getColumnIndex("phone"));

                System.out.println("ID: "+idemployee);
                System.out.println("NAME: "+name);
                System.out.println("SALARY: "+salary);
                System.out.println("PHONE: "+phone);

                count++;
            } while(cursor.moveToNext());
        }
        cursor.close();


        //DELETE
        sqLiteCRUD.delete("employee","WHERE idemployee >1");
        sqLiteCRUD.delete("employee");
    }
}