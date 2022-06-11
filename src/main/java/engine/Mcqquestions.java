package engine;

public class Mcqquestions extends Questions{
    public String[] mcq = new String[4];
   public Mcqquestions(String Question,String Correctanswer,String mcq1,String mcq2,String mcq3,String mcq4){
       super(Question,Correctanswer);
       mcq[0] = mcq1;
       mcq[1] = mcq2;
       mcq[2] = mcq3;
       mcq[3] = mcq4;
   }
}
