
import java.util.*;
class bfs{
    Map<Character,List<Character>> map = new HashMap<>();
    void add(char u)
    {
        map.putIfAbsent(u,new ArrayList<>());
    }
    void edges(char u,char v)
    {
        map.get(u).add(v);
        map.get(v).add(u);
    }
    void broad(char ch)
    {
        Queue<Character> q = new LinkedList<>();
        Set<Character> set = new HashSet<>();
        q.add(ch);
        set.add(ch);
        while(!q.isEmpty())
        {
            char c = q.poll();
            System.out.print(c+" ");
            for(char d : map.get(c))
            {
                if(!set.contains(d))
                {
                    q.offer(d);
                    set.add(d);
                }
            }
        }
    }
}
class network_bfs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        bfs b = new bfs();
        while(true)
        {
            String a = sc.nextLine();
            if(a.trim().isEmpty())
            {
                break;
            }
            b.add(a.charAt(0));
        }

        while(true)
        {
            String a = sc.nextLine();
            if(a.trim().isEmpty())
            {
                break;
            }
            char u = a.charAt(0);
            char v = a.charAt(2);
            b.edges(u,v);
        }
        char ch = sc.nextLine().charAt(0);
        b.broad(ch);
    }
}
