package thainyvitareli.desafioprojetospring.model;

import jakarta.persistence.*;
import lombok.*;


@ToString
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name="tb_cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String nome;

    @ManyToOne
    private Endereco endereco;
}
