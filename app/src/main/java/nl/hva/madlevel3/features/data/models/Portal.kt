package nl.hva.madlevel3.features.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "portal")
data class Portal(
        @PrimaryKey(autoGenerate = true) val id: Int?,
        val title: String,
        val url: String
)