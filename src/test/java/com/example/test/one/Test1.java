package com.example.test.one;

import java.net.URL;

import org.junit.Test;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class Test1 {

	// 学习参考：https://blog.csdn.net/qianlixiaomage/article/details/108416400
	@Test
	public void test_open_cv() {
		// 解决awt报错问题
		System.setProperty("java.awt.headless", "false");
		System.out.println(System.getProperty("java.library.path"));
		// 加载动态库
		URL url = ClassLoader.getSystemResource("lib.opencv/x64/opencv_java3413.dll");
		System.load(url.getPath());
		// 读取图像
		Mat image = Imgcodecs.imread("D:\\workspaces\\officeworkspace\\learn-opencv\\src\\test\\resources\\Raspberry.jpg");
		if (image.empty()) {
			throw new RuntimeException("Image is empty!");
		}
		HighGui.imshow("Original Image", image);
		// 创建输出单通道图像
		Mat grayImage = new Mat(image.rows(), image.cols(), CvType.CV_8SC1);
		// 进行图像色彩空间转换
		Imgproc.cvtColor(image, grayImage, Imgproc.COLOR_RGB2GRAY);
		HighGui.imshow("Processed Image", grayImage);
		Imgcodecs.imwrite("D:\\workspaces\\officeworkspace\\learn-opencv\\src\\test\\resources\\hello.jpg", grayImage);
		HighGui.waitKey();
	}
	
	@Test
	public void test_hello() {
		// 加载动态库
		URL url = ClassLoader.getSystemResource("lib.opencv/x64/opencv_java3413.dll");
		System.load(url.getPath());
		Mat mat = Mat.eye(3, 3, CvType.CV_8UC1);
		System.out.println("mat = " + mat.dump());
	}
	
	@Test
	public void test_doc_1() {
		// 加载动态库
		URL url = ClassLoader.getSystemResource("lib.opencv/x64/opencv_java3413.dll");
		System.load(url.getPath());
		Mat mat_1 = new Mat(2, 2, CvType.CV_8UC3, new Scalar(0, 0, 255));
		
		int sz[] = {2,2,2};
		Mat mat_2 = new Mat(sz, CvType.CV_8UC1, Scalar.all(0));
		
		mat_1.create(4, 4, CvType.CV_8UC2);
		System.out.println(mat_1.dump());
	}
}
