import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TransactionalTest {

    @Test
    public void testEntry() {

        Map<String,Object> map=new HashMap<String, Object>();

        map.put("zhangsan",123);
        map.put("zhaosi",456);
        for (Map.Entry<String,Object> entry:map.entrySet()){

            System.out.println(entry.getKey()+":"+entry.getValue());

        }


    }
    @Test
    public void TestObject(){
        int i=0;
        Object a=i;
        int b=(int)a;

        byte c=100;
        short j=c;


        float f=(float)10.25;


        System.out.println(f);





    }

@Test
    public void testString(){
        String s1="hello";
        if (s1=="hello"){
            System.out.println("s1 = hello");
        }else{
            System.out.println("s1 != hello");
        }


    }

@Test
    public void testthree(){

        boolean [] person=new boolean[3];
        for (int i=0;i<person.length;i++){

            person[i]=true;

        }

        int left=person.length;
        int count=0;
        int index=-1;
        while(left>1){
            index++;

            if(person[index]=true){
                count++;

            }
            if (count==2){
                person[index]=false;
                count=0;
                left--;

            }
            if (index == (person.length-1)){
                index=-1;
            }

        }
       for (int i=0;i<person.length;i++){
            if(person[i]==true){
                System.out.println(i+1);
            }

       }





    }


    public  void testResult(){



    }






}