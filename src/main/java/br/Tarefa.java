package br;

/**
 *
 * @author felps
 */
import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Tarefa {
    private String descricao;
    private Date data;

    public Tarefa() {
    }

    public Tarefa(String descricao) {
        this.descricao = descricao;
        this.data = new Date();
    }

    public Tarefa(String descricao, Date data) {
        this.descricao = descricao;
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return descricao + "(Data:" + data + ")";
    }
}
