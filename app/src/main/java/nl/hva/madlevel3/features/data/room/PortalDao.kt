package nl.hva.madlevel3.features.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import nl.hva.madlevel3.features.data.models.Portal

@Dao
interface PortalDao {

    @Insert
    fun insert(portal: Portal)

    @Query("SELECT * FROM portal")
    fun getAll(): Array<Portal>?

}