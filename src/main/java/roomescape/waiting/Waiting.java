package roomescape.waiting;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import roomescape.theme.Theme;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Waiting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Theme theme;
    private Long memberId;
    private String date;
    private  String time;

    public Waiting(Theme theme, Long memberId, String date, String time) {
        this.theme = theme;
        this.memberId = memberId;
        this.date = date;
        this.time = time;
    }


    public boolean isMyReservation(Long memberId) {
        return this.memberId.equals(memberId);
    }
}