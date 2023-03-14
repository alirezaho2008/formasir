package formasir.app.room

import androidx.annotation.WorkerThread
import formasir.app.models.retrofit.UserItem
import kotlinx.coroutines.flow.Flow

/**
 * Abstracted Repository as promoted by the Architecture Guide.
 * https://developer.android.com/topic/libraries/architecture/guide.html
 */
class UserRepository(private val userDao: UserDao) {

    // Room executes all queries on a separate thread.
    // Observed Flow will notify the observer when the data has changed.
    val allUsers: Flow<List<UserItem>> = userDao.getAlphabetizedUsers()

    // By default Room runs suspend queries off the main thread, therefore, we don't need to
    // implement anything else to ensure we're not doing long running database work
    // off the main thread.
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(user: UserItem) {
        userDao.insert(user)
    }
}
