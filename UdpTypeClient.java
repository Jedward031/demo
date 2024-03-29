package com.jed.udp;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * 基本类型
 * 发送端
 * 1、使用DatagramSocket 指定端口 创建发送端
 * 2、准备数据 将基本类型 转成字节数组
 * 3、封装成DatagramPacket包裹(打包)，需要指定目的地
 * 4、发送包裹send(DatagramPacket p)
 * 5、释放资源
 * @author XPS
 *
 */
public class UdpTypeClient {

	public static void main(String[] args) throws Exception {
		System.out.println("发送方启动中。。。。");
		//1、使用DatagramSocket 指定端口 创建发送端
		DatagramSocket client = new DatagramSocket(8888);
		
		//2、准备数据 一定转成字节数组
		//写出
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(baos));
		//操作数据类型 + 数据
		dos.writeUTF("棉麻速插度");
		dos.writeInt(18);
		dos.writeBoolean(false);
		dos.writeChar('a');
		dos.flush();
		byte[] datas = baos.toByteArray();
		
		
		
		
		
		
		//3、封装成DatagramPacket 包裹，需要指定目的地
		DatagramPacket packet = new DatagramPacket(datas,0,datas.length,new InetSocketAddress("localHost",8889));
		//4、发送包裹send(DatagramPacket p)*
		client.send(packet);
		//5、释放资源
		client.close();
	}
}
