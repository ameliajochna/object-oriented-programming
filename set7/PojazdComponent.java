import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

class PojazdComponent extends JComponent {
    protected final JTextField iloscMiejscField = new JTextField(10);
    protected final JTextField rokProdukcjiField = new JTextField(10);
    protected final JTextField markaField = new JTextField(10);

    public PojazdComponent() {
        setLayout(new GridLayout(4, 2));

        addLabelAndField("Ilosc miejsc:", iloscMiejscField);
        addLabelAndField("Rok produkcji:", rokProdukcjiField);
        addLabelAndField("Marka:", markaField);

        JButton saveButton = new JButton("Zapisz");
        saveButton.addActionListener(this::savePojazd);
        add(saveButton);
    }

    protected void addLabelAndField(String labelText, JTextField field) {
        JLabel label = new JLabel(labelText);
        add(label);
        add(field);
    }

    protected void savePojazd(ActionEvent e) {
        try {
            int iloscMiejsc = Integer.parseInt(iloscMiejscField.getText());
            int rokProdukcji = Integer.parseInt(rokProdukcjiField.getText());
            String marka = markaField.getText();

            if (iloscMiejsc <= 0 || rokProdukcji <= 0) {
                throw new IllegalArgumentException("Nieprawidlowa wartosc ilosci miejsc lub roku produkcji.");
            }

            Pojazd pojazd = new Pojazd(iloscMiejsc, rokProdukcji, marka);
            System.out.println("Zapisano pojazd: " + pojazd);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Nieprawidlowy format danych liczbowych.", "Blad", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Blad", JOptionPane.ERROR_MESSAGE);
        }
    }
}
