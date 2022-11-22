package com.alexander.parco.lab08.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.alexander.parco.lab08.data.database.dao.PokemonDao
import com.alexander.parco.lab08.data.database.entities.MyPokemonEntity

@Database(entities = [MyPokemonEntity::class], version = 1)
abstract class PokemonDatabase: RoomDatabase() {
    abstract fun getPokemonDao(): PokemonDao
}