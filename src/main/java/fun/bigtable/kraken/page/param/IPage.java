package fun.bigtable.kraken.page.param;

public interface IPage {

    boolean isCountOnly();

    void setCountOnly(boolean countOnly);

    boolean isNeedCount();
    void setNeedCount(boolean needCount);

    int getPageNum();

    void setPageNum(int pageNum);

    int getPageSize();

    void setPageSize(int pageSize);

}
