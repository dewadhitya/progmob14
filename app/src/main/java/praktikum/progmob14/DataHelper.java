package praktikum.progmob14;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Dewa Adhitya on 11/14/2017.
 */

public class DataHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "db_kuisioner.db";
    private static final int DATABASE_VERSION = 1;
    private static final String query_table = "CREATE TABLE IF NOT EXISTS tb_kuisioner(id_kuisioner integer primary key autoincrement, nama text null, alamat, text null, aktivitas text null);";
    private static final String query_hapus_table = "DROP TABLE IF EXISTS query_table";

    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //Membuat Tabel
//        String sql = "create table tb_kuisioner(id_kuisioner integer primary key, nama text null, alamat, text null, aktivitas text null);";
//        Log.d("Data","onCreate Database: "+sql);
//        sqLiteDatabase.execSQL(sql);
//        sql = "insert into tb_kuisioner(nama, alamat, aktivitas) values ('Adhit','Jl. Mertayasa','setiap hari');";
//        sqLiteDatabase.execSQL(sql);
        sqLiteDatabase.execSQL(query_table);
        System.out.println("Tabel sudah dibuat");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int versi_lama, int versi_baru1) {
        sqLiteDatabase.execSQL(query_hapus_table);
        onCreate(sqLiteDatabase);
    }

    public void insert_data(String nama, String alamat, String aktivitas){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nama", nama);
        values.put("alamat", alamat);
        values.put("aktivitas", aktivitas);
        database.insert("tb_kuisioner", null, values);
        database.close();
    }
}
