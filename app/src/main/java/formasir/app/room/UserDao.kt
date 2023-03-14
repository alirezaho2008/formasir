package formasir.app.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import formasir.app.models.retrofit.UserItem
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    // The flow always holds/caches latest version of data. Notifies its observers when the
    // data has changed.
    @Query("SELECT * FROM user_table ORDER BY login ASC")
    fun getAlphabetizedUsers(): Flow<List<UserItem>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(userItem: UserItem)

    @Query("DELETE FROM user_table")
    suspend fun deleteAll()
}
