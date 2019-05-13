package nio;

import java.io.IOException;
import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NIOExample {
    public static void main(String[] args)  {
        Path path= Paths.get("catalog1/catalog2/file.txt");
        Path path1=Paths.get(URI.create("file:///catalog1/catalog2/file.txt"));
      ///path.normalize();//удаляет ...

        System.out.println(" всего количество чатей в адресе = " + path.getNameCount());
        System.out.println("path1 = " + path.getName(2));

       //Files.createFile(path);
       /// Files.createDirectories(path);
       // Files.copy();
      //  Files.move();
       // Files.delete();
       // Files.deleteIfExists();
       // Files.write();
       // Files.readAllBytes();
      //  Files.lines();
       // Files.readAllLines();

        ByteBuffer buffer=ByteBuffer.allocate(16);//заданный размер буфера
        assert  buffer.position()==0;///текущая позиция для буфера на 0
        assert  buffer.capacity()==16; //размер
        assert  buffer.limit()==16; //лимит
        assert  buffer.remaining()==16; //разница между позицией и лимитом
        ////buffer.hasRemaining();//если 0 то все добавлено

        buffer.putInt(100); //позиция увеличилась на 4
        assert buffer.position()==4;
        assert buffer.remaining()==12;

        buffer.putDouble(100.25);
        assert buffer.position()==12;
        assert buffer.remaining()==4;
        //---подготавливает позицию для чтения
        buffer.flip();

        assert  buffer.position()==0;
        assert  buffer.limit()==12;
        assert buffer.remaining()==12;


        int someInt = buffer.getInt();
        System.out.println("someInt = " + someInt);
        assert buffer.position()==4;
        assert buffer.remaining()==8;

        double someDouble = buffer.getDouble();
        System.out.println("someDouble = " + someDouble);
        assert buffer.position()==12;
        assert buffer.remaining()==0;

        //выставляет позицию в 0
        //подготавливает буфер для повтороного чтения
        buffer.rewind();
        assert  buffer.position()==0;
        assert  buffer.limit()==12;
        assert buffer.remaining()==12;

        someInt = buffer.getInt();
        someDouble = buffer.getDouble();

        //подготавливает буфер для новой записи
        // выставляет позицию на 0
        buffer.clear();


//        FileChannel; ///канал передачи файла туда и обратно
//        DatagramChannel;// по udp протоколу
//        SocketChannel;// по tсp протоколом
//        ServerSocketChannel; ///позволяет слушать входящие tcp соединения
///для каждого соединения будет создавать SocketChannel
//
//        fileOutputStream.getChannel();
//        fileInputStream.getChannel();
//        randomAccsessFile.getChannel();///IO и NIO пакеты связть
//


        ///-*----про Селектор
        ////пришло новое соединенние произодло подключение
        //Connect SelectionKey.OP_CONNECT;
       // Accept SelectionKey.OP_ACCEPT;
      //  Write SelectionKey.OP_WRITE;
        //Read SelectionKey.OP_READ;
//        key.isAcceptable()
//        key.isReadable()
//        key.isWritable()
     ///   key.isConnectable()


    }
}
