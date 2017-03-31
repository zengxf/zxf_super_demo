package cn.zxf.spring.small.function.conditional.demo;

public class LinuxListService implements ListService{

	@Override
	public String showListCmd() {
		return "ls";
	}

}
