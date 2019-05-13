package nio.chat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

public class Server {
    public static void main(String[] args) {
        Server server=new Server();
        server.start();

    }

    public void start()
    {
        ///запускаем поток для обработка всех соединений
        new Thread(new NioThread()).start();
    }
    ///-------------------------------------------------------------
    private  class NioThread extends Worker
    {
        private  static  final  int BUF_SIZE=1024;

        private ByteBuffer byteBuffer;
        private ServerSocketChannel serverSocketChannel;
        private Selector selector;

        @Override
        protected void init() throws IOException {
            //создаем буфер
            byteBuffer=ByteBuffer.allocate(BUF_SIZE);
            //--создаем селектор
            selector=Selector.open();

            //открываем канал сервера
            serverSocketChannel=ServerSocketChannel.open();

            ///слушакм опредленный порт
            serverSocketChannel.bind(new InetSocketAddress(12345));
            ///перевод в неблокирующий режим
            serverSocketChannel.configureBlocking(false);
            //регистрируем канал в селекторе на все допустимые события
            serverSocketChannel.register(selector,serverSocketChannel.validOps());

        }

        @Override
        protected void loop() throws IOException {
            ///ожидание новых событий
            selector.select();
            ///получаем ключи, на которые пришли события
            Set<SelectionKey> keys=selector.selectedKeys();
            Iterator<SelectionKey> iterator=keys.iterator();

            //обрабатываем ключи
            while (iterator.hasNext())
            {
                SelectionKey key=iterator.next();
                ///флаг isAcceptable означает, что пришло вхожящее подключение
                ///можно получать новый канал для этого соежинения
                if(key.isAcceptable())
                {//получение канала, клиентский Socket
                    SocketChannel channel=serverSocketChannel.accept();
                    ///переводим в неблокирующий режим
                    channel.configureBlocking(false);
                    ///регистрируем в селекторе на чтение
                    channel.register(selector,SelectionKey.OP_READ);
                    System.out.println("Client connected " + channel.getRemoteAddress());
                }
                //флаг означает, что пришли данные для чтения
                else if (key.isReadable())
                {//читаем входящие данные
                    System.out.println("читаем данные ..");
                    readData((SocketChannel) key.channel());


                }
                //isValid проверяет что соеднинени действительно открыто и isWritable что мы в канал  может писать данные
                else if (key.isValid()&& key.isWritable())
                {
                    ///записываем данные в канал
                    System.out.println("запись данных в канал..");
                    writeData((SocketChannel) key.channel(),key);
                }
                //удаляем обработанные ключ
                iterator.remove();
            }///конец цикла по while

        }



        @Override
        protected void stop() throws IOException {
            serverSocketChannel.close();
            selector.close();
        }


        //------------------------readData------------------------
        private void readData(SocketChannel channel)  {
            ///готовим буфер для чтения
            byteBuffer.clear();
            ///считываем данные

            int read = 0;
            try {
                read = channel.read(byteBuffer);
                if (read != -1) ///канал открыт
                    System.out.println(new String(byteBuffer.array(), 0, byteBuffer.position(), Charset.forName("UTF-8")));
                    //// byteBuffer.limit();///вернет лимит буфера
                else {//если канал закрыт
                    System.out.println("client disconnect" + channel.getRemoteAddress());
                    channel.close();
                }
                ////--готовим буфер к записи-------------
                byteBuffer.flip();
                Set<SelectionKey> keys=selector.keys();
                for (SelectionKey key:keys)
                { ///можем писать или нет
                    if ((key.channel().validOps() & SelectionKey.OP_WRITE)>0)
                    {
                        ///---устновили событие на запись  ... инициализируем события записи данных
                        key.interestOps(key.interestOps()|SelectionKey.OP_WRITE);

                    }
                }
            } catch (IOException e) {
                System.out.println("client disconnect");
                byteBuffer.clear();
                try {
                    channel.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }

        }

        ///----------------------writeData------------------------
        private void writeData(SocketChannel channel,SelectionKey key) throws IOException {
            //уже подготовили теперь записываетм данные из буффера в каналы


                channel.write(byteBuffer);
                byteBuffer.rewind();
                ////снимаем флаг на установку на запись
                key.interestOps(key.interestOps()&~SelectionKey.OP_WRITE);



        }


    }

}
