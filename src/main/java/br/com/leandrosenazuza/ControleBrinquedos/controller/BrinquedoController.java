package br.com.leandrosenazuza.ControleBrinquedos.controller;

import br.com.leandrosenazuza.ControleBrinquedos.dto.BrinquedoDTO;
import br.com.leandrosenazuza.ControleBrinquedos.model.Brinquedo;
import br.com.leandrosenazuza.ControleBrinquedos.repository.BrinquedoRepository;
import br.com.leandrosenazuza.ControleBrinquedos.service.BrinquedoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/brinq")
public class BrinquedoController {

    final BrinquedoService brinquedoService;
    private final BrinquedoRepository brinquedoRepository;

    public BrinquedoController(BrinquedoService brinquedoService,
                               BrinquedoRepository brinquedoRepository){
        this.brinquedoService = brinquedoService;
        this.brinquedoRepository = brinquedoRepository;
    }

    @PostMapping
    public String criarBrinquedo(@RequestBody BrinquedoDTO brinquedoDTO){
        Brinquedo brinquedoAux = new Brinquedo();
        try{
            brinquedoAux.setNome_brinquedo(brinquedoDTO.getNome_brinquedo());
            brinquedoService.persistirBrinquedoService(brinquedoAux);
            return "Persistido com sucesso";
        }catch (Exception e){
            return "Algum erro ocorreu";
        }
    }

    //Selecionar apenas um objeto
    @GetMapping("/{id}")
    public Optional<Brinquedo> consultarBrinquedo(@PathVariable(value = "id") int id){
        Brinquedo brinquedoAux = new Brinquedo();
        return brinquedoService.buscarBrinquedoService(id);
    }

    @GetMapping("/todos")
    public List<Brinquedo> buscarTodosBrinquedos(){
        return brinquedoService.buscarTodosBrinquedosService();
    }

    @PutMapping("/{id}")
    public String alterarBrinquedo(@PathVariable(value = "id") int id, @RequestBody BrinquedoDTO brinquedoDTO){
        Optional<Brinquedo> brinquedoAux;
        Boolean verificadorDeSucessoDaAltecao = false;
        brinquedoAux = brinquedoService.buscarBrinquedoService(id);
        if(brinquedoAux == null){
            return "Não há brinquedo com essa identificacao";
        }
        else{
            try{
                verificadorDeSucessoDaAltecao = brinquedoService.alterarBrinquedoService(id, brinquedoDTO);
                if(!verificadorDeSucessoDaAltecao){
                    return "Algo deu errado na insercao";
                }
                else{return "Registro Alterado";}
            }catch (Exception e){
                return "Algo ocorreu";
            }
        }
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable(value = "id") int id){
        Optional<Brinquedo> brinquedoAux;
        brinquedoAux = brinquedoService.buscarBrinquedoService(id);
        if(brinquedoAux == null){
            return "Não há brinquedo com essa identificacao";
        }

        Boolean validadorDelete;
        try{
            validadorDelete = brinquedoService.deletarRegistroBrinquedo(id);
            if(validadorDelete) return "Registro Deletado";
            else return "Ocorreu algum erro";
        }catch(Exception e){
            return "Algum erro ocorreu";
        }

    }
}
