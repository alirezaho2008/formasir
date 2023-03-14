package formasir.app.adapter.holder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import formasir.app.R;
import formasir.app.helper.G;
import formasir.app.models.retrofit.UserItem;


public class UsersListHolder extends RecyclerView.ViewHolder {

    private final TextView line_name;
    private final View card;
    private final ImageView iv_user;
    private OnItemClick onItemClick;

    UsersListHolder(View itemView) {
        super(itemView);
        line_name = itemView.findViewById(R.id.txt_user_name);
        card = itemView.findViewById(R.id.card);
        iv_user = itemView.findViewById(R.id.iv_user);
    }

    public static UsersListHolder getInstance(ViewGroup viewGroup) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.user_item, viewGroup, false);
        return new UsersListHolder(view);
    }

    public void bindView(UserItem user, Boolean isSelected) {

        line_name.setText(user.getLogin());

        Glide.with(G.Companion.getContext()).load(user.getAvatar_url()).centerCrop().into(iv_user);

        card.setOnClickListener(v -> onItemClick.onClick(user));
    }

    public void setOnClickListener(OnItemClick onClick) {
        this.onItemClick = onClick;
    }


    public interface OnItemClick {
        void onClick(UserItem line);
    }
}
