package fun.bigtable.kraken.session;

public abstract class AbstractGetSession implements IGetSession{
    @Override
    public String getUserName() {
        return getUser().getUserName();
    }

    @Override
    public Long getUserId() {
        return getUser().getUserId();
    }
}
