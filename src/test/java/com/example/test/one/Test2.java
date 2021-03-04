package com.example.test.one;

import org.junit.Test;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;

public class Test2 {
	@Test
	public void test1() {
		// 加载动态库
		System.load("/home/lace/Documents/workspace-spring-tool-suite-4-4.8.1.RELEASE/learn-opencv-java/src/main/resources/lib.opencv/kali/libopencv_java452.so");
		Mat mat_1 = new Mat(2, 2, CvType.CV_8UC3, new Scalar(0, 0, 255));

		int sz[] = { 2, 2, 2 };
		Mat mat_2 = new Mat(sz, CvType.CV_8UC1, Scalar.all(0));

		mat_1.create(4, 4, CvType.CV_8UC2);
		System.out.println(mat_1.dump());
	}
}
