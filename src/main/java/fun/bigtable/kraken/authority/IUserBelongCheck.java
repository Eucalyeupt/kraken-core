package fun.bigtable.kraken.authority;

import fun.bigtable.kraken.exception.BusinessAssert;

/**
 * 权限检查接口类
 * @see BusinessAssert#userDataCheck(Long, IUserBelongCheck)
 */
public interface IUserBelongCheck {

    /**
     * 归属
     */
    Long getBelonging();
}
