package View;

import View.Components.Page;
import engine.*;

import javax.swing.*;
import java.awt.*;

public class CreateQuizQuestions extends JPanel {
    JPanel input;
    JPanel content;
    Quiz quiz;
    public CreateQuizQuestions(Quiz quiz){
        this.quiz = quiz;
        content = new JPanel();
        input = new JPanel();
        BoxLayout inputLayout = new BoxLayout(input, BoxLayout.Y_AXIS);
        input.setLayout(inputLayout);
        renderContent();
        new Page(quiz.Quizname, this, content, false);
    }

    public void renderContent(){
        content.removeAll();
        BoxLayout contentLayout = new BoxLayout(content, BoxLayout.Y_AXIS);
        content.setLayout(contentLayout);
        for(int i = 0; i < quiz.question.size(); i++) {
            Questions q = quiz.question.get(i);
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
            }else{
                WrittenQuestion wq = (WrittenQuestion)q;
                JLabel prompt = new JLabel(wq.Question);
                JTextField answer = new JTextField();
                answer.setColumns(30);
                JPanel option = new JPanel();
                option.add(prompt);
                option.add(answer);
                content.add(option);
            }
            content.add(Box.createRigidArea(new Dimension(0,20)));
        }
        JPanel actions = new JPanel();
        JButton createMcq = new JButton("Add MCQ Question");
        createMcq.addActionListener(e ->{
            ButtonGroup bg = new ButtonGroup();

            JRadioButton btn1 = new JRadioButton();
            JRadioButton btn2 = new JRadioButton();
            JRadioButton btn3 = new JRadioButton();
            JRadioButton btn4 = new JRadioButton();

            JPanel p1 = new JPanel();
            JPanel p2 = new JPanel();
            JPanel p3 = new JPanel();
            JPanel p4 = new JPanel();

            JTextField t0 = new JTextField();
            JTextField t1 = new JTextField();
            JTextField t2 = new JTextField();
            JTextField t3 = new JTextField();
            JTextField t4 = new JTextField();

            t1.setColumns(13);
            t2.setColumns(13);
            t3.setColumns(13);
            t4.setColumns(13);

            p1.add(btn1);
            p1.add(t1);
            p2.add(btn2);
            p2.add(t2);
            p3.add(btn3);
            p3.add(t3);
            p4.add(btn4);
            p4.add(t4);

            bg.add(btn1);
            bg.add(btn2);
            bg.add(btn3);
            bg.add(btn4);

            input.add(t0);
            input.add(p1);
            input.add(p2);
            input.add(p3);
            input.add(p4);
            JButton add = new JButton("Add Question");
            add.addActionListener(event ->{
                String correctAnswer = "";
                if(btn1.isSelected()){
                    correctAnswer = t1.getText();
                }
                if(btn2.isSelected()){
                    correctAnswer = t2.getText();
                }
                if(btn3.isSelected()){
                    correctAnswer = t3.getText();
                }
                if(btn4.isSelected()){
                    correctAnswer = t4.getText();
                }
                Mcqquestions mcq = new Mcqquestions(t0.getText(),correctAnswer,t1.getText(), t2.getText(), t3.getText(), t4.getText());
                quiz.add(mcq);
                input.removeAll();
                renderContent();
            });
            input.add(add);
            input.revalidate();
            input.repaint();
        });
        JButton createWritten = new JButton("Add Written Question");
        createWritten.addActionListener(e -> {
            JTextField t0 = new JTextField();
            JTextField t1 = new JTextField();
            input.add(t0);
            input.add(t1);
            JButton addQuestion = new JButton("Add Question");
            addQuestion.addActionListener(event ->{
                WrittenQuestion q = new WrittenQuestion(t0.getText(), t1.getText());
                quiz.add(q);
                input.removeAll();
                renderContent();
            });
            input.add(addQuestion);
            input.revalidate();
            input.repaint();
        });
        actions.add(createMcq);
        actions.add(createWritten);
        content.add(actions);
        content.add(input);
        JButton button = new JButton("Finish");
        button.addActionListener(e ->{
            Window.getInstance().setScreen(new ViewCourses());
        });
        content.add(button);
        content.revalidate();
        content.repaint();
    }
}
