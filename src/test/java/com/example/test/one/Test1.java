package com.example.test.one;

import java.net.URL;

import org.junit.Test;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
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
}
