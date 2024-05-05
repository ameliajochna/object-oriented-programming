import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

class SamochodComponent extends JComponent {
    private final JTextField iloscMiejscField = new JTextField(10);
    private final JTextField rokProdukcjiField = new JTextField(10);
    private final JTextField markaField = new JTextField(10);
    private final JTextField iloscDrzwiField = new JTextField(10);
    private final JTextField rodzajNapeduField = new JTextField(10);
    private final JTextField nrRejestracjiField = new JTextField(10);

    public SamochodComponent() {
        setLayout(new GridLayout(7, 2));

        addLabelAndField("Ilosc miejsc:", iloscMiejscField);
        addLabelAndField("Rok produkcji:", rokProdukcjiField);
        addLabelAndField("Marka:", markaField);
        addLabelAndField("Ilosc drzwi:", iloscDrzwiField);
        addLabelAndField("Rodzaj napedu:", rodzajNapeduField);
        addLabelAndField("Numer rejestracji:", nrRejestracjiField);

        JButton saveButton = new JButton("Zapisz");
        saveButton.addActionListener(this::saveSamochod);
        add(saveButton);
    }

    private void addLabelAndField(String labelText, JTextField field) {
        JLabel label = new JLabel(labelText);
        add(label);
        add(field);
    }

    private void saveSamochod(ActionEvent e) {
        try {
            int iloscMiejsc = Integer.parseInt(iloscMiejscField.getText());
            int rokProdukcji = Integer.parseInt(rokProdukcjiField.getText());
            String marka = markaField.getText();
            int iloscDrzwi = Integer.parseInt(iloscDrzwiField.getText());
            String rodzajNapedu = rodzajNapeduField.getText();
            String nrRejestracji = nrRejestracjiField.getText();

            if (iloscMiejsc <= 0 || rokProdukcji <= 0 || iloscDrzwi <= 0) {
                throw new IllegalArgumentException("Nieprawidlowa wartosc ilosci miejsc, roku produkcji lub ilosci drzwi.");
            }

            Samochod samochod = new Samochod(iloscMiejsc, rokProdukcji, marka, iloscDrzwi, rodzajNapedu, nrRejestracji);
            System.out.println("Zapisano samochod: " + samochod);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Nieprawidlowy format danych liczbowych.", "Blad", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Blad", JOptionPane.ERROR_MESSAGE);
        }
    }
}
