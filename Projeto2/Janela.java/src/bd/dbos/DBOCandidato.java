package bd.dbos;
import java.sql.*;

public class DBOCandidato implements Cloneable{
    private String nomeCandidato;
    private int numCandidato;
    private String partido;
    private int numCargo;

    public String getNomeCandidato(){
        return nomeCandidato;
    }

    public int getNumCandidato() {
        return numCandidato;
    }

    public String getPartido() {
        return partido;
    }

    public int getNumCargo() {
        return numCargo;
    }


    public void setNomeCandidato(String nomeCandidato) throws Exception
    {
        if(nomeCandidato.equals("") || nomeCandidato == null )
        {
            throw new Exception ("[ERRO]: Nome do candidato não fornecido");
        }
            this.nomeCandidato = nomeCandidato;
    }

    public void setNumCandidato(int numCandidato) throws Exception
    {
        if(numCandidato <= 0 )
        {
            throw new Exception ("[ERRO]: Número do candidato inválido");
        }
        this.numCandidato = numCandidato;
    }

    public void setPartido(String partido) throws  Exception
    {
        if(partido.equals("") || partido == null )
        {
            throw new Exception ("[ERRO]: Partido não fornecido");
        }
        this.partido = partido;
    }

    public void setNumCargo(int numCargo) throws Exception
    {
        if(numCandidato <= 0 )
        {
            throw new Exception ("[ERRO]: Número do cargo inválido");
        }
        this.numCargo = numCargo;
    }


    public DBOCandidato(String nome, int nCandidato, String partido, int nCargo)
    {
        try
        {
            this.setNomeCandidato(nome);
            this.setNumCandidato(nCandidato);
            this.setPartido(partido);
            this.setNumCargo(nCargo);
        }
        catch (Exception erro)
        {
            System.err.println(erro.getMessage());
        }

    }

    public String toString ()
    {
        String ret="";

        ret+="Candidato: "+this.nomeCandidato+"\n";
        ret+="Número candidato: "+this.numCandidato  +"\n";
        ret+="Partido: "+this.partido +"\n";
        ret+="Número cargo: "+this.numCargo +"\n";

        return ret;
    }

    public boolean equals (Object obj)
    {
        if (this==obj)
            return true;

        if (obj==null)
            return false;

        if (!(obj instanceof DBOCandidato))
            return false;

        DBOCandidato cand = (DBOCandidato)obj;

        if (this.numCandidato!=cand.numCandidato)
            return false;

        if (this.nomeCandidato.equals(cand.nomeCandidato))
            return false;

        if (this.numCargo!=cand.numCargo)
            return false;

        if (this.partido.equals(cand.partido))
            return false;


        return true;
    }

    public int hashCode ()
    {
        int ret=666;

        ret = 7*ret + Integer.valueOf(this.numCandidato).hashCode();
        ret = 7*ret + Integer.valueOf(this.numCargo).hashCode();
        ret = 7*ret + this.nomeCandidato.hashCode();
        ret = 7*ret + this.partido.hashCode();

        return ret;
    }

    public DBOCandidato (DBOCandidato modelo) throws Exception
    {
        this.nomeCandidato  = modelo.nomeCandidato;
        this.numCandidato   = modelo.numCandidato;
        this.partido        = modelo.partido;
        this.numCargo       = modelo.numCargo;
    }

    public Object clone ()
    {
        DBOCandidato ret=null;

        try
        {
            ret = new DBOCandidato (this);
        }
        catch (Exception erro)
        {}

        return ret;
    }
}
