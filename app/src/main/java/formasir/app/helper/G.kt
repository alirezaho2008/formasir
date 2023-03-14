package formasir.app.helper

import android.annotation.SuppressLint
import android.content.Context
import androidx.multidex.MultiDexApplication
import formasir.app.component.DaggerToolsComponent
import formasir.app.component.ToolsComponent
import formasir.app.models.*
import formasir.app.models.retrofit.UserItem
import formasir.app.models.retrofit.UserModel
import formasir.app.module.ToolsModule
import java.util.*

/**
 * Created by Alireza on 13/03/2023.
 */
class G : MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()
        context = this

        tools = DaggerToolsComponent.builder().toolsModule(ToolsModule()).build()
    }

    companion object {
        @SuppressLint("StaticFieldLeak")
        var context: Context? = null
        var tools: ToolsComponent? = null


        var selectedUserModel: UserItem? = null
    }

}