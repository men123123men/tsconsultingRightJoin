import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        PairParser parser = new PairParser();

        BufferedReader bufferedReaderTable1 = BufferedReaderMaker.fromFilePathString("table1.txt");
        BufferedReader bufferedReaderTable2 = BufferedReaderMaker.fromFilePathString("table2.txt");

        PairIterable pairIterable1 = new PairIterable(bufferedReaderTable1,parser);
        PairIterable pairIterable2 = new PairIterable(bufferedReaderTable2,parser);

        ArrayList<Pair<Integer,String>> arrayList1 = CollectionMaker.makeArrayList(pairIterable1);
        ArrayList<Pair<Integer,String>> arrayList2 = CollectionMaker.makeArrayList(pairIterable2);

        LinkedList<Pair<Integer,String>> linkedList1 = CollectionMaker.makeLinkedList(arrayList1);
        LinkedList<Pair<Integer,String>> linkedList2 = CollectionMaker.makeLinkedList(arrayList2);

        HashMap<Integer,List<String>> hashMap1 = CollectionMaker.makeMap(linkedList1);
        HashMap<Integer,List<String>> hashMap2 = CollectionMaker.makeMap(linkedList2);



        List<Triple<Integer,String,String>> result1 = InnerJoiner.nestedLoopsJoin(arrayList1,arrayList2);
        List<Triple<Integer,String,String>> result2 = InnerJoiner.mergeJoin(linkedList1,linkedList2);
        List<Triple<Integer,String,String>> result3 = InnerJoiner.mapJoin(hashMap1,hashMap2);


        printList(result1);
        printList(result2);
        printList(result3);


    }

    public static <T> void printList(List<T> inputList){
        for(T currentElement:inputList)
            System.out.println(currentElement);
        System.out.println();
    }

}
