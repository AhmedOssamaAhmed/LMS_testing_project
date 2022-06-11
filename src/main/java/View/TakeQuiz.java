package View;

import View.Components.Page;
import engine.Mcqquestions;
import engine.Questions;
import engine.Quiz;
import engine.WrittenQuestion;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TakeQuiz extends JPanel {
    ArrayList<ButtonGroup> x = new ArrayList<>();
    ArrayList<JTextField> y = new ArrayList<>();
    ArrayList<Boolean> order = new ArrayList<>();

    public TakeQuiz(Quiz quiz){
       JPanel content = new JPanel();
       BoxLayout contentLayout = new BoxLayout(content, BoxLayout.Y_AXIS);
       content.setLayout(contentLayout);
       for(int i = 0; i < quiz.question.size(); i++) {
           Questions q = quiz.question.get(i);
           order.add(q instanceof  Mcqquestions);
           if (q instanceof Mcqquestions) {
               Mcqquestions mcq = (Mcqquestions)q;
               content.add(new JLabel(mcq.Question));
               ButtonGroup bg = new ButtonGroup();
               for(int j = 0; j < 4; j++){
                   JRadioButton btn = new JRadioButton(mcq.mcq[j]);
                   btn.setActionCommand(mcq.mcq[j]);
                   bg.add(btn);
                   content.add(btn);
               }
               x.add(bg);
           }else{
               WrittenQuestion wq = (WrittenQuestion)q;
               JLabel prompt = new JLabel(wq.Question);
               JTextField answer = new JTextField();
               answer.setColumns(30);
               JPanel option = new JPanel();
               option.add(prompt);
               option.add(answer);
               content.add(option);
               y.add(answer);
           }
           content.add(Box.createRigidArea(new Dimension(0,20)));
       }
       JButton correct = new JButton("Submit Quiz");
       correct.addActionListener(e ->{
           ArrayList<String> answers = new ArrayList<>();
           int j = 0;
           int k = 0;
           for(int i = 0; i < order.size(); i++){
               if(order.get(i)){
                   answers.add(x.get(j++).getSelection().getActionCommand());
               }else{
                   answers.add(y.get(k++).getText());
               }
           }
           int grade = quiz.quizgrade(answers);
           JOptionPane.showMessageDialog(null, "Your grade is " + grade);
       });
       content.add(correct);
       new Page(quiz.Quizname, this, content, true);
    }
}