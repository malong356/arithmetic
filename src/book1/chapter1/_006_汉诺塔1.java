package book1.chapter1;

/**
 * 汉诺塔
 * Created by malong on 2019-12-28.
 */
public class _006_汉诺塔1 {

    public static final String LEFT = "左";
    public static final String MID = "中";
    public static final String RIGHT = "右";

    public static int hanoiProblem1(int num){
        if(num < 1){
            return 0;
        }
        return process(num, LEFT, RIGHT);
    }

    public static int process(int num, String from , String to){
        if(num == 1){
            if(from.equals(MID) || to.equals(MID)){
                System.out.println("Move 1 from " + from + " to " + to);
                return 1;
            }else {
                System.out.println("Move 1 from " + from + " to " + MID);
                System.out.println("Move 1 from " + MID + " to " + to);
                return 2;
            }
        }
        if(from.equals(MID) || to.equals(MID)){
            /*
            如果剩下N层塔都在"左"，希望全部移动到"中"
            1.将1~N-1层塔先全部从"左"移动到"右"
            2.将第N层从"左"移动到"中"
            3.再将N-1层塔全部从"右"移动到"中"
             */
            String another = (from.equals(LEFT) || to.equals(LEFT)) ? RIGHT : LEFT;
            int part1 = process(num - 1, from, another);
            int part2 = 1;
            System.out.println("Move " + num + " from " + from + " to " + MID);
            int part3 = process(num - 1, another , to);
            return part1 + part2 + part3;
        }else {
            /*
            如果剩下N层塔都在"左"，希望全部移动到"有"
            1.将1~N-1层塔先全部从"左"移动到"右"
            2.将第N层从"左"移动到"中"
            3.再将N-1层塔全部从"右"移动到"左"
            4.将第N层从"中"移动到"右"
            5.将1~N-1层塔先全部从"左"移动到"右"
            */
            int part1 = process(num - 1, from, to);
            int part2 = 1;
            System.out.println("Move " + num + " from " + from + " to " + MID);
            int part3 = process(num -1 , to, from);
            int part4 = 1;
            System.out.println("Move " + num + " from " + MID + " to " + to);
            int part5 = process(num - 1, from, to);
            return part1 + part2 + part3 + part4 + part5;
        }
    }

    public static void main(String[] args) {
        int i = hanoiProblem1(5);
        System.out.println(String.format("共移动了%d步", i));
    }
}
