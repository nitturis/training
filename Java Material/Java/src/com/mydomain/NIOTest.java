package com.mydomain;

import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;

public class NIOTest {
	public static void main(String[] args) throws Exception{
//		RandomAccessFile aFile = new RandomAccessFile("src/com/mydomain/NIOTest.java", "rw");
//		FileChannel inChannel = aFile.getChannel();
//
//		//create buffer with capacity of 48 bytes
//		ByteBuffer buf = ByteBuffer.allocate(48);
//
//		int bytesRead = inChannel.read(buf); //read into buffer.
//		while (bytesRead != -1) {
//
//		  buf.flip();  //make buffer ready for read
//
//		  while(buf.hasRemaining()){
//		      System.out.print((char) buf.get()); // read 1 byte at a time
//		  }
//
//		  buf.clear(); //make buffer ready for writing
//		  bytesRead = inChannel.read(buf);
//		}
//		aFile.close();
		
		RandomAccessFile aFile = new RandomAccessFile("src/com/mydomain/NIOTest.java", "rw");
		FileChannel inChannel = aFile.getChannel();
		Selector selector = Selector.open();
		//inChannel.configureBlocking(false);

		//SelectionKey key = inChannel.register(selector, SelectionKey.OP_READ);
	}
}
