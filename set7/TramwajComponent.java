import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

class TramwajComponent extends JComponent {
    private final JTextField iloscMiejscField = new JTextField(10);
    private final JTextField rokProdukcjiField = new JTextField(10);
    private final JTextField markaField = new JTextField(10);
    private final JTextField liniaField = new JTextField(10);
    private final JCheckBox czyWykolejenieCheckBox = new JCheckBox();
    private final JTextField kolorField = new JTextField(10);

    public TramwajComponent() {
        setLayout(new GridLayout(7, 2));

        addLabelAndField("Ilosc miejsc:", iloscMiejscField);
        addLabelAndField("Rok produkcji:", rokProdukcjiField);
        addLabelAndField("Marka:", markaField);
        addLabelAndField("Linia:", liniaField);

        JLabel czyWykolejenieLabel = new JLabel("Czy wykolejenie:");
        add(czyWykolejenieLabel);
        add(czyWykolejenieCheckBox);

        addLabelAndField("Kolor:", kolorField);

        JButton saveButton = new JButton("Zapisz");
        saveButton.addActionListener(this::saveTramwaj);
        add(saveButton);
    }

    private void addLabelAndField(String labelText, JTextField field) {
        JLabel label = new JLabel(labelText);
        add(label);
        add(field);
    }

    private void saveTramwaj(ActionEvent e) {
        try {
            int iloscMiejsc = Integer.parseInt(iloscMiejscField.getText());
            int rokProdukcji = Integer.parseInt(rokProdukcjiField.getText());
            String marka = markaField.getText();
            String linia = liniaField.getText();
            boolean czyWykolejenie = czyWykolejenieCheckBox.isSelected();
            String kolor = kolorField.getText();

            if (iloscMiejsc <= 0 || rokProdukcji <= 0) {
                throw new IllegalArgumentException("Nieprawidlowa wartosc ilosci miejsc lub roku produkcji.");
            }

            Tramwaj tramwaj = new Tramwaj(iloscMiejsc, rokProdukcji, marka, linia, czyWykolejenie, kolor);
            System.out.println("Zapisano tramwaj: " + tramwaj);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Nieprawidlowy format danych liczbowych.", "Blad", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Blad", JOptionPane.ERROR_MESSAGE);
        }
    }
}
