package homework5.List2;

import java.util.Iterator;

public class RecodrNote extends List2 implements ListList,QueueQueue,StrackStrack
{
    private Record start;

    public RecodrNote()
    {
        this.start = null;
    }

    ///-------------------перезаписали методы
    @Override
    public void listlist()
    {
        ///аналогично любому методу
    }

    ///-------------------перезаписали методы
    @Override
    public void strackstrack(int value,Object object)
    {
        Record newrec=new Record(value,object);
        this.add(newrec.value,newrec.object);
    }



    ////----------------получитьразмер--------------
   public int razmer()
    {
        Record start=this.getStart();
        int index=-1;
        int cnt = 0;
        Record node =start;

        while (node != null) {
            if (cnt++ == index)
                return cnt;

            if (index < 0 && node.next == null)
                return cnt;
            node = node.next;
        }
          return 0;
    }




    @Override
    public void queuqeue(int value,Object object)
    {
      ///---добавляем в конец очереди
        Record start=this.getStart();
        int raz=this.razmer();

        Record newrec=new Record(value,object);
        newrec.setNext(start);
        Record node=start;
        this.start=newrec;
        this.add(newrec.value,newrec.object);
        this.add(start.value,start.object);
        for (int i=0;i<raz-1;i++)
        {
            node = node.next;
            this.add(node.value, node.object);
            this.remove(1);//всегда удаляем первый

        }
        this.remove(0);////удаляем самый первый

        }
}




///
