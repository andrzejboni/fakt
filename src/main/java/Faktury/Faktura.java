package Faktury;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Faktura {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    // identity - pobiera id, nastęonir przyjmuje wartość
    //
    private Long id;

    private String daneNabywcy;
    private String daneSprzedawcy;
    private int kwota;
    private String dataWystawienia;
    private String produkt;
    private int ilosc;
    private double stawkaPodatku;

}

