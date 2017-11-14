package praktikum.progmob14;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Dewa Adhitya on 11/14/2017.
 */

public class DataHelper extends SQLiteOpenHelper {
    public DataHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //Membuat Tabel
        String sql = "create table tb_kuisioner(id_kuisioner integer primary key, nama text null, alamat, text null, aktivitas text null);";
        Log.d("Data","onCreate: "+sql);
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
