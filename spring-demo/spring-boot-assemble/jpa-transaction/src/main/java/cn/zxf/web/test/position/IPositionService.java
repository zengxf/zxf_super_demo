package cn.zxf.web.test.position;

public interface IPositionService {

    Position createTransactionalRequired( String name, String sign );

}
