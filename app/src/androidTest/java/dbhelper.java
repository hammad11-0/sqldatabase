import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.media.session.PlaybackState;

import androidx.annotation.Nullable;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class dbhelper extends SQLiteOpenHelper {
    public static final String STUDENT_NAME = "STUDENTName";
    public static final String STUDENT_PHNO = "STUDENTPHNO";
    public static final String STUDENT_ID = "STUDENTPHNO";

    public static final String STUDENT_TABLE = "StudentTable";

    public dbhelper(@Nullable Context context) {
        super(context, "studentDB.db", null, 4);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //String createTableSTatementOne = "CREATE TABLE CustTable(STUDENTID Integer PRIMARY KEY AUTOINCREMENT, " + STUDENT_NAME_FIRST + " Text, STUDENTAge Int, ActiveSTUDENT BOOL) ";
        String createTableSTatement = "CREATE TABLE " + STUDENT_TABLE + "(" + STUDENT_ID + " Integer PRIMARY KEY AUTOINCREMENT, " + STUDENT_NAME + " Text, " + STUDENT_PHNO + " Int) " ;
        db.execSQL(createTableSTatement);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + STUDENT_TABLE);
        onCreate(db);
    }

    public void  addStudent(student STUDENTModel){
        SQLiteDatabase db = this.getWritableDatabase();
        //Hash map, as we did in bundles
        ContentValues cv = new ContentValues();

        cv.put(STUDENT_NAME, STUDENTModel.getName());
        cv.put(STUDENT_PHNO, STUDENTModel.getPhno());

        db.insert(STUDENT_TABLE, null, cv);
        db.close();

        //NullCoumnHack
        //long insert =
        //if (insert == -1) { return false; }
        //else{return true;}
    }

    public ArrayList<student> getAllStudents() {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursorCourses = db.rawQuery("SELECT * FROM " + STUDENT_TABLE, null);

        ArrayList<student> studentArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorCourses.moveToFirst()) {
            do {

                studentArrayList.add(new student(cursorCourses.getString(1),
                        cursorCourses.getInt(2)));
            } while (cursorCourses.moveToNext());

        }

        cursorCourses.close();
        return studentArrayList;
    }
}