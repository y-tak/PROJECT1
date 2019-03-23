package homework4;

public class Node {

    private int index;
    private Node nextNode;

    public Node()
    {
    }

    public Node(int index)
    {
        if (index == 0)
        {
            this.index = index;
            this.nextNode = null;
        }
        else {
            this.index = index;
            this.nextNode = new Node(index - 1);
        }
    }


    public void addNode(int index,Node node)
    {
        node.index=index;
        node.nextNode=  new Node(index-1);
    }

    public void removeNode(int index,Node node)
    {
        node.index=index-1;
        node.nextNode=  new Node(index-2);
    }


    @Override
    public String toString() {
        return "  {" +index +" --> "+ nextNode+"}";
    }


}
