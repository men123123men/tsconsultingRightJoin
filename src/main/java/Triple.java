public class Triple<K,V1,V2> {
    final K k;
    final V1 v1;
    final V2 v2;

    private Triple(K k, V1 v1, V2 v2) {
        this.k = k;
        this.v1 = v1;
        this.v2 = v2;
    }
    public static<K,V1,V2> Triple<K,V1,V2> createInstance(K k, V1 v1, V2 v2){
        return new Triple( k, v1, v2);
    }

    @Override
    public String toString() {
        return String.format("%s \t %s \t %s",k,v1==null?"":v1,v2);
    }
}
