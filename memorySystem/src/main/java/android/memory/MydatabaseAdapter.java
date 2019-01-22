package android.memory;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Toast;

public class MydatabaseAdapter {
	private static final String TAG="MydatabaseAdepter";
    static final String KEY_ID="_id";
	static final String KEY_NAME="name";
	static final String KEY_DATE="date";
	static final String KEY_DAY="day";
	static final String KEY_ALERTDAY="alertday";
	static final String KEY_SEAT="seat";
	private static final String DB_NAME="Mydata.db";
	private static final String DB_TABLE="food";
	private static final String DB_TABLEICE="ice";
	private static final String DB_TABLEKITCHEN="kitchen";
	private static final String DB_TABLEROOM="room";
	private static final int DB_VERSION=1;
	private Context mContext=null;
	
	//private static final String DB_CREATE="CREATE TABLE"+DB_TABLE+"("+KEY_ID+"INTEGER PRIMARY KEY"+KEY_NAME+"TEXT"+KEY_DATE+"TEXT"+KEY_DAY+"TEXT)";
	//执行open（）打开数据库时，保存返回的数据库对象
	private SQLiteDatabase mSQLiteDatabase=null;
	//由SQLiteOpenHelper继承过来
	private DatabaseHelper mDatabasehelper=null;
	
