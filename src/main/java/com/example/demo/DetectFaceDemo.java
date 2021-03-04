package com.example.demo;

import java.net.URL;

import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

import ch.qos.logback.classic.pattern.ThreadConverter;

/**
 * Detects faces in an image, draws boxes around them, and writes the results
 * to "faceDetection.png
 * @author qinbiao
 *
 */
public class DetectFaceDemo {
	public void run() {
		System.out.println("Running DetectFaceDemo");
		// Create a face detector from the cascade file in the resources directory.
		CascadeClassifier faceDetector = new CascadeClassifier("D:\\workspaces\\officeworkspace\\learn-opencv\\src\\main\\resources\\lbpcascade_frontalface.xml");
		Mat image = Imgcodecs.imread("D:\\workspaces\\officeworkspace\\learn-opencv\\src\\main\\resources\\lena.png");
		// Detect faces in the image.
		// MatOfRect is a special container class for Rect.
		MatOfRect faceDetections = new MatOfRect();
		faceDetector.detectMultiScale(image, faceDetections);
		System.out.println(String.format("Detected %s faces", faceDetections.toArray().length));
		// Draw a bounding box around each face.
		for (Rect rect : faceDetections.toArray()) {
			Imgproc.rectangle(image, new Point(rect.x, rect.y), new Point(rect.x+rect.width, rect.y+rect.height), new Scalar(0, 255, 0));
		}
		// Save the visualized detection.
		String filename = "D:\\workspaces\\officeworkspace\\learn-opencv\\src\\main\\resources\\faceDetection.png";
		System.out.println(String.format("Writing %s", filename));
		Imgcodecs.imwrite(filename, image);
	}
	
	public static void main(String[] args) {
		System.out.println("Hello, OpenCV");
		// Load the native library.
		URL url = ClassLoader.getSystemResource("lib.opencv/x64/opencv_java3413.dll");
		System.load(url.getPath());
		new DetectFaceDemo().run();
	}
}

