package cn.zxf.jpa_transaction.test.position;

public interface IPositionService {

    Position createTransactionalRequired( String name, String sign );

}
