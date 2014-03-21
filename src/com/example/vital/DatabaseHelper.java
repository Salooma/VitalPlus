package com.example.vital;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class DatabaseHelper extends SQLiteOpenHelper {
	
	// All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;
 
    // Database Name
    private static final String DATABASE_NAME = "vitalsManager";
 
    // Contacts table name
    private static final String TABLE_HR = "heartrate";
 
    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
	
    //Constructor
    public DatabaseHelper(Context context) {
		  super(context, DATABASE_NAME, null,DATABASE_VERSION); 
		  }
    
    
 // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_HR + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                 + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }
 
    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_HR);
 
        // Create tables again
        onCreate(db);
    }

    
    //All CRUD operations handled below
 
//    // Adding new contact
//    public void addContact(Contact contact) {}
//     
//    // Getting single contact
//    public Contact getContact(int id) {}
//     
//    // Getting All Contacts
//    public List<Contact> getAllContacts() {}
//     
//    // Getting contacts Count
//    public int getContactsCount() {}
//    // Updating single contact
//    public int updateContact(Contact contact) {}
//     
//    // Deleting single contact
//    public void deleteContact(Contact contact) {}
//    
//    // Adding new contact
//    public void addContact(Contact contact) {
//        SQLiteDatabase db = this.getWritableDatabase();
//     
//        ContentValues values = new ContentValues();
//        values.put(KEY_NAME, contact.getName()); // Contact Name
//        values.put(KEY_PH_NO, contact.getPhoneNumber()); // Contact Phone Number
//     
//        // Inserting Row
//        db.insert(TABLE_CONTACTS, null, values);
//        db.close(); // Closing database connection
//    }

	
	

}


