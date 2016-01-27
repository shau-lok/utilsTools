public abstract class RefreshBaseFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {

    public static final String UPDATE_ALL = "99999999";
    public static final int UPDATE_ALL_INT = 99999999;

    private SwipeRefreshLayout swipeRefreshLayout;

    protected final boolean isRefreshing() {
        return swipeRefreshLayout.isRefreshing();
    }

    protected final void setRefreshing(boolean refreshing) {
        swipeRefreshLayout.setRefreshing(refreshing);
    }

    protected final void initRefreshLayout() {
        swipeRefreshLayout = (SwipeRefreshLayout) getView().findViewById(R.id.swipeRefreshLayout);
        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.setColorSchemeResources(R.color.green);
    }

    protected final void disableRefreshing() {
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setEnabled(false);
        }
    }

    protected final void enableSwipeRefresh(boolean enable) {
        swipeRefreshLayout.setEnabled(enable);
    }
}