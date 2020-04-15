package dataset;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Messages")
public class MessageDataSet implements Serializable {
    private static final long serialVersionUID = -8706689714326132798L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "message", unique = false, updatable = false)
    private String message;

    public MessageDataSet() {
    }

    public MessageDataSet(String message) {
        this.setId(-1);
        this.setMessage(message);
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getId() {
        return id;
    }
}
