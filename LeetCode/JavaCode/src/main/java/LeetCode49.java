import java.util.*;

/**
 题目：字母异位词
 字母相同，每个字母的个数也相同，因此将单词排序后是相同的
 */
class LeetCode49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>(strs.length);
        for(String str : strs){
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            //getOrDefault() 方法获取指定 key 对应对 value，如果找不到 key ，则返回设置的默认值。
            //hashmap.getOrDefault(Object key, V defaultValue) defaultValue-默认值
            List<String> list = map.getOrDefault(key,new ArrayList<>());
            list.add(str);
            //如果插入的 key 对应的 value 已经存在，则执行 value 替换操作，返回旧的 value 值，如果不存在则执行插入，返回 null。
            map.put(key,list);
        }
        return new ArrayList<> (map.values());
    }
}