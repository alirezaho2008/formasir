package formasir.app.adapter;

import android.view.ViewGroup;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import formasir.app.adapter.holder.UsersListHolder;
import formasir.app.models.retrofit.UserItem;


public class UsersListAdapter extends RecyclerView.Adapter {

    private final int VIEW_ITEM = 1;

    // The minimum amount of items to have below your current scroll position
// before loading more.
    private int visibleThreshold = 5;
    private int lastVisibleItem, totalItemCount;
    private boolean loading;

    private RecyclerView recyclerView;
    private List<UserItem> items;
    private UsersListHolder.OnItemClick onItemClick;

    private int selectedItemIndex;

    private boolean shouldLoadMore = false;


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {

            final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView
                    .getLayoutManager();

            recyclerView
                    .addOnScrollListener(new RecyclerView.OnScrollListener() {
                        @Override
                        public void onScrolled(@NotNull RecyclerView recyclerView,
                                               int dx, int dy) {
                            super.onScrolled(recyclerView, dx, dy);

                            totalItemCount = linearLayoutManager.getItemCount();
                            lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
                            if (!loading
                                    && totalItemCount <= (lastVisibleItem + visibleThreshold)) {
                                // End has been reached
                                // Do something

                                loading = true;
                            }
                        }
                    });
        }

        RecyclerView.ViewHolder vh;

        vh = UsersListHolder.getInstance(parent);

        return vh;
    }

    public void clearData() {
        if (items != null && items.size() > 0)
            items.clear();
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof UsersListHolder) {

            if (items.size() > holder.getAdapterPosition()) {
                ((UsersListHolder) holder).bindView(items.get(holder.getAdapterPosition()), (holder.getAdapterPosition() == selectedItemIndex));
                ((UsersListHolder) holder).setOnClickListener(onItemClick);
            }
        }

    }


    @Override
    public int getItemCount() {

        if (shouldLoadMore)
            return items.size() + 1;
        else {
            if (items != null)
                return items.size();
        }
        return 0;
    }


    @Override
    public int getItemViewType(int position) {
        int VIEW_PROG = 0;
        return items.get(position) != null ? VIEW_ITEM : VIEW_PROG;
    }

    public void setOnItemClick(UsersListHolder.OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

    public void clearItems() {
        if (items != null && items.size() > 0)
            items.clear();
    }

    public void setSelectedItem(int selectedItemIndex) {
        this.selectedItemIndex = selectedItemIndex;
    }

    public void setItem(List<UserItem> items) {
        this.items = items;
    }

    public void AddItem(ArrayList<UserItem> items) {
        this.items.addAll(items);
    }

    public void setRecyclerView(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }

    public void setType(int type) {
        int type1 = type;
    }

}