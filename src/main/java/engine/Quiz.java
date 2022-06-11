package engine;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Quiz {
    String Starttime;
    String Endtime;
    String Date;
    String Timelimit;
    public String Quizname;
    public static ArrayList<Questions> question;
    public static ArrayList<Quiz> quizes;

    public static void initquestion() {
        if (question == null) {
            Quiz.question = new ArrayList<Questions>();
        }
    }

    public static void initquiz() {
        if (quizes == null) {
            Quiz.quizes = new ArrayList<Quiz>();
        }
    }

    public String add(Questions question) {
        this.question.add(question);
        return"Question was added";
    }

    public static String addquiz(Course course, String quizname, String Starttime, String Endtime, String Date, String Timelimit, ArrayList<Questions> question) {
        String regex = "([0-1][0-9]|[0-2][0-4]):[0-5][0-9]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(Starttime);
        if(matcher.matches()==false){
            return "Invalid Start Time";
        }
        String regex2 = "([0-1][0-9]|[0-2][0-4]):[0-5][0-9]";
        Pattern pattern2 = Pattern.compile(regex2);
        Matcher matcher2 = pattern2.matcher(Endtime);
        if(matcher2.matches()==false)
            return "Invalid End Time";
        String regex3 = "([0-2][0-9]|[3][0-1])/([1][0-2]|[0-9])/2022";
        Pattern pattern3 = Pattern.compile(regex3);
        Matcher matcher3 = pattern3.matcher(Date);
        if(matcher3.matches()==false)
            return "Invalid Date";
        course.quiz.add(new Quiz(quizname, Starttime, Endtime, Date, Timelimit, question));
        return "Quiz is Added";
    }

    public Quiz(String quizname, String Starttime, String Endtime, String Date, String Timelimit, ArrayList<Questions> question) {
        this.Starttime = Starttime;
        this.Endtime = Endtime;
        this.Date = Date;
        this.Timelimit = Timelimit;
        this.question = question;
        this.Quizname = quizname;
    }

    public int quizgrade(ArrayList<String> answer) {
        int totalmark = 0;
        for (int i = 0; i < this.question.size(); i++) {
            if (this.question.get(i).Correctanswer.equals(answer.get(i))) {
                totalmark++;
            }
        }
        return totalmark;
    }

    public static ArrayList<Questions> showquestions(Quiz quiz) {
        return quiz.question;
    }
    public Quiz showquiz(Course course, String quizname){
        for(int i=0;i<course.quiz.size();i++){
            if(course.quiz.get(i).Quizname.equals(quizname)){
                return course.quiz.get(i);
            }
        }
        return null;
    }
}

