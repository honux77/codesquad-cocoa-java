import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonClickListener implements ActionListener {

    //button click handler
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("OS is not Operating System:" + e);
    }

    
}