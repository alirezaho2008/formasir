package formasir.app.room

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import formasir.app.R
import formasir.app.models.retrofit.UserItem

class UserListAdapter : ListAdapter<UserItem, UserListAdapter.UserViewHolder>(USERS_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current.login)
    }

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val userItemView: TextView = itemView.findViewById(R.id.txt_user_name)

        fun bind(text: String?) {
            userItemView.text = text
        }

        companion object {
            fun create(parent: ViewGroup): UserViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.user_item, parent, false)
                return UserViewHolder(view)
            }
        }
    }

    companion object {
        private val USERS_COMPARATOR = object : DiffUtil.ItemCallback<UserItem>() {
            override fun areItemsTheSame(oldItem: UserItem, newItem: UserItem): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(oldItem: UserItem, newItem: UserItem): Boolean {
                return oldItem.login == newItem.login
            }
        }
    }
}
