package cn.simple.test.new_features.jdk18.interface_def;

public class User extends AbstractUser implements IUser, IPrint {

    @Override
    public void setName( String name ) {
    }

    // ������ͬ�Ľӿ�Ĭ�Ϸ���
    @Override
    public void print() {
	IPrint.super.print();
	IUser.super.print();
    }

}
