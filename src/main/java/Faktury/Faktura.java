package Faktury;

import lombok.*;

import javax.persistence.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Faktura extends  BaseEntity{
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

    @ManyToOne(fetch = FetchType.LAZY)
    private Firma firma;



}

