package entities;

public class PessoaJuridica extends Pessoa{

    private Integer numeroFuncionarios;

    public PessoaJuridica(){
        super();
    }

    public PessoaJuridica(String name, Double rendaAnual, Integer numeroFuncionarios) {
        super(name, rendaAnual);
        this.numeroFuncionarios = numeroFuncionarios;
    }

    public Integer getNumeroFuncionarios() {
        return numeroFuncionarios;
    }

    public void setNumeroFuncionarios(Integer numeroFuncionarios) {
        this.numeroFuncionarios = numeroFuncionarios;
    }

    @Override
    public Double calculoImposto() {
        if(getNumeroFuncionarios() > 10){
            return getRendaAnual() * 0.14;
        }else{
            return getRendaAnual() * 0.16;
        }
    }
}
