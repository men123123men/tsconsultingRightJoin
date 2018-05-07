import java.util.*;

public class InnerJoiner {

    public static  <K, V1, V2> List<Triple<K, V1, V2>> nestedLoopsJoin(ArrayList<Pair<K, V1>> left, ArrayList<Pair<K, V2>> right) {
        List<Triple<K, V1, V2>> result = new ArrayList<>();
        boolean conjunction = false;
        for (Pair<K, V2> rightPair: right) {
            conjunction = false;
            for (Pair<K, V1> leftPair : left) {
                if (Objects.equals(rightPair.k, leftPair.k)) {
                    result.add(Triple.createInstance(rightPair.k, leftPair.v, rightPair.v));
                    conjunction = true;
                }
            }
            if(!conjunction)
                result.add(Triple.<K, V1, V2>createInstance(rightPair.k, null, rightPair.v));
        }
        return result;
    }

    public static  <K, V1, V2> List<Triple<K, V1, V2>> mapJoin(HashMap<K, List<V1>> left, HashMap<K, List<V2>> right) {
        List<Triple<K, V1, V2>> result = new ArrayList<>();

        List<V2> partOfRightTable;
        List<V1> partOfLeftTable;

        for (Map.Entry<K, List<V2>> entyFromRight: right.entrySet()) {
            K currentKey = entyFromRight.getKey();
            partOfRightTable = entyFromRight.getValue();
            partOfLeftTable = left.get(currentKey);

            if(partOfLeftTable!=null)
                for(V1 currentLeftElement:partOfLeftTable)
                    for(V2 currentRightElement: partOfRightTable)
                        result.add(Triple.createInstance(currentKey, currentLeftElement, currentRightElement));
            else
                for(V2 currentRightElement: partOfRightTable)
                    result.add(Triple.<K, V1, V2>createInstance(currentKey, null, currentRightElement));
        }
        return result;
    }

    public static <K extends Comparable<K>, V1, V2> List<Triple<K, V1, V2>> mergeJoin(
            LinkedList<Pair<K, V1>> left,
            LinkedList<Pair<K, V2>> right
    ) {

        List<Triple<K, V1, V2>> result = new ArrayList<>();
        ListIterator<Pair<K, V1>> leftIter = left.listIterator();
        Iterator<Pair<K, V2>> rightIter = right.iterator();


        Pair<K, V1> leftPair = leftIter.next();
        Pair<K, V2> rightPair = rightIter.next();

        while (true)  {
            int compare = leftPair.k.compareTo(rightPair.k);
            if (compare < 0) {
                if (leftIter.hasNext()) {
                    leftPair = leftIter.next();
                } else {
                    break;
                }
            } else if (compare > 0) {
                result.add( Triple.<K, V1, V2>createInstance(rightPair.k, null, rightPair.v));
                if (rightIter.hasNext()) {
                    rightPair = rightIter.next();
                } else {
                    break;
                }
            } else {
                result.add(Triple.createInstance(leftPair.k, leftPair.v, rightPair.v));

                while (leftIter.hasNext()&&(leftPair=leftIter.next()).compareTo(rightPair)==0){
                    result.add(Triple.createInstance(leftPair.k, leftPair.v, rightPair.v));
                }
                leftPair=leftIter.previous();
                while (leftIter.hasPrevious()&&(leftPair=leftIter.previous()).compareTo(rightPair)==0){ }

                if(rightIter.hasNext())
                    rightPair = rightIter.next();

                 else {
                    break;
                }
            }
        }
        return result;

    }
}
