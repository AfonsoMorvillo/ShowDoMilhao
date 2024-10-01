package View;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CronometroPanel extends JPanel {
   private JLabel         tempoLabel;
   private Timer          timer;
   private int            segundosRestantes;
   private InterfaceTempo it;

   public CronometroPanel() {
      setLayout( new BorderLayout() );

      tempoLabel = new JLabel();
      tempoLabel.setHorizontalAlignment( SwingConstants.CENTER );
      tempoLabel.setFont( new Font( "Arial", Font.BOLD, 24 ) );
      // tempoLabel.setForeground(Color.WHITE);
      add( tempoLabel, BorderLayout.CENTER );

      timer = new Timer( 1000, new ActionListener() {
         public void actionPerformed( ActionEvent e ) {
            segundosRestantes--;
            if( segundosRestantes >= 0 ){
               int minutos = segundosRestantes / 60;
               int segundos = segundosRestantes % 60;
               tempoLabel.setText( String.format( "%02d:%02d", minutos, segundos ) );
            }
            else{

               it.terminaJogo();
               timer.stop();
            }
         }
      } );

      iniciarContagem();
   }


   public void iniciarContagem() {
      segundosRestantes = 120;
      timer.start();
   }


   public void tempoEsgotado() {
      JOptionPane.showMessageDialog( this, "O tempo acabou, voce perdeu", "Tempo Esgotado", JOptionPane.INFORMATION_MESSAGE );

   }


   public void setIt( InterfaceTempo it ) {
      this.it = it;
   }


   public void stop() {
      timer.stop();
   }

}
