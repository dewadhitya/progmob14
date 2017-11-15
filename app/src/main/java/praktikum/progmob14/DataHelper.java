package praktikum.progmob14;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Dewa Adhitya on 11/14/2017.
 */

public class DataHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "db_kuisioner.db";
    private static final int DATABASE_VERSION = 1;
    public DataHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //Membuat Tabel
        String sql = "create table tb_kuisioner(id_kuisioner integer primary key, nama text null, alamat, text null, aktivitas text null);";
        Log.d("Data","onCreate: "+sql);
        sqLiteDatabase.execSQL(sql);
        sql = "insert into tb_kuisioner(id_kuisioner, nama, alamat, aktivitas) values ('1','Adhit','Jl. Mertayasa','setiap hari');";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
