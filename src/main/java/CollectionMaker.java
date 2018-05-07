import java.util.*;

public class CollectionMaker {
    public static <T> ArrayList<T> makeArrayList(Iterable<T> inputIterrable){
        ArrayList<T> result = new ArrayList<>();
        for (T currentElement:inputIterrable)
            result.add(currentElement);
        return result;
    }

    public static LinkedList<Pair<Integer,String>> makeLinkedList(ArrayList<Pair<Integer,String>> inputArrayList){
        LinkedList<Pair<Integer,String>> result = new LinkedList<>(inputArrayList);
//        Collections.sort(result,new Comparator<Pair<Integer,String>>() {
//            @Override
//            public int compare(Pair<Integer,String> o1, Pair<Integer,String> o2) {
//                return Integer.compare(o1.k,o2.k);
//            }
//        });
        Collections.sort(result);
        return result;
    }

    public static HashMap<Integer,List<String>> makeMap(LinkedList<Pair<Integer,String>> inputLinkedList){
        HashMap<Integer,List<String>> result = new HashMap<>();
        List<String> currentStringList;
        for(Pair<Integer,String> currentPair: inputLinkedList) {
            currentStringList = result.get(currentPair.k);
            if(currentStringList!=null)
                currentStringList.add(currentPair.v);
            else
                result.put(currentPair.k,new ArrayList<>(Arrays.asList(currentPair.v)));
        }
        return result;
    }
}
