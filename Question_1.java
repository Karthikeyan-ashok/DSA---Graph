import java.util.*;
class edge
{
    char s;
    char e;
    int w;
    edge(char s, char e, int w)
    {
        this.s = s;
        this.e = e;
        this.w = w;
    }
}
class network {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Character,List<edge>> map = new HashMap<>();
        while(true)
        {
            String a = sc.nextLine();
            if(a.trim().isEmpty())
            {
                break;
            }
            map.put(a.charAt(0),new ArrayList<>());
        }
        while(true)
        {
            String s = sc.nextLine();
            if(s.trim().isEmpty())
            {
                break;
            }
            char a = s.charAt(0);
            char b = s.charAt(2);
            int c = Integer.parseInt(s.substring(4).trim());
            map.get(a).add(new edge(a,b,c));
            map.get(b).add(new edge(b,a,c));
        }
        PriorityQueue<edge> q = new PriorityQueue<>((a,b)->a.w - b.w);
        Set<Character> set = new HashSet<>();
        List<edge> list = new ArrayList<>();
        char ch = map.keySet().iterator().next();
        set.add(ch);
        q.addAll(map.get(ch));
        int min = 0;
        while(!q.isEmpty())
        {
            edge a = q.poll();
            char c = a.e;
            if(set.contains(c))
            {
                continue;
            }
            set.add(c);
            list.add(a);
            min += a.w;

            for(edge e : map.get(c))
            {
                if(!set.contains(e.e))
                {
                    q.offer(e);
                }
            }
        }
        for(edge e : list)
        {
            System.out.println(e.s +" --> " + e.e + " == " + e.w);
        }
        System.out.println(min);
    }
}
