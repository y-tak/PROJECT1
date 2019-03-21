package homework5.List2;

import java.util.Iterator;

public class RecodrNote extends List2 implements ListList,QueueQueue,StrackStrack {
    private Record start;



    ///-------------------перезаписали методы
    @Override
    public void listlist()
    {



    }

    ///-------------------перезаписали методы
    @Override
    public void strackstrack()
    {

    }

    ////------------------------------------

    private Record find(int idx) {
        if (idx == 0)
            return start;

        int cnt = 0;

        Record node = start;

        while (node != null) {
            if (cnt++ == idx)
                return node;

            if (idx < 0 && node.next == null)
                return node;

           node = node.next;

        }


        return null;
    }

    ////----------------получитьразмер--------------
    private int razmer(int index)
    {

        if (index == 0)
            return 1;

        int cnt = 0;

        Record node = start;

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
    public void queuqeue()
    {


    }
}
///
