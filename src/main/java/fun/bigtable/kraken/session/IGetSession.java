package fun.bigtable.kraken.session;

public interface IGetSession {

    String getUserName();

    Long getUserId();


    ISessionUser getUser();


}
