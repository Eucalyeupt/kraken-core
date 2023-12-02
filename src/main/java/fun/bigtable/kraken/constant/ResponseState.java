package fun.bigtable.kraken.constant;

/**
 */
public enum ResponseState {

    SUCCESS("success"),

    FAIL("fail");

    private final String state;

    ResponseState(String state) {

        this.state = state;

    }

    public String getState() {

        return this.state;

    }
}