	private static class DatabaseHelper extends SQLiteOpenHelper
	{
		/*创建数据库*/
		DatabaseHelper(Context context)
		{
			super (context,DB_NAME,null,DB_VERSION);
		}
		/*创建表*/
		@Override
		public void onCreate(SQLiteDatabase db)
		{
			String DB_CREATE="CREATE TABLE food(_id INTEGER PRIMARY KEY,name TEXT,date TEXT,day INT,alertday INT,seat TEXT)";
			db.execSQL(DB_CREATE);
			String DB_CREATEICE="CREATE TABLE ice(_id INTEGER PRIMARY KEY,name TEXT,date TEXT,day INT,alertday INT,seat TEXT)";
			db.execSQL(DB_CREATEICE);
			String DB_CREATEKITCHEN="CREATE TABLE kitchen(_id INTEGER PRIMARY KEY,name TEXT,date TEXT,day INT,alertday INT,seat TEXT)";
			db.execSQL(DB_CREATEKITCHEN);
			String DB_CREATEROOM="CREATE TABLE room(_id INTEGER PRIMARY KEY,name TEXT,date TEXT,day INT,alertday INT,seat TEXT)";
			db.execSQL(DB_CREATEROOM);
		
		}
		/*升级数据库*/
		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			db.execSQL("DROP TABLE IF EXISTS notes");
			onCreate(db);
		}
	}
	
	/*构造函数，取得Context*/
	public MydatabaseAdapter(Context context)
	{
		mContext=context;
	}
	
	/*打开数据库，返回数据库对象*/
	public void open() throws SQLException
	{
		mDatabasehelper =new DatabaseHelper(mContext);
		mSQLiteDatabase =mDatabasehelper.getWritableDatabase();
	}
	
	/*关闭数据库*/
	public void close()
	{
		mDatabasehelper.close();
	}
	
	/*插入数据*/
	public long insertData(String name,String date,int day,int alertday,String seat)
	{
		ContentValues initialValues =new ContentValues();
		initialValues.put(KEY_NAME, name);
		initialValues.put(KEY_DATE, date);
		initialValues.put(KEY_DAY, day);
		initialValues.put(KEY_ALERTDAY, alertday);
		initialValues.put(KEY_SEAT, seat);
		return mSQLiteDatabase.insert(DB_TABLE, KEY_ID, initialValues);
	}
	
	public long insertDataice(String name,String date,int day,int alertday,String seat)
	{
		ContentValues initialValues =new ContentValues();
		initialValues.put(KEY_NAME, name);
		initialValues.put(KEY_DATE, date);
		initialValues.put(KEY_DAY, day);
		initialValues.put(KEY_ALERTDAY, alertday);
		initialValues.put(KEY_SEAT, seat);
		return mSQLiteDatabase.insert(DB_TABLEICE, KEY_ID, initialValues);
	}
	
	public long insertDatakitvhen(String name,String date,int day,int alertday,String seat)
	{
		ContentValues initialValues =new ContentValues();
		initialValues.put(KEY_NAME, name);
		initialValues.put(KEY_DATE, date);
		initialValues.put(KEY_DAY, day);
		initialValues.put(KEY_ALERTDAY, alertday);
		initialValues.put(KEY_SEAT, seat);
		return mSQLiteDatabase.insert(DB_TABLEKITCHEN, KEY_ID, initialValues);
	}
	
	public long insertDataroom(String name,String date,int day,int alertday,String seat)
	{
		ContentValues initialValues =new ContentValues();
		initialValues.put(KEY_NAME, name);
		initialValues.put(KEY_DATE, date);
		initialValues.put(KEY_DAY, day);
		initialValues.put(KEY_ALERTDAY, alertday);
		initialValues.put(KEY_SEAT, seat);
		return mSQLiteDatabase.insert(DB_TABLEROOM, KEY_ID, initialValues);
	}
	
	//删除全部数据
	public boolean deleteAlldata()
	{
		return mSQLiteDatabase.delete(DB_TABLE, null, null)>0;
	}
	
	/*删除数据*/
	public boolean deleteData(String rowName)
	{
		return mSQLiteDatabase.delete(DB_TABLE, KEY_NAME+"= ?",new String[]{rowName})>0;
	}
	
	public boolean deleteDataice(String rowName)
	{
		return mSQLiteDatabase.delete(DB_TABLEICE, KEY_NAME+"= ?",new String[]{rowName})>0;
	}
	
	public boolean deleteDatakitchen(String rowName)
	{
		return mSQLiteDatabase.delete(DB_TABLEKITCHEN, KEY_NAME+"= ?",new String[]{rowName})>0;
	}
	
	public boolean deleteDataroom(String rowName)
	{
		return mSQLiteDatabase.delete(DB_TABLEROOM, KEY_NAME+"= ?",new String[]{rowName})>0;
	}
	
	/*查询所有*/
	public Cursor fetchAllData()
	{
		return mSQLiteDatabase.query(DB_TABLE, new String[]{KEY_ID,KEY_NAME,KEY_DATE,KEY_DAY,KEY_ALERTDAY,KEY_SEAT}, null, null, null, null, null);
	}
	
	public Cursor fetchAllDataice()
	{
		return mSQLiteDatabase.query(DB_TABLEICE, new String[]{KEY_ID,KEY_NAME,KEY_DATE,KEY_DAY,KEY_ALERTDAY,KEY_SEAT}, null, null, null, null, null);
	}
	
	public Cursor fetchAllDatakitchen()
	{
		return mSQLiteDatabase.query(DB_TABLEKITCHEN, new String[]{KEY_ID,KEY_NAME,KEY_DATE,KEY_DAY,KEY_ALERTDAY,KEY_SEAT}, null, null, null, null, null);
	}
	
	public Cursor fetchAllDataroom()
	{
		return mSQLiteDatabase.query(DB_TABLEROOM, new String[]{KEY_ID,KEY_NAME,KEY_DATE,KEY_DAY,KEY_ALERTDAY,KEY_SEAT}, null, null, null, null, null);
	}
	
	/*查询指定*/
	public Cursor CursorfetchData(String rowName)
	{
		Cursor mCursor = mSQLiteDatabase.query(DB_TABLE, new String[]{KEY_ID,KEY_NAME,KEY_DATE,KEY_DAY,KEY_ALERTDAY,KEY_SEAT}, KEY_NAME + "=?", new String[]{rowName}, null, null, null);
		if(mCursor!=null)
		{
			mCursor.moveToFirst();
			//return mCursor;
		}
		return mCursor;
	}
	//查询食用天数
	public Cursor searchData(int rowDay)
	{
		Cursor mCursor = mSQLiteDatabase.query(DB_TABLE, new String[]{KEY_ID,KEY_NAME,KEY_DATE,KEY_DAY,KEY_SEAT}, KEY_DAY+ "<" +rowDay, null, null, null, null);
		if(mCursor!=null)
		{
			mCursor.moveToFirst();
		}
		return mCursor;
	}
	//提醒查询
	public Cursor alertData()
	{
		Cursor mCursor = mSQLiteDatabase.query(DB_TABLE, new String[]{KEY_ID,KEY_NAME,KEY_DATE,KEY_DAY,KEY_ALERTDAY,KEY_SEAT}, KEY_DAY+ "<" +KEY_ALERTDAY, null, null, null, null);
		if(mCursor!=null)
		{
			mCursor.moveToFirst();
		}
		return mCursor;
	}

	//每天自动更新数据库
	public Cursor updataData()
	{
		Cursor mCursor = mSQLiteDatabase.query(DB_TABLE, new String[]{KEY_ID,KEY_NAME,KEY_DATE,KEY_DAY,KEY_SEAT}, null, null, null, null, null);
		if(mCursor!=null)
		{
			for(mCursor.moveToFirst();!mCursor.isAfterLast();mCursor.moveToNext())
			{
				//获取数据库当前的数据
				int column01 = mCursor.getColumnIndex(KEY_DAY);
				int colunm02 = mCursor.getColumnIndex(KEY_NAME);
		        int num = mCursor.getInt(column01);
				String rowName = mCursor.getString(colunm02);
				num--;
				//String day = Integer.toString(num);
				//创建对象 将day的值 更新入数据库
				ContentValues args = new ContentValues();
				args.put(KEY_DAY, num);
				mSQLiteDatabase.update(DB_TABLE, args, KEY_NAME + "=?", new String[]{rowName});
			}
		}
		return mCursor;
	}
	
	public Cursor updataDataice()
	{
		Cursor mCursor = mSQLiteDatabase.query(DB_TABLEICE, new String[]{KEY_ID,KEY_NAME,KEY_DATE,KEY_DAY,KEY_SEAT}, null, null, null, null, null);
		if(mCursor!=null)
		{
			for(mCursor.moveToFirst();!mCursor.isAfterLast();mCursor.moveToNext())
			{
				//获取数据库当前的数据
				int column01 = mCursor.getColumnIndex(KEY_DAY);
				int colunm02 = mCursor.getColumnIndex(KEY_NAME);
		        int num = mCursor.getInt(column01);
				String rowName = mCursor.getString(colunm02);
				num--;
				//String day = Integer.toString(num);
				//创建对象 将day的值 更新入数据库
				ContentValues args = new ContentValues();
				args.put(KEY_DAY, num);
				mSQLiteDatabase.update(DB_TABLEICE, args, KEY_NAME + "=?", new String[]{rowName});
			}
		}
		return mCursor;
	}
	
	public Cursor updataDatakitchen()
	{
		Cursor mCursor = mSQLiteDatabase.query(DB_TABLEKITCHEN, new String[]{KEY_ID,KEY_NAME,KEY_DATE,KEY_DAY,KEY_SEAT}, null, null, null, null, null);
		if(mCursor!=null)
		{
			for(mCursor.moveToFirst();!mCursor.isAfterLast();mCursor.moveToNext())
			{
				//获取数据库当前的数据
				int column01 = mCursor.getColumnIndex(KEY_DAY);
				int colunm02 = mCursor.getColumnIndex(KEY_NAME);
		        int num = mCursor.getInt(column01);
				String rowName = mCursor.getString(colunm02);
				num--;
				//String day = Integer.toString(num);
				//创建对象 将day的值 更新入数据库
				ContentValues args = new ContentValues();
				args.put(KEY_DAY, num);
				mSQLiteDatabase.update(DB_TABLEKITCHEN, args, KEY_NAME + "=?", new String[]{rowName});
			}
		}
		return mCursor;
	}
	
	public Cursor updataDataroom()
	{
		Cursor mCursor = mSQLiteDatabase.query(DB_TABLEROOM, new String[]{KEY_ID,KEY_NAME,KEY_DATE,KEY_DAY,KEY_SEAT}, null, null, null, null, null);
		if(mCursor!=null)
		{
			for(mCursor.moveToFirst();!mCursor.isAfterLast();mCursor.moveToNext())
			{
				//获取数据库当前的数据
				int column01 = mCursor.getColumnIndex(KEY_DAY);
				int colunm02 = mCursor.getColumnIndex(KEY_NAME);
		        int num = mCursor.getInt(column01);
				String rowName = mCursor.getString(colunm02);
				num--;
				//String day = Integer.toString(num);
				//创建对象 将day的值 更新入数据库
				ContentValues args = new ContentValues();
				args.put(KEY_DAY, num);
				mSQLiteDatabase.update(DB_TABLEROOM, args, KEY_NAME + "=?", new String[]{rowName});
			}
		}
		return mCursor;
	}

	
	/*修改一条数据*/
	public boolean modifyData(String rowName,String name,String date,int day,int alertday)
	{
		ContentValues args =new ContentValues();
		args.put(KEY_NAME, name);
		args.put(KEY_DATE, date);
		args.put(KEY_DAY, day);
		args.put(KEY_ALERTDAY, alertday);
		return mSQLiteDatabase.update(DB_TABLE, args, KEY_NAME+"=?", new String[]{rowName})>0;
	}
	
	public boolean modifyDataice(String rowName,String name,String date,int day,int alertday)
	{
		ContentValues args =new ContentValues();
		args.put(KEY_NAME, name);
		args.put(KEY_DATE, date);
		args.put(KEY_DAY, day);
		args.put(KEY_ALERTDAY, alertday);
		return mSQLiteDatabase.update(DB_TABLEICE, args, KEY_NAME+"=?", new String[]{rowName})>0;
	}
	
	public boolean modifyDatakitchen(String rowName,String name,String date,int day,int alertday)
	{
		ContentValues args =new ContentValues();
		args.put(KEY_NAME, name);
		args.put(KEY_DATE, date);
		args.put(KEY_DAY, day);
		args.put(KEY_ALERTDAY, alertday);
		return mSQLiteDatabase.update(DB_TABLEKITCHEN, args, KEY_NAME+"=?", new String[]{rowName})>0;
	}
	
	public boolean modifyDataroom(String rowName,String name,String date,int day,int alertday)
	{
		ContentValues args =new ContentValues();
		args.put(KEY_NAME, name);
		args.put(KEY_DATE, date);
		args.put(KEY_DAY, day);
		args.put(KEY_ALERTDAY, alertday);
		return mSQLiteDatabase.update(DB_TABLEROOM, args, KEY_NAME+"=?", new String[]{rowName})>0;
	}
	
}
