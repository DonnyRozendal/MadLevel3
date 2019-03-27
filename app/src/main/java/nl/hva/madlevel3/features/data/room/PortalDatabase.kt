package nl.hva.madlevel3.features.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import nl.hva.madlevel3.features.data.models.Portal

@Database(entities = [Portal::class], version = 1)
abstract class PortalDatabase : RoomDatabase() {

    abstract fun portalDao(): PortalDao

}