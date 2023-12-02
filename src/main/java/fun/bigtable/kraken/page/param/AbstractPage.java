package fun.bigtable.kraken.page.param;


/**
 */
    public abstract class AbstractPage implements IPage {


    public static final int DEFAULT_PAGESIZE = 10;

    // 当前页(默认从第1页开始)
    private int pageNum = 1;
    // 每页显示的条数
    private int pageSize = DEFAULT_PAGESIZE;
    // 是否需要分页
    private boolean needCount = false;
    // 只查询总条数
    private boolean countOnly;

    public boolean isCountOnly() {
        return countOnly;
    }

    public void setCountOnly(boolean countOnly) {
        this.countOnly = countOnly;
    }

    public boolean isNeedCount() {
        return needCount;
    }

    public void setNeedCount(boolean needCount) {
        this.needCount = needCount;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

}
