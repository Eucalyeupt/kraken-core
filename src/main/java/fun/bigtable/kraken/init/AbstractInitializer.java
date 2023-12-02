package fun.bigtable.kraken.init;

public abstract class AbstractInitializer {

    protected abstract void init();

    public String module(){
        return "模块";
    }

}
