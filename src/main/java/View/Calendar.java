package View;

import View.Components.Page;
import engine.Doctor;
import engine.Student;
import engine.TA;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Calendar extends JPanel {

    String days[] = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
    String months[] = {"Jan", "Feb", "Mar", "April", "May", "Jun", "July", "Aug", "Sep", "Oct", "Nov", "Dec"};
    JPanel calendar;
    JLabel currentMonth;
    LocalDate startingDate;

    public Calendar(){
        JPanel content = new JPanel();
        content.setLayout(new BorderLayout());

        Date today = new Date();
        startingDate = LocalDate.now().minusDays(today.getDate() - 1);

        JPanel monthControl = new JPanel();
        JButton prev = new JButton("Prev");
        prev.addActionListener(e ->{
            startingDate = startingDate.minusDays(1);
            startingDate = startingDate.minusDays(startingDate.getDayOfMonth() - 1);
            System.out.println(startingDate.getDayOfMonth());
            System.out.println(startingDate.getDayOfWeek());
            System.out.println(startingDate.getDayOfWeek().getValue());
            currentMonth.setText(months[startingDate.getMonth().getValue() -1]);
            renderCalendar();
            this.revalidate();
            this.repaint();
        });
        currentMonth = new JLabel(months[startingDate.getMonth().getValue() - 1]);
        JButton next = new JButton("Next");
        next.addActionListener(e ->{
            startingDate = startingDate.plusDays(32);
            startingDate = startingDate.minusDays(startingDate.getDayOfMonth() - 1);
            System.out.println(startingDate.getDayOfMonth());
            System.out.println(startingDate.getDayOfWeek());
            System.out.println(startingDate.getDayOfWeek().getValue());
            currentMonth.setText(months[startingDate.getMonth().getValue() -1]);
            renderCalendar();
            this.revalidate();
            this.repaint();
        });
        monthControl.add(prev);
        monthControl.add(currentMonth);
        monthControl.add(next);
        content.add(monthControl, BorderLayout.NORTH);

        calendar = new JPanel();
        GridLayout grid = new GridLayout(6, 7);
        grid.setHgap(1);
        grid.setVgap(1);
        calendar.setLayout(grid);
        renderCalendar();
        content.add(calendar, BorderLayout.CENTER);

        new Page("My Calendar", this, content, false);
    }

    private void renderCalendar(){
        calendar.removeAll();
        int startingDayofWeek = startingDate.getDayOfWeek().getValue() - 1;
        for(int i = 0; i < 7; i++){
            JLabel label = new JLabel(days[i]);
            label.setAlignmentX(JLabel.CENTER_ALIGNMENT);
            calendar.add(label);
        }
        for(int i = 0; i < startingDayofWeek; i++){
            calendar.add(new CalendarDay(null));
        }
        int currentMonth = startingDate.getMonth().getValue();
        ArrayList<engine.Calendar> dates = new ArrayList<>();
        if( Window.getInstance().currentUser.isStudent()){
            Student s = (Student)Window.getInstance().currentUser;
            dates = s.calendar();
        }else if( Window.getInstance().currentUser.isTA()) {
            TA s = (TA) Window.getInstance().currentUser;
             dates = s.calendar();
        }else if(Window.getInstance().currentUser.isDoctor()){
            Doctor s = (Doctor)Window.getInstance().currentUser;
            dates = s.calendar();
        }
        int j = 0;
        LocalDate currentDate = startingDate;
        while(currentMonth == currentDate.getMonth().getValue()){
            boolean isDone = false;
            try{
                Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(dates.get(j).Date);
                if(currentDate.isEqual(date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate())){
                    calendar.add(new CalendarDay(String.valueOf(currentDate.getDayOfMonth()), dates.get(j).Coursename));
                    j++;
                    isDone = true;
                }
            }catch(Exception e){
                e.printStackTrace();
            }
            if(!isDone)
                calendar.add(new CalendarDay(String.valueOf(currentDate.getDayOfMonth())));
            currentDate = currentDate.plusDays(1);
        }
    }
}

class CalendarDay extends JPanel{
    public CalendarDay(String name){
        if(name != null){
            this.setBackground(Color.WHITE);
            this.setLayout(new GridBagLayout());
            this.add(new JLabel(name));
        }
    }
    public CalendarDay(String name, String CourseCode){
        if(name != null){
            this.setBackground(Color.WHITE);
            this.setLayout(new GridBagLayout());
            JPanel container = new JPanel();
            container.setBackground(Color.white);
            container.add(new JLabel(name));
            container.add(new JLabel(CourseCode));
            this.add(container);
        }
    }
}
