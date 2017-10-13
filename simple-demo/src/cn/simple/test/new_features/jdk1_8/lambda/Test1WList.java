package cn.simple.test.new_features.jdk1_8.lambda;

import java.util.ArrayList;
import java.util.List;

public class Test1WList {

    public static void main(String[] args) throws InterruptedException {
	List<String> list = new ArrayList<>();
	for (int i = 0; i < 5000; i++) {
	    list.add("test" + i);
	}
	System.out.println(list.size());
	long start = System.currentTimeMillis();

	// List<Integer> lens = list.parallelStream().map(//
	// (str) -> str.length()//
	// ).collect(Collectors.toList());

	// List<Integer> lens = new CopyOnWriteArrayList<>();
	// list.parallelStream().map((str) -> str.length()).forEach(//
	// // (len) -> lens.add(len)//
	// lens::add//
	// );

	// List<Integer> lens = new ArrayList<>();
	// for (String str : list) {
	// lens.add(str.length());
	// }

	list.parallelStream().forEach((str) -> {
	    try {
		Thread.sleep(1L);
	    } catch (Exception e) {
		e.printStackTrace();
	    }
//	    System.out.println(str);
	});

	// System.out.println(lens.size());
	System.out.println("use: " + (System.currentTimeMillis() - start) + "ms");
    }

}
