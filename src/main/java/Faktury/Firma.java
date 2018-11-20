package Faktury;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Entity
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class Firma {
        @Id
        @GeneratedValue(strategy = GenerationType.TABLE)
        private Long id;

        private String nazwa;

        private String nip;

        private String adres;

    // one (this class object ) to many (some class Objects below)
    @OneToMany(mappedBy = "firma", fetch = FetchType.EAGER)
    private List<Faktura> faktury;


}
