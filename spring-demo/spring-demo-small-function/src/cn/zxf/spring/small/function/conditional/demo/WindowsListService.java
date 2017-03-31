package cn.zxf.spring.small.function.conditional.demo;

public class WindowsListService implements ListService {

    @Override
    public String showListCmd() {
	return "dir";
    }

}
