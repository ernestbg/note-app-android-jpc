package com.example.noteapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import java.time.Instant
import java.util.Date
import java.util.UUID

class DateConverter {
    @TypeConverter
    fun toDate(dateLong: Long?): Date? {
        return if (dateLong == null) null else Date(dateLong)
    }
    @TypeConverter
    fun fromDate(date: Date?): Long? {
        return date?.time
    }
}

@Entity(tableName = "notes_table")
data class Note(

    @PrimaryKey
    val id: UUID = UUID.randomUUID(),

    @ColumnInfo(name = "note_title")
    val title: String,

    @ColumnInfo(name = "note_description")
    val description: String,

    @field:TypeConverters(DateConverter::class)
    @ColumnInfo(name = "note_entry_date")
    val entryDate: Date = Date.from(Instant.now())
)