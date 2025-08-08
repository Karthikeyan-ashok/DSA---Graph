import java.util.*;
class Node
{
    char s;
    char e;
    int w;
    Node(char s,char e,int w)
    {
        this.s = s;
        this.e = e;
        this.w = w;
    }
}
class railway {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Character,List<Node>> map = new HashMap<>();
        while(true)
        {
            String a = sc.nextLine();
            if(a.trim().isEmpty())
            {
                break;
            }
            char c[] = a.toCharArray();
            map.put(c[0],new ArrayList<>());
        }
        while(true)
        {
            String a = sc.nextLine();
            if(a.trim().isEmpty())
            {
                break;
            }
            char s = a.charAt(0);
            char e = a.charAt(2);
            char w = a.charAt(4);
            map.get(s).add(new Node(s,e,w-'0'));
        }
        char source = 'A';

        boolean[] visited = new boolean[map.size()];
        int key[] = new int[map.size()];
        Arrays.fill(key,Integer.MAX_VALUE);

        PriorityQueue<Node> q = new PriorityQueue<>(Comparator.comparing(a->a.w));

        List<Node> list = new ArrayList<>();
        q.offer(new Node('1',source,0));
        key[source-65] = 0;

        while(!q.isEmpty())
        {
            Node t = q.poll();
            char start = t.e;
            if(visited[start-65])
            {
                continue;
            }
            if(!String.valueOf(t.s).equals("1"))
            {
                list.add(t);
            }
            visited[start-65] = true;
            for(Node a : map.get(start))
            {
                char end = a.e;
                int weight = a.w;
                if(!visited[end-65] && key[end-65]>weight)
                {
                    key[end-65] = weight;
                    q.add(new Node(start,end,weight));
                }
            }
        }
        int min = 0;
        for(Node i : list)
        {
            min += i.w;
        }
        for(Node k : list)
        {
            System.out.println(k.s +" --> "+k.e+" == "+k.w);
        }
        System.out.println("Minimum distance : "+min);
    }
}