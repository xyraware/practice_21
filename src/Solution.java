import java.util.*;

public class Solution {
    public Solution() {
    }

    public static HashMap<String, String> createMap() {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Геральт" + 0, "Ривийский");//
        map.put("Йенифер" + 1, "Венгерберг");//
        map.put("Эмгыр" + 2, "Венгерберг");//
        map.put("Геральт" + 3, "Ривийский");//
        map.put("Цирилла" + 4, "Рианнон");
        map.put("Трисс" + 5, "Меригольд");//
        map.put("Гюнтер" + 6, "о'Дим");
        map.put("Лето" + 7, "изГулеты");
        map.put("АдамЮлиан" + 8, "Альфред");
        map.put("Геральт" + 9, "Ривийский");//
        map.put("Цирилла" + 10, "Меригольд");//
        return map;
        //повтор имен: Геральт: 2 повторения, Цирилла: 1 повторение
        //повтор фамилий: Меригольд 1 повторение, Ривийский 2 повторения, Венгерберг: 1 повторение
    }

    public static String removeAllDigit(String str)//удаление ключей из хешмапа
    {
        char[] charArray = str.toCharArray();
        String result = "";
        for (int i = 0; i < charArray.length; i++) {
            if (!Character.isDigit(charArray[i])) {
                result = result + charArray[i];
            }
        }
        return result;
    }
    public static String[] remove_Duplicate_Elements(String[] arr) {
        Set<String> stringSet = new HashSet<>(Arrays.asList(arr));
        String[] filteredArray = stringSet.toArray(new String[0]);
        return filteredArray;
    }
    public static int getCountTheSameFirstName(HashMap<String, String> map) {
        String[] keys = new String[map.size()];
        String[] values = new String[map.size()];
        int index = 0;
        for (Map.Entry<String, String> mapEntry : map.entrySet()) {//конвертация хешмапа в массивы для подсчета
            keys[index] = mapEntry.getKey();
            values[index] = mapEntry.getValue();
            index++;
        }
        for (int i = 0; i < keys.length; i++) {
            keys[i] = removeAllDigit(keys[i]);
        }
        String[] dictaniory=keys;
        dictaniory=remove_Duplicate_Elements(dictaniory);
        int[] counting=new int[dictaniory.length];
        int count = 0;
        for (int i = 0; i < keys.length; i++) {
            for (int j = 0; j < dictaniory.length; j++) {
                if(dictaniory[j].equals(keys[i])){
                    counting[j]=counting[j]+1;
                }
            }
        }
        return summ(counting);
    }

    public static int getCountTheSameLastName(HashMap<String, String> map) {
        String[] keys = new String[map.size()];
        String[] values = new String[map.size()];
        int index = 0;
        for (Map.Entry<String, String> mapEntry : map.entrySet()) {
            keys[index] = mapEntry.getKey();
            values[index] = mapEntry.getValue();
            index++;
        }
        String[] dictaniory=remove_Duplicate_Elements(values);
        int[] counting=new int[dictaniory.length];
        int count = 0;
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < dictaniory.length; j++) {
                if(dictaniory[j].equals(values[i])){
                    counting[j]=counting[j]+1;
                }
            }
        }
        return summ(counting);
    }
    public static void outputMass(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
    public static int summ(int[] arr){
        int count=0;
        for(int i=0;i<arr.length;i++){
          count=count+arr[i];
        }
        return count-arr.length;
    }
}